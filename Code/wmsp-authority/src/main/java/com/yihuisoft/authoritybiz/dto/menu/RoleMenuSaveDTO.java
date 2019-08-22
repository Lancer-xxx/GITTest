package com.yihuisoft.authoritybiz.dto.menu;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 菜单管理-角色菜单分配-保存DTO
 * @author laijd
 * @date 2019/7/9
 * @version V4.0.0
 */
public class RoleMenuSaveDTO {
    /**角色ID*/
    @NotNull(message = "角色ID不能为空！")
    private Long roleId;
    /**用户ID*/
    private Long userId;
    /**选中菜单ID*/
    private List<Long> menuid;
    /**选中菜单列表*/
    private List<Long> selectedMenuList;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getMenuid() {
        return menuid;
    }

    public void setMenuid(List<Long> menuid) {
        this.menuid = menuid;
    }

    public List<Long> getSelectedMenuList() {
        return selectedMenuList;
    }

    public void setSelectedMenuList(List<Long> selectedMenuList) {
        this.selectedMenuList = selectedMenuList;
    }

    @Override
    public String toString() {
        return "RoleMenuSaveDTO{" +
                "roleId=" + roleId +
                ", userId=" + userId +
                ", menuid=" + menuid +
                ", selectedMenuList=" + selectedMenuList +
                '}';
    }
}
