package com.yihuisoft.authoritybiz.dto.menu;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 菜单管理-保存DTO
 * @author laijd
 * @date 2019/7/1
 * @version V4.0.0
 */
public class MenuSaveDTO implements Serializable {
    /**菜单名称*/
    @NotNull(message = "菜单名称不能为空！")
    private String menuName;
    /**父菜单Id 上级菜单id*/
    private Long parentId;
    /**菜单url*/
    private String menuUrl;
    /*菜单路由*/
    private String routerUrl;
    /**菜单描述*/
    private String menuDesc;
    /**更新人Id*/
    private Long createUserid;
    /**菜单类型*/
    @NotNull(message = "菜单类型不能为空！")
    private String menuType;

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

    public Long getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Long createUserid) {
        this.createUserid = createUserid;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }
}
