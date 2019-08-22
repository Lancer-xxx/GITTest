package com.yihuisoft.authoritybiz.dto.features;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 功能管理DTO
 * @author laijd
 * @date 2019/07/04
 * @version V4.0.0
 * */
public class FeaturesDTO implements Serializable {
    /**功能id*/
    private Long id;
    /**角色id*/
    @NotNull(message = "角色ID不能为空！")
    private Long roleId;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "FeaturesDTO{" +
                "id=" + id +
                ", roleId=" + roleId +
                '}';
    }
}
