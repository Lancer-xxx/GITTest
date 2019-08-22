package com.yihuisoft.authoritybiz.service.role.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.authoritybiz.constant.RedisConstantsKey;
import com.yihuisoft.authoritybiz.dto.features.FeaturesDTO;
import com.yihuisoft.authoritybiz.dto.role.*;
import com.yihuisoft.authoritybiz.entity.menu.Menu;
import com.yihuisoft.authoritybiz.entity.menu.RoleMenu;
import com.yihuisoft.authoritybiz.entity.menu.RoleMenuDO;
import com.yihuisoft.authoritybiz.entity.menu.TreeMenuTwo;
import com.yihuisoft.authoritybiz.entity.permission.RoleDataPermission;
import com.yihuisoft.authoritybiz.entity.role.Role;
import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.authoritybiz.mapper.menu.MenuMapper;
import com.yihuisoft.authoritybiz.mapper.permission.RoleDataPermissionMapper;
import com.yihuisoft.authoritybiz.mapper.role.RoleRelatedMapper;
import com.yihuisoft.authoritybiz.mapper.user.UserMapper;
import com.yihuisoft.authoritybiz.service.discache.DistributeCacheService;
import com.yihuisoft.authoritybiz.service.menu.MenuService;
import com.yihuisoft.authoritybiz.service.role.RoleRelatedService;
import com.yihuisoft.authoritybiz.service.role.RoleService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.common.util.app.CheckUtils;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.util.app.SnowFlakeIdWorker;
import com.yihuisoft.common.vo.PageMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色模块相关业务层
 * @author topz
 * @date 2019/7/2 14:38
 * @version V4.0.0
 **/
@Service
public class RoleRelatedServiceImpl implements RoleRelatedService {

    private static final Logger logger = LoggerFactory.getLogger(RoleRelatedServiceImpl.class);
    
    @Autowired
    private RoleRelatedMapper roleRelatedMapper;
    @Autowired
    private UserMapper userMapper;
    /**角色菜单表*/
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private DistributeCacheService distributeCacheService;
    @Autowired
    private RoleDataPermissionMapper roleDataPersionMapper;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleService roleService;

    public static final String ROLE_STATUS = "1";
    public static final String TYPE = "1";

