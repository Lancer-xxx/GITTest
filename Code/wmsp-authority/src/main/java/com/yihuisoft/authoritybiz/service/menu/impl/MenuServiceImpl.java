package com.yihuisoft.authoritybiz.service.menu.impl;

import com.yihuisoft.authoritybiz.dto.menu.*;
import com.yihuisoft.authoritybiz.entity.features.Features;
import com.yihuisoft.authoritybiz.entity.menu.*;
import com.yihuisoft.authoritybiz.entity.system.SystemModel;
import com.yihuisoft.authoritybiz.mapper.features.FeaturesMapper;
import com.yihuisoft.authoritybiz.mapper.menu.MenuMapper;
import com.yihuisoft.authoritybiz.mapper.system.SystemMapper;
import com.yihuisoft.authoritybiz.service.menu.MenuService;
import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.common.util.app.CheckUtils;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.util.app.SnowFlakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 * 菜单管理实现类
 * @author laijd
 * @version V4.0.0
 * @date 2019/7/1
 */
@Service
public class MenuServiceImpl<T> implements MenuService<T> {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 新增菜单信息
     * @param menuSaveDTO
     * @return OutDTO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public OutDTO saveMenu(MenuSaveDTO menuSaveDTO) throws ApplicationException {
        try{
            Menu menu = new Menu();
            CopyUtils.copy(menuSaveDTO,menu);
            //判断菜单名称在系统中是否存在
            Long count = menuMapper.getMenuCountByMenuName(menu);
            if(count > 0){
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_MENU_NAME_EXIST);
            }
            if ("0".equals(menu.getMenuType())) {// 根菜单
                menu.setParentId(0L);
            }
            //判断通过，新增菜单
            menu.setId(SnowFlakeIdWorker.generateId());
            menu.setMenuStatus("1");
            menu.setUpdateUserid(menu.getCreateUserid());
            int res = menuMapper.saveMenu(menu);
            // 分配系统管理员权限
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setId(SnowFlakeIdWorker.generateId());
            roleMenu.setRoleId(CommonConstants.ADMINISTRATOR);
            roleMenu.setMenuId(menu.getId());
            roleMenu.setStatus("1");
            roleMenu.setCreateUserid(menu.getCreateUserid());
            roleMenu.setUpdateUserid(menu.getCreateUserid());
            menuMapper.saveRoleMenu(roleMenu);
            if (res == 1) {
                return OutDTOFactory.getSucceedOutDTO().put("menuId",menu.getId());
            }
        }catch(Exception e){
            logger.error(ResultEnum.ERROR_INSERT.getMessage()+e.getMessage(),e);
            throw new ApplicationException(ResultEnum.ERROR_INSERT);
        }
        return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_INSERT);
    }

    /**
     * 修改菜单接口
     * @param menuUpdateDTO
     * @return OutDTO
     */
    @Override
    public OutDTO updateMenu(MenuUpdateDTO menuUpdateDTO) throws ApplicationException {
        int result;
        try{
            Menu menu = new Menu();
            CopyUtils.copy(menuUpdateDTO, menu);
            Long count = menuMapper.getMenuCountByMenuName(menu);
            if(count > 0){
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_MENU_NAME_EXIST);
            }
            menu.setUpdateTime(new Date());
            result = menuMapper.updateMenu(menu);
        }catch (Exception e){
            logger.error("updateMenu:"+e.getMessage(),e);
            throw new ApplicationException(ResultEnum.ERROR_UPDATE);
        }
        return CheckUtils.checkDelete(result);
    }

    /**
     * 根据菜单ID删除菜单数据
     * @param menuDTO
     * @return OutDTO
     */
    @Override
    @Transactional(rollbackFor = ApplicationException.class)
    public OutDTO deleteMenu(MenuDTO menuDTO) throws ApplicationException {
        try{
            Menu menu = new Menu();
            CopyUtils.copy(menuDTO,menu);
            // 判断该菜单下是否存在子菜单
            List<Menu> menuList = menuMapper.selectMenuByParentId(menu.getId());
            if (!ObjectUtils.isEmpty(menuList)) {
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_MENU_PARENT);
            }
            // 判断该菜单下是否存在功能
            List<Menu> menus = menuMapper.selectFuncByParentId(menu.getId());
            if (!ObjectUtils.isEmpty(menus)) {
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_MENU_FEATURES);
            }
            // 逻辑删除菜单
            menuMapper.deleteMenu(menu.getId());
            // 物理删除中间表数据
            menuMapper.deleteByMenuId(menu.getId());
            return OutDTOFactory.getSucceedOutDTO();
        }catch (Exception e){
            logger.error("deleteMenu:"+e.getMessage(),e);
            throw new ApplicationException(ResultEnum.ERROR_DELETE);
        }
    }

    /**
     * 查找菜单信息
     * @param menuDTO
     * @return
     */
    @Override
    public OutDTO getMenu(MenuDTO menuDTO) {
        Menu menu = new Menu();
        CopyUtils.copy(menuDTO,menu);
        Menu responseMenu = menuMapper.getMenu(menu);
        Menu m = menuMapper.getParentMenuById(responseMenu.getParentId());
        if (!ObjectUtils.isEmpty(m)) {
            responseMenu.setParentName(m.getMenuName());
        }
        return OutDTOFactory.getSucceedOutDTO().putInfo(responseMenu);
    }

    /**
     * 查找所有菜单列表
     * @return
     */
    @Override
    public OutDTO listAllMenu() {
        List<Menu> menus = menuMapper.listMenu(new Menu());
        return OutDTOFactory.getSucceedOutDTO().putList(menus);
    }

    /**
     * 菜单树-角色菜单分配，根据roleId查找菜单列表并解析成树  qrySysMenuTree
     * @param menuDTO
     * @return
     */
    @Override
    public OutDTO listSysMenuTree(MenuDTO menuDTO) {
        OutDTO outDTO = new OutDTO();
        try {
            // 菜单树状图
            List<Menu> menuList = menuMapper.getSysList();
            List<Menu> list = this.getChildsManyGroup(menuList, 0);
            outDTO = OutDTOFactory.getSucceedOutDTO().putList(list);
            // 菜单下拉框
            List<Menu> selectListMenu =  menuMapper.selectListMenu();
            List<Menu> menus = this.getChildsManyGroup(selectListMenu, 0);
            outDTO.getData().put("selectListMenu", menus);
        }catch (Exception e) {
            logger.error("deleteMenu:"+e.getMessage(),e);
            throw new ApplicationException(ResultEnum.ERROR_SYSTEM_REQUEST);
        }
        return outDTO;
    }

    /**
     * 菜单树 字典模块调用
     * 获取根菜单及父级是根菜单的所有菜单
     * @return
     */
    @Override
    public OutDTO<T> listMenuTree() {
        OutDTO outDTO = new OutDTO();
        try {
            // 获取根菜单及父级是根菜单的所有菜单
            List<Menu> menuList = menuMapper.listMenuTree();
            List<Menu> list = this.getChildsManyGroup(menuList, 0);
            outDTO = OutDTOFactory.getSucceedOutDTO().putList(list);
            // 获取所有的菜单
            List<Menu> menus = menuMapper.getSysList();
            Map map = new HashMap();
            menus.forEach(menu -> {
                map.put(menu.getId(), menu.getMenuName());
            });
            outDTO.put("menuList", map);
        }catch (Exception e) {
            logger.error("deleteMenu:"+e.getMessage(),e);
            throw new ApplicationException(ResultEnum.ERROR_RESULT_FALSE);
        }
        return outDTO;
    }

    /**
     * 检查系统模块是否存在子菜单
     * @param sysId
     * @return true 存在，false 不存在
     */
    @Override
    public boolean checkSystemToDelete(Long sysId) {
        boolean result = false;
        List<Menu> menuList = menuMapper.listRootMenuBySysId(sysId);
        if(!ObjectUtils.isEmpty(menuList)){
            List<RoleMenu> roleMenuList;
            for (Menu m : menuList) {
                roleMenuList = menuMapper.listRoleMenuByMenuId(m.getId());
                if(!ObjectUtils.isEmpty(roleMenuList)){
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * 删除根菜单
     * @param sysId
     * @return 0删除成功，1删除失败
     */
    @Override
    public int deleteRootMenu(Long sysId) throws ApplicationException {
        int result = 1;
        try{
            List<Menu> menuList = menuMapper.listRootMenuBySysId(sysId);
            if(!ObjectUtils.isEmpty(menuList)){
                int i;
                for (Menu m : menuList) {
                    i = menuMapper.deleteMenu(m.getId());
                    if (i == 1) {
                        result = 0;
                    }
                }
            }
        }catch (Exception e){
            logger.error("deleteMenu:"+e.getMessage(),e);
            throw new ApplicationException(ResultEnum.ERROR_DELETE);
        }
        return  result;
    }

    /**
     * 判断菜单URL在系统中是否存在
     * @param menu
     * @return false 菜单URL不存在，true 菜单URL存在
     * @author laijd
     * @date 2019/5/23
     */
    private boolean checkMenuUrlExists(Menu menu, boolean isUpdate){
        boolean result = false;
        List<Menu> listUrl = menuMapper.listMenu(menu);
        if(!ObjectUtils.isEmpty(listUrl)){
            if (isUpdate){
                //获取要修改的id                   --------------liuwenjin 2019/5/28
                if(listUrl.size() == 1 && menu.getId().equals(listUrl.get(0).getId())){
                    result = false;
                }
            }
            result = true;
        }
        return result;
    }

    /**
     * 判断菜单URL在系统中是否存在
     * @param list
     * @param pid  父根ID
     * @return false 菜单URL不存在，true 菜单URL存在
     * @author zhangsh
     * @date 2019/7/29
     */
    public List<Menu> getChildsManyGroup(List<Menu> list, long pid){
        List<Menu> arr = new ArrayList<Menu>();
        for(Menu location : list){
            if(pid == location.getParentId()){
                location.setChildren(getChildsManyGroup(list, location.getId()));
                arr.add(location);
            }
        }
        return arr;
    }

}
