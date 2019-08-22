package com.yihuisoft.authoritybiz.dto.role;

/**
 * 角色分页查询实体
 * @author topz
 * @date 2019/6/28 13:24
 * @version V4.0.0
 **/
public class RolePageDTO {
    /**角色ID*/
    private Long id;
    /**角色编码*/
    private String roleCode;
    /**角色名称*/
    private String roleName;
    /**角色状态*/
    private String roleStatus;
    /**角色级别*/
    private String roleLevel;
    /**数据权限*/
    private String dataAuth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public String getDataAuth() {
        return dataAuth;
    }

    public void setDataAuth(String dataAuth) {
        this.dataAuth = dataAuth;
    }

    @Override
    public String toString() {
        return "RolePageDTO{" +
                "id=" + id +
                ", roleCode='" + roleCode + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleStatus='" + roleStatus + '\'' +
                ", roleLevel='" + roleLevel + '\'' +
                ", dataAuth='" + dataAuth + '\'' +
                '}';
    }
}
