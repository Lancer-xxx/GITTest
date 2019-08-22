package com.yihuisoft.authoritybiz.dto.menu;

/**
 * 角色菜单请求DTO
 * @author mengfanbang
 * @date 2019/8/17
 * @version V4.0.2
 */
public class RoleMenuRespDTO {
    /**id*/
    private Long id;
    /**角色id*/
    private Long roleId;
    /**菜单id*/
    private Long menuId;
    /**菜单URL*/
    private String menuUrl;
    /**菜单URL路由*/
    private String routerUrl;
    /**类型 0：模块 1：根菜单 2：子菜单 3：功能*/
    private String menuType;
    /**名称*/
    private String menuName;
    /**描述*/
    private String menuDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getRouterUrl() {
        return routerUrl;
    }

    public void setRouterUrl(String routerUrl) {
        this.routerUrl = routerUrl;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }
}
