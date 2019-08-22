package com.yihuisoft.authoritybiz.service.menu;

import com.yihuisoft.authoritybiz.dto.menu.*;
import com.yihuisoft.authoritybiz.entity.menu.Menu;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.exception.ApplicationException;

import java.util.List;

/**
 * 菜单管理接口定义
 * @author laijd
 * @version V4.0.0
 * @date 2019/7/1
 */
public interface MenuService<T> {

    /**
     * 新增菜单信息
     * @param menuSaveDTO
     * @return OutDTO
     * @throws ApplicationException
     */
    OutDTO saveMenu(MenuSaveDTO menuSaveDTO) throws ApplicationException;

    /**
     * 根据菜单ID删除菜单数据
     * @param menuDTO
     * @return OutDTO
     * @throws ApplicationException
     */
    OutDTO deleteMenu(MenuDTO menuDTO) throws ApplicationException;
    /**
     * 修改菜单信息
     * @param menuUpdateDTO
     * @return OutDTO
     * @throws ApplicationException
     */
    OutDTO updateMenu(MenuUpdateDTO menuUpdateDTO) throws ApplicationException;
    /**
     * 根据条件查找菜单信息
     * @param menuDTO
     * @return
     */
    OutDTO getMenu(MenuDTO menuDTO);
    /**
     * 查找所有菜单列表
     * @return OutDTO
     */
    OutDTO listAllMenu();

    /**
     * 菜单树-角色菜单分配，根据roleId查找菜单列表并解析成树  qrySysMenuTree
     * @param menuDTO
     * @return
     */
    OutDTO listSysMenuTree(MenuDTO menuDTO);

    /**
     *检查系统模块是否存在子菜单
     * @param sysId
     * @return true 存在，false 不存在
     */
    boolean checkSystemToDelete(Long sysId);
    /**
     * 删除根菜单
     * @param sysId
     * @return  0删除成功，1删除失败
     * @throws ApplicationException
     */
    int deleteRootMenu(Long sysId) throws ApplicationException;

    List<Menu> getChildsManyGroup(List<Menu> list, long pid);

    /**
     * 菜单树 只展示两级菜单
     * @return
     */
    OutDTO<T> listMenuTree();
}
