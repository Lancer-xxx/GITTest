package com.yihuisoft.authoritybiz.mapper.menu;

import com.yihuisoft.authoritybiz.entity.menu.Menu;
import com.yihuisoft.authoritybiz.entity.menu.RoleMenu;
import com.yihuisoft.authoritybiz.entity.menu.RoleMenuDO;
import com.yihuisoft.common.base.CommonMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单管理mapper
 * @author laijd
 * @version V4.0.0
 * @date 2019/7/1
 */
@Repository
public interface MenuMapper extends CommonMapper<Menu> {
    /**
     * 修改菜单信息
     * @param menu 菜单实体
     * @return 执行结果
     */
    int saveMenu(Menu menu);
    /**
     * 删除菜单信息
     * @param id 菜单ID
     * @return 执行结果
     */
    int deleteMenu(@Param("id")Long id);
    /**
     *修改菜单信息
     * @param menu 菜单实体
     * @return 执行结果
     */
    int updateMenu(Menu menu);
    /**
     *获取菜单详细描述
     * @param menu 封装查询条件的菜单实体
     * @return Menu
     */
    Menu getMenu(Menu menu);
    /**根据主键查找上级菜单信息 查询导航栏菜单
     * @param id 菜单ID
     * @return Menu
     * */
    Menu getParentMenuById(@Param("id") Long id);
    /**
     * 查找菜单列表，可按参数条件查询
     * @param menu
     * @return
     */
    List<Menu> listMenu(Menu menu);

    /**
     * 根据系统ID查找根菜单
     * @param sysId 系统ID
     * @return List<Menu>
     */
    List<Menu> listRootMenuBySysId(@Param("sysId") Long sysId);
    /**
     * 查找菜单列表，前提MenuStatus不为空的
     * @return List<Menu>
     */
    List<Menu> listMenuRoot();

    /**
     * 根据菜单ID查找角色菜单关联信息列表
     * @param menuId 菜单ID
     * @return List<RoleMenu>
     */
    List<RoleMenu> listRoleMenuByMenuId(@Param("menuId")Long menuId);
    /**
     * 删除角色菜单关联信息
     * @param roleId 角色ID
     * @return 执行结果
     */
    int deleteRoleMenuByRoleId(@Param("roleId") Long roleId);
    /**
     * 角色菜单分配保存
     * @param roleMenu 角色菜单实体
     * @return 执行结果
     */
    int saveRoleMenu(RoleMenu roleMenu);

    List<RoleMenuDO> getListByRoleId(@Param("roleId") Long roleId);

    //获取系统模块
    List<Menu> getSysByRoleId(@Param("roleId") Long roleId);

    /**
     * 获取所有功能列表
     * @param menu
     * @return
     */
    List<Menu> getList(Menu menu);

    /**
     * 获取所有菜单
     * @return
     */
    List<Menu> getSysList();

    /**
     * 根据菜单名称查重
     * @param menu
     * @return
     */
    Long getMenuCountByMenuName(Menu menu);

    /**
     * 根据功能名称查重
     * @param menu
     * @return
     */
    Long getFuncCountByMenuName(Menu menu);

    /**
     * 根据菜单id删除数据
     * @param menuId
     */
    void deleteByMenuId(@Param("menuId") Long menuId);

    /**
     * 判断该菜单下是否存在子菜单
     * @param parentId
     * @return
     */
    List<Menu> selectMenuByParentId(@Param("parentId") Long parentId);

    /**
     * 判断该菜单下是否存在功能
     * @param parentId
     * @return
     */
    List<Menu> selectFuncByParentId(@Param("parentId") Long parentId);

    /**
     * 获取根菜单及父级是根菜单的所有菜单
     * @return
     */
    List<Menu> listMenuTree();

    /**
     * 菜单管理下拉框数据获取
     * @return
     */
    List<Menu> selectListMenu();
}
