package com.yihuisoft.authoritybiz.dto.features;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 功能管理-角色功能分配-查询DTO
 * @author laijd
 * @date 2019/07/04
 * @version V4.0.0
 * */
public class RoleFeaturesDTO implements Serializable {

    /**角色ID*/
    @NotNull(message = "角色ID不能为空！")
    private Long roleId;
    /**菜单URL*/
    @NotNull(message = "菜单URL不能为空！")
    private String menuUrl;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    @Override
    public String toString() {
        return "RoleFeaturesDTO{" +
                "roleId=" + roleId +
                ", menuUrl='" + menuUrl + '\'' +
                '}';
    }
}