    /**
      * 插入角色信息：角色名称重复则返回失败信息
      * @author topz
      * @param roleInsertDTO
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 16:17 2019/7/18
      **/
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public OutDTO saveRole(RoleInsertDTO roleInsertDTO) throws ApplicationException {
        OutDTO res = new OutDTO();
        // 复制对象属性到Role传入mapper
        Role role = new Role();
        CopyUtils.copy(roleInsertDTO, role);
        // 状态默认禁用
        role.setRoleStatus("0");
        // 查重
        Long count = roleRelatedMapper.findRoleByName(role);
        if(count > 0){
            logger.info("创建角色<"+role.getRoleName()+">时，该角色名称已存在！");
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_EXIST_ROLE);
        }
        int row =0;
        try{
            // 插入角色
            role.setId(SnowFlakeIdWorker.generateId());
            role.setUpdateUserid(role.getCreateUserid());
            row= roleRelatedMapper.saveRole(role);
            CheckUtils.checkUpdate(row);
            // 插入数据权限
            insert(role, "1");
        }catch (Exception e){
            logger.error("创建角色<"+role.getRoleName()+">异常！");
            throw new ApplicationException("创建角色<"+role.getRoleName()+">异常！",e);
        }
        res = OutDTOFactory.getSucceedOutDTO();
        return res;
    }
    /**
     * 更新角色信息
     * @author topz
     * @param roleUpdateDTO
     * @return com.yihuisoft.common.dto.OutDTO
     * @date 16:19 2019/7/18
     **/
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public OutDTO updateRoleById(RoleUpdateDTO roleUpdateDTO)   {
        OutDTO res = new OutDTO();
        // 转换实体类
        Role role = new Role();
        CopyUtils.copy(roleUpdateDTO, role);

        // 角色名称不能重复
        Long count = roleRelatedMapper.findRoleByName(role);
        if(count > 0){
            res= OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_EXIST_ROLE);
            logger.info("该角色id为<"+role.getId()+">角色名称已存在，请重新输入!");
            return  res;
        }
        // 更新操作
        int rows=0;
        try{
            rows= roleRelatedMapper.updateRoleById(role);
            CheckUtils.checkUpdate(rows);
            // 删除现有的数据权限
            roleDataPersionMapper.deleteByRoleId(role.getId());
            // 插入数据权限
            insert(role, "2");
        }catch (Exception e){
            logger.error("更新角色id为<"+role.getId()+">角色信息异常!");
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg("更新角色id为<"+role.getId()+">角色信息异常!");
        }
        res = OutDTOFactory.getSucceedOutDTO();
        return res;
    }

    /**
     * 插入数据权限
     * @param type
     * @param role
     */
    private void insert(Role role, String type) {
        RoleDataPermission roleDataPersion = new RoleDataPermission();
        // id赋值
        roleDataPersion.setId(SnowFlakeIdWorker.generateId());
        roleDataPersion.setRoleId(role.getId());
        roleDataPersion.setDataId(role.getDataAuth());
        if ("1".equals(type)){
            roleDataPersion.setCreateUserId(role.getCreateUserid());
            roleDataPersion.setUpdateUserId(role.getCreateUserid());
        } else {
            roleDataPersion.setCreateUserId(role.getUpdateUserid());
            roleDataPersion.setUpdateUserId(role.getUpdateUserid());
        }
        roleDataPersionMapper.saveRoleDataPersion(roleDataPersion);
    }

    /**
      * 获取角色列表
      * @author topz
      * @param rolePageDTO 角色信息
      * @param pageMessage 分页参数
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 16:17 2019/7/18
      **/
    @Override
    public OutDTO findRoleList(RolePageDTO rolePageDTO, PageMessage pageMessage) {

        // 检查分页信息
        pageMessage = PageMessage.check(pageMessage);
        PageHelper.startPage(pageMessage.getPageNo(), pageMessage.getPageSize());

        // 复制传入mapper实体类
        Role role = new Role();
        CopyUtils.copy(rolePageDTO,role);

        // 分页查询
        List<Role> roleListDTOList;
        try{
            roleListDTOList = roleRelatedMapper.findRoleList(role);
        }catch (Exception e){
            logger.error("获取角色分页信息异常！");
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_NOT_FOUND);
        }
        // 用PageInfo对结果进行包装
        PageInfo<Role> page = new PageInfo(roleListDTOList);

        // 封装返回信息
        return OutDTOFactory.getSucceedOutDTO().putList(roleListDTOList).setSumCount(page.getTotal());
    }

    /**
      * 查询角色等级大于当前角色等级的角色列表
      * @author topz
      * @param roleSelectedKeyDTO
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 16:18 2019/7/18
      **/
    @Override
    public OutDTO getRoleDownByRoleId(RoleSelectedKeyDTO roleSelectedKeyDTO) {

        // 复制对象属性到Role传入mapper
        Role role = new Role();
        CopyUtils.copy(roleSelectedKeyDTO, role);
        List<Role> roleList;
        try{
            roleList = roleRelatedMapper.getRoleDownByRoleId(role);
        }catch (Exception e){
            logger.error("获取角色分页信息异常！");
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg("查询角色等级大于当前角色等级的角色列表异常！");
        }

        // 封装返回信息
        return OutDTOFactory.getSucceedOutDTO()
                .putList(roleList);
    }

    /**
      * 根据id删除角色：判断角色下有无用户，角色下有无菜单，均要删除（需要事务控制）
      * @author topz
      * @param roleSelectedKeyDTO
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 16:18 2019/7/18
      **/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OutDTO deleteByPrimaryKey(RoleSelectedKeyDTO roleSelectedKeyDTO) throws ApplicationException {
        OutDTO outDTO;
        Long roleId = roleSelectedKeyDTO.getId();

        if (TYPE.equals(roleSelectedKeyDTO.getType())) {
            // 获取该角色下用户数量统计
            List<User> userList = userMapper.getCountByRoleId(roleId);
            if (!ObjectUtils.isEmpty((userList))){
                outDTO = OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_USER_EXIST_ROLE);
                logger.info("该角色下已存在用户信息，删除失败!");
                return outDTO;
            } else {
                outDTO = OutDTOFactory.getSucceedOutDTO();
                return outDTO;
            }
        }
        // 转换实体类
        Role role = new Role();
        CopyUtils.copy(roleSelectedKeyDTO, role);

        try{
            // 删除角色下的菜单
            menuMapper.deleteRoleMenuByRoleId(roleId);
            logger.info("已删除角色ID<"+roleId+">下的所有菜单！");
        }catch(Exception e){
            logger.error("角色ID<"+roleId+">下的所有菜单删除异常！");
            throw new ApplicationException("角色ID<"+roleId+">下的所有菜单删除异常！",e);
        }
        try{
            // 删除角色信息
            roleRelatedMapper.deleterRoleById(role);
            logger.info("角色ID<"+roleId+">信息已删除！");
        }catch(Exception e){
            logger.info("角色ID<"+roleId+">删除异常！");
            throw new ApplicationException("角色ID<"+roleId+">删除异常！",e);
        }

        outDTO= OutDTOFactory.getSucceedOutDTO().setErrorMsg("角色删除成功！");
        return outDTO;
    }

    /**
     * 根据角色id禁用/启用角色
     * @param dto
     * @return
     */
    @Override
    public OutDTO disableRoleById(RoleDisableDTO dto) {
        OutDTO res = new OutDTO();
        // 转换实体类
        Role role = new Role();
        CopyUtils.copy(dto, role);
        List<User> userList;
        try {
            // 获取当前角色下所有用户
            userList = userMapper.getCountByRoleId(role.getId());
            if (TYPE.equals(dto.getType())) {
                if (ROLE_STATUS.equals(role.getRoleStatus())) {// 启用
                    roleRelatedMapper.disableRoleById(role);
                    if (!ObjectUtils.isEmpty(userList)) {
                        userList.forEach(user -> {
                            // 开启角色放入Redis中
                            roleService.enableRole(user);
                        });
                    }
                    logger.info("角色启用成功");
                    return OutDTOFactory.getSucceedOutDTO();
                }
                // 禁用
                if (!ObjectUtils.isEmpty(userList)) {
                    res.setSumCount(Long.valueOf(userList.size()));
                    return res;
                }
                // 无用户使用，直接禁用
                roleRelatedMapper.disableRoleById(role);
                logger.info("角色禁用成功");
            } else {
                if (!ObjectUtils.isEmpty(userList)) {
                    userList.forEach(user -> {
                        // 禁用角色删除Redis中权限
                        roleService.disabledRole(user);
                    });
                }
                roleRelatedMapper.disableRoleById(role);
            }
            res = OutDTOFactory.getSucceedOutDTO();
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(ResultEnum.RROR_ROLE_DISENABLE_FAIL);
        }
        return res;
    }
    /**
     * 根据角色id获取树状图
     * @param dto
     * @return
     */
    @Override
    public OutDTO selectRoleMenuFuncTree(FeaturesDTO dto) {
        OutDTO res = new OutDTO();
        try {
            // 获取树状图
            res = getListByRoleId();
            // 获取已选择菜单功能
            List<RoleMenuDO> roleMenuList = menuMapper.getListByRoleId(dto.getRoleId());
            res.getData().put("roleMenuList", roleMenuList);
        }catch (Exception e) {
            e.printStackTrace();
            logger.info("--------", e);
            throw new ApplicationException("------",e);
        }
        return res;
    }

    /**
     * 获取树状图
     * @return
     */
    @Override
    public OutDTO getListByRoleId() {
        List<Menu> treeMenuTwos;
        try {
            List<Menu> menus = menuMapper.listMenuRoot();
            treeMenuTwos = menuService.getChildsManyGroup(menus, 0);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("--------", e);
            throw new ApplicationException("------",e);
        }
        return OutDTOFactory.getSucceedOutDTO().putList(treeMenuTwos);
    }

    /**
     * 设置菜单树的子菜单
     * @param menus
     * @return OutDTO
     */
    private List<TreeMenuTwo> setTreeMenuChildren(List<Menu> menus){
        List<TreeMenuTwo> treeMenus = new ArrayList<>();
        if(!ObjectUtils.isEmpty(menus)){
            for (Menu m : menus) {
                TreeMenuTwo childTreeMenu = new TreeMenuTwo();
                childTreeMenu.setId(m.getId());
                childTreeMenu.setTitle(m.getMenuName());
                childTreeMenu.setType("1");

                List<TreeMenuTwo> childList = getChildTreeTwoMenuById(m);
                childTreeMenu.setChildren(childList);
                treeMenus.add(childTreeMenu);
            }
        }
        return treeMenus;
    }
    /**
     * 遍历子菜单
     *
     * @param menu
     * @return
     */
    private List<TreeMenuTwo> getChildTreeTwoMenuById(Menu menu) {
        Menu tmp = new Menu();
        tmp.setParentId(menu.getId());
        tmp.setMenuStatus("1");
        List<Menu> menus = menuMapper.listMenu(tmp);
        List<TreeMenuTwo> menuList = new ArrayList<>();
        for (Menu m : menus) {
            TreeMenuTwo treeMenu = new TreeMenuTwo();
            treeMenu.setId(m.getId());
            treeMenu.setTitle(m.getMenuName());
            treeMenu.setType("1");
            List<TreeMenuTwo> list = getChildTreeTwoMenuById(m);
            treeMenu.setChildren(list);
            menuList.add(treeMenu);
        }
        return menuList;
    }

    /**
     * 角色菜单功能分配接口
     * @param dto
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public OutDTO assign(RoleMenuFuncDTO dto){
        List<Long> selectedMenu = dto.getSelectedMenu();
        Role role = new Role();
        role.setId(dto.getRoleId());
        role.setCreateUserid(dto.getUserId());

        List<User> userList;
        try {
            // 获取当前角色下所有用户
            userList = userMapper.getCountByRoleId(role.getId());
            // 通过角色id删除原有菜单功能权限
            menuMapper.deleteRoleMenuByRoleId(role.getId());
            //插入更新的菜单
            selectedMenu.forEach(menu -> {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setId(SnowFlakeIdWorker.generateId());
                roleMenu.setMenuId(menu);
                roleMenu.setRoleId(role.getId());
                roleMenu.setStatus("1");
                roleMenu.setCreateUserid(role.getCreateUserid());
                roleMenu.setUpdateUserid(role.getCreateUserid());
                menuMapper.saveRoleMenu(roleMenu);
            });
            if (!ObjectUtils.isEmpty(userList)) {
                userList.forEach(user ->  {
                    // 更新
                    List<RoleMenuDO> roleMenuDOS = menuMapper.getListByRoleId(role.getId());
                    distributeCacheService.setUserAuthorityInterceptorUrl(String.format(RedisConstantsKey.USER_AUTHORITY_RULE_KEY, user.getId()), roleMenuDOS);
                });
            }
        }catch (Exception e) {
            logger.error("saveRoleMenu:"+e.getMessage(),e);
            throw new ApplicationException(ResultEnum.ERROR_AUTHORITY_ROLE_MENU_SAVE_FAIL);
        }
        OutDTO res = OutDTOFactory.getSucceedOutDTO();
        return res;
    }
}
