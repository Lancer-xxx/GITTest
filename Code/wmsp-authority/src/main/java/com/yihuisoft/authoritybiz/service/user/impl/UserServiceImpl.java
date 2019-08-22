package com.yihuisoft.authoritybiz.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.authoritybiz.constant.AppConsts;
import com.yihuisoft.authoritybiz.constant.ReturnConsts;
import com.yihuisoft.authoritybiz.dto.user.*;
import com.yihuisoft.authoritybiz.entity.organization.Organization;
import com.yihuisoft.authoritybiz.entity.role.Role;
import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.authoritybiz.mapper.role.RoleRelatedMapper;
import com.yihuisoft.authoritybiz.mapper.user.UserMapper;
import com.yihuisoft.authoritybiz.service.organization.OrganizationService;
import com.yihuisoft.authoritybiz.service.user.UserService;
import com.yihuisoft.common.annotation.ServiceLog;
import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.constant.DataPermissionEnum;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.common.util.DataUtil;
import com.yihuisoft.common.util.MD5;
import com.yihuisoft.common.util.StringUtil;
import com.yihuisoft.common.util.app.CheckUtils;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.util.app.SnowFlakeIdWorker;
import com.yihuisoft.common.vo.PageMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息管理服务层
 * @author huangxj
 * @version V4.0.0
 * @date 2019/6/26 18:20
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleRelatedMapper roleMapper;

    @Autowired
    private OrganizationService organizationService;


    @Override
    public OutDTO getUser(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return OutDTOFactory.getSucceedOutDTO().putInfo(user);
    }

    @Override
    public Map<String,Object> getUserState(String dictTypeCode){
        Map<String,Object> dicmap = new HashMap<>();

        //状态:2-注销, 1-结 ,0-活跃
        dicmap.put("0","活跃");
        dicmap.put("1","冻结");
        dicmap.put("2","注销");
        return dicmap;
    }

    @Override
    public OutDTO getUserByOrgn(UserListDTO user) {
        List<User> userlist;
        try{
            userlist = userMapper.getUserByOrgn(user.getOrgnCode());
        }catch (Exception e){
            logger.error("根据机构查询其下人员信息异常！");
            e.printStackTrace();
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg("根据机构查询其下人员信息异常！");
        }
        return OutDTOFactory.getSucceedOutDTO().putList(userlist);
    }

    @Override
    public OutDTO listUsers(UserListDTO userListDTO, PageMessage pageMessage) {
        // 检查分页信息
        pageMessage = PageMessage.check(pageMessage);
        PageHelper.startPage(pageMessage.getPageNo(), pageMessage.getPageSize());

        Map<String,Object> userMap = new HashMap<>();
        try {
            userMap = DataUtil.Object2Map(userListDTO);
        } catch (IllegalAccessException e) {
            logger.error("列表查询时，用户分页实体（UserListDTO）转换为map异常！");
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg("人员列表查询失败！");
        }

        List<User> list;
        try{
            list = userMapper.getUserList(userMap);
        }catch (Exception e){
            logger.error("查询人员信息列表异常！");
            e.printStackTrace();
            throw new ApplicationException("查询人员信息列表异常！",e);
        }

        PageInfo<User> page = new PageInfo<>(list);

        if(!ObjectUtils.isEmpty(list)){
            List<Map<String,Object>>  listRes = new ArrayList<>();
            Map<String, Object> userState = getUserState("userState");
            for(User userob:list){
                Map<String,Object> obmap = new HashMap<>();
                try {
                    obmap =  DataUtil.Object2Map(userob);
                    obmap.put("statusRes",userState.get(userob.getStatus()));
                } catch (IllegalAccessException e) {
                    logger.error("人员列表数据转换为map异常！");
                    return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg("人员列表查询失败！");
                }

                obmap.put("id",obmap.get("id").toString());

                listRes.add(obmap);
            }
            return OutDTOFactory.getSucceedOutDTO().putList(listRes).setSumCount(page.getTotal());
        }

        // 返回list数据和总数
        return OutDTOFactory.getSucceedOutDTO().putList(list).setSumCount(page.getTotal());
    }

    /**
     * 重置人员密码
     * @param userResetDTO
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    @ServiceLog(decription = "重置人员密码",businessType = "1")
    @Override
    public OutDTO resetUserPassword(UserResetDTO userResetDTO) {
        // DTO转为操作数据库的实体
        User user = new User();
        CopyUtils.copy(userResetDTO, user);
        int result = userMapper.resetPassWord(user);
        return CheckUtils.checkUpdate(result);
    }


    @Transactional(rollbackFor=Exception.class)
    @ServiceLog(decription = "新增人员信息数据接口",businessType = "1")
    @Override
    public OutDTO saveUser(UserInsertDTO userInsertDTO) throws ApplicationException{
        // DTO转为操作数据库的实体
        User user = new User();
        CopyUtils.copy(userInsertDTO,user);
        String initPwd ="123456";
        user.setUserpwd(MD5.encodeMd5(initPwd));
        Long userId = SnowFlakeIdWorker.generateId();
        if(ObjectUtils.isEmpty(userId)){
            throw new ApplicationException("新增人员生成角色id失败！");
        }
        user.setId(userId);

        //二次查重校验
        OutDTO duplicateOutDTO = duplicateChecking(user);
        if((OutDTOFactory.RESULT_EXIST)== (int)duplicateOutDTO.get(OutDTOFactory.RESULT_KEY)){
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg(duplicateOutDTO.getErrorMsg());
        }

        // 根据机构编码查询机构ID
        Organization organization = organizationService.getOrganizationInfo(user.getOrgnCode());
        if(organization != null) {
            user.setOrgnId(organization.getId());
        }
        try{
            userMapper.insertSelective(user);
        }catch (Exception e){
            logger.error("用户信息插入异常！");
            e.printStackTrace();
            throw new ApplicationException("用户信息插入异常！",e);
        }

        return OutDTOFactory.getSucceedOutDTO();
    }


    @Transactional(rollbackFor=Exception.class)
    @ServiceLog(decription = "修改人员信息数据接口",businessType = "1")
    @Override
    public OutDTO updateUser(UserUpdateDTO userupdatedto) {
        // DTO转为操作数据库的实体
        User user = new User();
        CopyUtils.copy(userupdatedto,user);

        //二次查重校验唯一性（排除自身）：用户工号、证件号、电话号码
        OutDTO duplicateOutDTO = duplicateChecking(user);
        if((OutDTOFactory.RESULT_EXIST)== (int)duplicateOutDTO.get(OutDTOFactory.RESULT_KEY)){
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg(duplicateOutDTO.getErrorMsg());
        }

        int result = userMapper.updateByPrimaryKeySelective(user);
        return CheckUtils.checkUpdate(result);
    }

    @Override
    public OutDTO checkUserExist(UserCheckDTO userCheckDTO) {
        // DTO转为操作数据库的实体
        User user = new User();
        CopyUtils.copy(userCheckDTO,user);
        return duplicateChecking(user);
    }

    /**
      * 二重校验供新增和更新服务调用
      * @author topz
      * @param user 用户传入参数
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 13:28 2019/7/26
      **/
    OutDTO duplicateChecking(User user){
        List<User> list = userMapper.getUserExist(user);
        //查重校验（id） ：workNo  phone  idNo
        if(ObjectUtils.isEmpty(user.getId())){
            //id 为空则为新增验证
            if(ObjectUtils.isEmpty(list)){
                logger.info("新增用户校验工号、电话号码、身份证信息无重复！");
                return OutDTOFactory.getSuccessOutDTONotExist();
            }else{
                //查重校验
                return valueChecking(list,user);
            }
        }else{
            // id 不为空 则为更新校验
            for(int i=list.size()-1;i>=0;i--){
                if(list.get(i).getId().equals(user.getId())){
                    list.remove(i);
                }
            }
            if(ObjectUtils.isEmpty(list)){
                logger.info("更新用户校验工号、电话号码、身份证信息无重复！");
                return OutDTOFactory.getSuccessOutDTONotExist();
            }else{
                //查重校验
                return valueChecking(list,user);
            }
        }

    }

    /**
      * 工号、电话号码、身份证信息是否重复
      * @author topz
      * @param list 传入重复集合
      * @param user 传入用户参数
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 13:16 2019/7/26
      **/
    OutDTO valueChecking(List<User> list,User user){
        StringBuilder sb = new StringBuilder();
        //标记工号是否重复
        boolean workNoFlag =false;
        //标记身份证号是否重复
        boolean idNoFlag =false;
        //标记电话号码是否重复
        boolean phoneFlag =false;
        for(User userob:list){
            if(userob.getWorkNo().equals(user.getWorkNo())){
                workNoFlag=true;
            }
            if(userob.getIdNo().equals(user.getIdNo())){
                idNoFlag =true;
            }
            if(userob.getPhone().equals(user.getPhone())){
                phoneFlag =true;
            }
        }
        if(workNoFlag){
            sb.append("工号");
        }
        if(idNoFlag){
            sb.append("身份证号");
        }
        if(phoneFlag){
            sb.append("电话号码");
        }
        sb.append("已存在！");
        logger.info(sb.toString());
        return OutDTOFactory.getSuccessOutDTOExist().setErrorMsg(sb.toString());
    }



    /**
     * 人员信息导出
     * @param userListDTO
     * @return
     */
    @Override
    public List<User> getUserByItem(UserListDTO userListDTO) {
        // DTO转为操作数据库的实体
        User user = new User();
        CopyUtils.copy(userListDTO, user);
        return userMapper.getUserByItem(user);
    }

    @ServiceLog(decription = "浙泰指纹仪需要机构号，根据用户代码查找用户机构代码",businessType = "1")
    @Override
    public OutDTO getUserOrganization(UserGetInfoDTO userGetInfoDTO) {
        OutDTO outDTO = OutDTOFactory.getSucceedOutDTO();
        User user = userMapper.getBankUserLogin(userGetInfoDTO.getUserCode());
        if (user != null) {
            outDTO.put(ReturnConsts.RESULT_USER_ORGANIZATION_CODE, user.getOrgnCode());
        } else {
            outDTO.put(ReturnConsts.RESULT_USER_ORGANIZATION_CODE, AppConsts.DATA_EMPTY);
        }
        return outDTO;
    }

    @Override
    public OutDTO getUserInfoRoleInfoByParam(UserGetInfoDTO userGetInfoDTO){
        // 根据userCode查询用户信息
        User user= userMapper.selectByUserCode(userGetInfoDTO.getUserCode());
        // 根据用户信息中的roleId查询角色信息
        Role role = new Role();
        if(user != null && user.getRoleId() != null ){
            role = roleMapper.findRoleById(user.getRoleId());
        }
        OutDTO outDTO = OutDTOFactory.getSucceedOutDTO();
        outDTO.put(ReturnConsts.RESULT_USER_INFO, user);
        outDTO.put(ReturnConsts.RESULT_ROLE_INFO, role);
        return outDTO;
    }

    /**
     * 获取登录过的用户数据信息
     * @return
     */
    @Override
    public User getContextUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String userId = request.getHeader("userId");
        if(userId == null){
            throw new ApplicationException(ResultEnum.AUTHORITY_IS_INCORRECT);
        }

        User user =  (User) this.getUser(Long.parseLong(userId)).getInfoData();
        return user;
    }

    @Override
    public List<User> getUsersByDataAuthority(DataAuthUserDTO dataAuthUserDTO,Map<String,String> dataAuthMap) {

        List<User> userList = null;

        //调用此方法毕传参数为当前用户权限
        if(StringUtil.isEmpty(dataAuthUserDTO.getCurrentDataAuth())){
            logger.info("通过数据权限权限查询当前用户 ==> 传入当前用户数据权限参数不能为空！");
            return userList;
        }
        if(ObjectUtils.isEmpty(dataAuthUserDTO.getId())){
            logger.info("通过数据权限查询当前用户(本人权限) ==> 传入当前用户id参数不能为空！");
            return userList;
        }
        if(ObjectUtils.isEmpty(dataAuthUserDTO.getOrgnId())){
            logger.info("通过数据权限查询当前用户(本人权限) ==> 传入当前用户所属机构id参数不能为空！");
            return userList;
        }
        if(StringUtil.isEmpty(dataAuthUserDTO.getOrgnInheritSign())){
            logger.info("通过数据权限查询当前用户(本人权限) ==> 传入当前用户所属机构序列号参数不能为空！");
            return userList;
        }

        try{
            userList = userMapper.getUsersByDataAuthority(dataAuthUserDTO, dataAuthMap);
            if(ObjectUtils.isEmpty(userList)){
                logger.error("通过数限权限查询当前用户信息为空！");
                throw new ApplicationException("通过数限权限查询当前用户信息为空！",new Exception("通过数限权限查询当前用户信息为空！"));
            }
        }catch (Exception e){
            logger.error("通过数据权限查询当前用户发生异常！");
            throw new ApplicationException("通过数据权限查询当前用户发生异常！",e);
        }
        return userList;
    }

}