package com.yihuisoft.authoritybiz.dto.menu;

import java.io.Serializable;

/**
 * 菜单管理-菜单信息更新DTO
 * @author laijd
 * @date 2019/7/1
 * @version V4.0.0
 */
public class MenuUpdateDTO implements Serializable {
    /**菜单Id*/
    private Long id;
    /**菜单名称*/
    private String menuName;
    /**父菜单Id*/
    private Long parentId;
    /**菜单url*/
    private String menuUrl;
    /*菜单路由*/
    private String routerUrl;
    /**菜单描述*/
    private String menuDesc;
    /**更新人Id*/
    private Long updateUserid;
    /**菜单类型*/
    private String menuType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public Long getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Long updateUserid) {
        this.updateUserid = updateUserid;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }
}
