package com.yihuisoft.authoritybiz.service.login.impl;

import com.yihuisoft.authoritybiz.constant.RedisConstantsKey;
import com.yihuisoft.authoritybiz.dto.login.LoginDTO;
import com.yihuisoft.authoritybiz.dto.login.LogoutDTO;
import com.yihuisoft.authoritybiz.entity.menu.Menu;
import com.yihuisoft.authoritybiz.entity.menu.RoleMenuDO;
import com.yihuisoft.authoritybiz.entity.organization.Organization;
import com.yihuisoft.authoritybiz.entity.role.Role;
import com.yihuisoft.authoritybiz.entity.terminal.Terminal;
import com.yihuisoft.authoritybiz.entity.token.LoginUser;
import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.authoritybiz.mapper.menu.MenuMapper;
import com.yihuisoft.authoritybiz.mapper.organization.OrganizationMapper;
import com.yihuisoft.authoritybiz.mapper.role.RoleRelatedMapper;
import com.yihuisoft.authoritybiz.mapper.terminal.TerminalRelatedMapper;
import com.yihuisoft.authoritybiz.mapper.user.UserMapper;
import com.yihuisoft.authoritybiz.service.discache.DistributeCacheService;
import com.yihuisoft.authoritybiz.service.login.UserLoginService;
import com.yihuisoft.authoritybiz.service.menu.MenuService;
import com.yihuisoft.authoritybiz.service.organization.OrganizationService;
import com.yihuisoft.authoritybiz.service.token.TokenService;
import com.yihuisoft.common.annotation.ServiceLog;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.common.util.LoggerUtils;
import com.yihuisoft.common.util.StringUtil;
import com.yihuisoft.common.util.app.CheckUtils;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.logbiz.dto.satff.UserLoginLogInDTO;
import com.yihuisoft.logbiz.mapper.login.LoginMapper;
import com.yihuisoft.logbiz.service.UserLoginLogService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 人员登录实现类
 *
 * @author laijd
 * @version V4.0.0
 * @date 2019/7/5
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {
    private static final Logger logger = LoggerFactory.getLogger(UserLoginService.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleRelatedMapper roleRelatedMapper;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private OrganizationMapper organizationMapper;
    @Autowired
    private TerminalRelatedMapper terminalRelatedMapper;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private UserLoginLogService userLoginLogService;

    @Autowired
    private DistributeCacheService distributeCacheService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuService menuService;

    /**
     * 系统登录接口
     *
     * @param loginDTO
     * @return
     */
    @Override
    public OutDTO userLogin(LoginDTO loginDTO) {
        logger.info("ip地址：" + loginDTO.getIp() + "终端号：" + loginDTO.getLogDeviceId());
        // 指纹登录不需要密码，get会报空指针
        //TODO 和前端确认是否可以改成Boolean值
        String userPwd = "";
        if ("true".equals(loginDTO.getIsPasswordLoginFlag())) {
            userPwd = loginDTO.getPassWord();
        }
        User user = userMapper.getBankUserLogin(loginDTO.getUserCode());
        if (user == null) {
            logger.info("user为空值！！");
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_LOGIN_USER_NAME_PASSWORD);
            //验证用户状态
        } else if (!"0".equals(user.getStatus())) {
            logger.info(ResultEnum.ERROR_AUTHORITY_LOGIN_ACCOUNT_DISABLE.getMessage());
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_LOGIN_ACCOUNT_DISABLE);
        }else if ("1008".equals(user.getRoleCode())) {
            //校验当前登陆用户机构是否可用。机构不可用时，不能登陆
            if(checkOrganizationExist(user.getOrgnCode())){
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_LOGIN_ORGANIZATION_NOT_EXIST);
            }
            //如果是系统管理员，直接校验密码
            if (!user.getUserpwd().equals(userPwd)) {
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_LOGIN_USER_NAME_PASSWORD);
            } else {
                logger.info("进入到浏览器登录界面");
                //写登录日志
               // Long logId = addLoginRecord(user, loginDTO.getLogDeviceId(), loginDTO.getMacId());
                //返回登录成功页面
                return loginSuccess(user, null, false);
            }
        } else if ("1".equals(user.getRoleCode())) {
            logger.info(ResultEnum.ERROR_AUTHORITY_LOGIN_ACCOUNT_FORBIDDEN.getMessage());
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_LOGIN_ACCOUNT_FORBIDDEN);
        } else {
            //校验当前登陆用户机构是否可用。机构不可用时，不能登陆
            if(checkOrganizationExist(user.getOrgnCode())){
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_LOGIN_ORGANIZATION_NOT_EXIST);
            }
            // 密码登录调用接口
            if ("true".equals(loginDTO.getIsPasswordLoginFlag())) {
                if (!StringUtil.isEmpty(userPwd) && !userPwd.equals(user.getUserpwd())) {
                    logger.info(ResultEnum.ERROR_AUTHORITY_LOGIN_USER_NAME_PASSWORD.getMessage());
                    return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_LOGIN_USER_NAME_PASSWORD);
                }
                //TODO 指纹登录，逻辑待实现
            } else if ("false".equals(loginDTO.getIsPasswordLoginFlag())) {
                // equipType			指纹仪设备类型
                loginDTO.getCompanyType();
                // fingerprint		指纹特征值
                loginDTO.getFingerPrint();
                // 指纹所有者所属网点
            }
            if ("1".equals(loginDTO.getFlag())) {
                //为终端
                if ("1004".equals(user.getRoleId().toString())) {
                    User use = userMapper.getOrgCodeByUserCode(loginDTO.getUserCode());
                    logger.info("机构号为：" + use.getOrgnCode());
                    if (!"".equals(use.getOrgnCode()) && loginDTO.getIp() != null) {
                        Terminal terminal = new Terminal();
                        terminal.setOrgnCode(use.getOrgnCode());
                        terminal.setTerminalIp(loginDTO.getIp());
                        //TODO 一般只有一条记录
                        List<Terminal> terminalList = terminalRelatedMapper.findOrgnCodeByIp(terminal);
                        terminal = new Terminal();
                        if (!ObjectUtils.isEmpty(terminalList)) {
                            terminal = terminalList.get(0);
                        }
                        if (terminal != null && terminal.getLogDeviceId() != null) {
                            if (StringUtil.isEmpty(terminal.getBankNo()) || StringUtil.isEmpty(terminal.getTellerNo())) {
                                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON)
                                        .setErrorMsg("终端设备未在行内注册，终端号为{" + loginDTO.getLogDeviceId()
                                                + "}，请联系管理员");
                            }
                            String bankNo = terminal.getOrgnCode() + "";
                            String orgnCode = user.getOrgnCode() + "";
                            if (StringUtil.isEmpty(bankNo) && StringUtil.isEmpty(orgnCode) && !bankNo.equals(orgnCode)) {
                                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_LOGIN_ACCOUNT_MANAGER_FORBIDDEN);
                            }
                            if (!"unknown".equals(loginDTO.getIp()) && !loginDTO.getIp().equals(terminal.getTerminalIp())) {
                                Terminal terminal1 = new Terminal();
                                terminal.setTerminalMac(loginDTO.getMacId());
                                terminal.setTerminalIp(loginDTO.getIp());
                                terminal.setLogDeviceId(loginDTO.getLogDeviceId());
                                //内屏换理财经理登录，一个内屏连两个外屏
                                //理财经理换理财机进行登录
                                terminalRelatedMapper.updateTerminal(terminal1);
                            }

                            if (loginDTO.getLogDeviceId().equals(terminal.getLogDeviceId())) {
                                if (!user.getUserpwd().equals(userPwd)) {
                                    return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_LOGIN_USER_NAME_PASSWORD);
                                } else {
                                    //写登录日志

                                    //Long logId = addLoginRecord(user, loginDTO.getLogDeviceId(), loginDTO.getMacId());
                                    //返回登录成功页面
                                    return loginSuccess(user, null, false);
                                }
                            } else {
                                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON)
                                        .setErrorMsg("终端设备未在行内注册，终端号为{" + terminal.getLogDeviceId() + "}，请注册");
                            }
                        } else {
                            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON)
                                    .setErrorMsg("终端设备未在行内注册，终端号为{" + loginDTO.getLogDeviceId() + "}，请联系管理员");
                        }
                    }
                }
            }
            //写登录日志
           // Long logId = addLoginRecord(user, loginDTO.getLogDeviceId(), loginDTO.getMacId());
            return loginSuccess(user, null, true);
        }
    }

    /**
     * 系统登出接口
     *
     * @param logoutDTO
     * @return
     */
    @Override
    public OutDTO signOut(LogoutDTO logoutDTO) {
        OutDTO outDTO = new OutDTO();
        int result = 0;

        try {
            result = loginMapper.signOut(logoutDTO.getLogId());
            //删除对应的缓存信息
            distributeCacheService.delete(String.format(RedisConstantsKey.USER_TOKEN_KEY, logoutDTO.getUserId()));
            distributeCacheService.delete(String.format(RedisConstantsKey.USER_AUTHORITY_RULE_KEY, logoutDTO.getUserId()));
            distributeCacheService.delete(String.format(RedisConstantsKey.USER_LOGIN_INFO_KEY, logoutDTO.getUserId()));

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(ResultEnum.ERROR_SYSTEM_REQUEST);
        }

        return CheckUtils.checkUpdate(result);
    }

    /**
     * 调用日志模块,写入人员登录日志
     *
     * @param user
     * @author: lixiaosong
     * @return:
     * @date: 2019/5/6 12:58
     */
    @ServiceLog(decription = "调用日志模块,写入人员登录日志,", businessType = "1")
    private Long addLoginRecord(User user, String logDeviceId, String macId) {
        UserLoginLogInDTO userLoginLogInDto = new UserLoginLogInDTO();
        CopyUtils.copy(user, userLoginLogInDto);
        userLoginLogInDto.setLoginIp(LoggerUtils.getCliectIp(request));
        userLoginLogInDto.setLogDeviceId(logDeviceId);
        userLoginLogInDto.setTerminalMac(macId);
        userLoginLogService.addLoginRecord(userLoginLogInDto);
        //TODO 返回日志id，待与日志模块沟通增加返回
        return 1L;
    }

    /**
     * 封装登录成功返回给前端的信息
     *
     * @param user
     * @param logId
     * @param mark
     * @return OutDTO
     */
    private OutDTO loginSuccess(User user, Long logId, boolean mark) {
        //TODO 该参数未被使用,待与前端确认是否取值
        OutDTO outDTO = new OutDTO();
        LoginUser loginUser = new LoginUser();
        try {
            String redisToken= tokenService.getByToken(String.format(RedisConstantsKey.USER_TOKEN_KEY,user.getId()));
             if(StringUtil.isEmpty(redisToken)){
                 //TODO 该参数未被使用,待与前端确认是否取值
                 Role roleInfo = roleRelatedMapper.findRoleById(user.getRoleId());
                 Organization organizationInfo = organizationService.getOrganizationInfo(user.getOrgnCode());
                 if (mark) {
                     //查询三级行社
                     if (organizationInfo != null) {
                         if ("4".equals(organizationInfo.getOrgnLevel()) || "5".equals(organizationInfo.getOrgnLevel()) || "3".equals(organizationInfo.getOrgnLevel())) {
                             Map<String, String> map = organizationService.listOrgnCodeLv3ByOrgnCode(user.getOrgnCode());
                             outDTO.put("orgnCodeLv3", map.get("ORGN_CODE_LV_3"));

                             String custDataAuth = organizationService.getCustDataAuth(map.get("ORGN_CODE_LV_3"));
                             outDTO.put("custDataAuth", custDataAuth);
                         }
                     }
                 }
                 //正常校验登录之后，分步存储
                 //1-把对应的loginUser，roleInfo，orgnInfo，menus统一封装成用户信息，额外增加两个字段isManage是否为管理员1：是，0：否，token用户的时效token
                 String token = tokenService.createToken(String.format(RedisConstantsKey.USER_TOKEN_KEY, user.getId()));
                 loginUser.setOrganization(organizationInfo);
                 loginUser.setRole(roleInfo);
                 loginUser.setUser(user);
                 loginUser.setUserId(user.getId().toString());
                 if ("1008".equals(user.getRoleCode())) {
                     loginUser.setIsManage("1");
                 }
                 // 导航数据
                 List<Menu> menuList = menuMapper.getSysByRoleId(roleInfo.getId());
                 List<Menu> list = menuService.getChildsManyGroup(menuList, 0);
                 loginUser.setList(list);
                 List<RoleMenuDO> roleMenuDOS = menuMapper.getListByRoleId(roleInfo.getId());
                 loginUser.setMenuList(roleMenuDOS);
                 loginUser.setToken(token);
                 distributeCacheService.setLoginUserInfo(String.format(RedisConstantsKey.USER_LOGIN_INFO_KEY, user.getId()), loginUser);
                 //2-把这个用户对应的权限也放进缓存中，并同时在缓存中做好拦截配置的准备工作
                 distributeCacheService.setUserAuthorityInterceptorUrl(String.format(RedisConstantsKey.USER_AUTHORITY_RULE_KEY, user.getId()), roleMenuDOS);

             }else{
                 //TODO
                 logger.info("用户userId="+user.getId()+"token不为空="+redisToken);
                 loginUser=distributeCacheService.getUserAuthority(String.format(RedisConstantsKey.USER_LOGIN_INFO_KEY, user.getId()));
             }

        } catch (Exception e) {
            distributeCacheService.delete(String.format(RedisConstantsKey.USER_TOKEN_KEY, user.getId()));
            distributeCacheService.delete(String.format(RedisConstantsKey.USER_AUTHORITY_RULE_KEY, user.getId()));
            distributeCacheService.delete(String.format(RedisConstantsKey.USER_LOGIN_INFO_KEY, user.getId()));
            logger.error("删除用户信息和权限信息" + e.getMessage(), e);

        }
        outDTO = OutDTOFactory.getSucceedOutDTO().put("info", loginUser);


        return outDTO;
    }

    /**
     * 登陆时，检查当前登陆用户的所属机构是否可用。不可用不允许登陆，并提示。
     *
     * @param orgnCode 当前登陆用户的机构编码
     * @return boolean true:当前机构不存在
     */
    private boolean checkOrganizationExist(String orgnCode) {
        try {
            if (StringUtils.isNotEmpty(orgnCode)) {
                Organization organization = new Organization();
                organization.setOrgnCode(orgnCode);
                return (OutDTOFactory.RESULT_NOT_EXIST) == (int) organizationMapper.checkOrganization(organization);
            }
            return true;
        } catch (Exception e) {
            logger.error(ResultEnum.ERROR_LOGIN_ORGANIZATION_NOT_EXIST + "当前登陆用户机构异常");
            throw new ApplicationException(ResultEnum.ERROR_LOGIN_ORGANIZATION_NOT_EXIST + "当前登陆用户机构异常");
        }
    }
}
