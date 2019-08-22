package com.yihuisoft.authoritybiz.dto.role;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class RoleDisableDTO implements Serializable {
    /**角色ID*/
    @NotNull(message="角色id不能为空")
    private Long id;

    /**角色状态是否禁用0：否1：是，默认值1*/
    @NotNull(message="角色状态不能为空")
    private String roleStatus;

    // 类型
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RoleDisableDTO{" +
                "id=" + id +
                ", roleStatus='" + roleStatus + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
