package com.yihuisoft.authoritybiz.dto.role;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


/**
 * 角色插入实体
 * @author topz
 * @date 2019/6/28 13:24
 * @version V4.0.0
 **/
public class RoleInsertDTO implements Serializable {

    /**角色名称*/
    @NotBlank(message = "请输入角色名称!")
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

    /**创建人ID*/
    private Long createUserid;


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

    public Long getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Long createUserid) {
        this.createUserid = createUserid;
    }
}
