package com.yihuisoft.authoritybiz.dto.role;


import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 角色更新实体
 * @author topz
 * @date 2019/6/28 13:24
 * @version V4.0.0
 **/
public class RoleUpdateDTO implements Serializable {

    /**角色ID*/
    @NotNull(message = "角色id不能为空")
    private Long id;

    /**角色名称*/
    @NotNull(message = "角色名称不能为空")
    private String roleName;

    /**角色说明*/
    private String roleDesc;

    /**角色状态是否禁用0：否1：是，默认值1*/
    private String roleStatus;

    /**角色级别*/
    private String roleLevel;

    /**数据权限*/
    @NotNull(message = "请选择数据权限")
    private Long dataAuth;

    /**更新人ID*/
    private Long updateUserid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    public String getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(String roleLevel) {
        this.roleLevel = roleLevel;
    }

    public Long getDataAuth() {
        return dataAuth;
    }

    public void setDataAuth(Long dataAuth) {
        this.dataAuth = dataAuth;
    }

    public Long getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Long updateUserid) {
        this.updateUserid = updateUserid;
    }
}
