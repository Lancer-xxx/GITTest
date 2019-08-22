package com.yihuisoft.authoritybiz.entity.features;

import java.io.Serializable;
import java.util.List;

/**
 * 角色功能分配保存DO
 * @author laijd
 * @date
 * @version V4.0.0
 */
public class RoleFeaturesDO implements Serializable {
    /**角色id*/
    private Long roleId;
    /**用户id*/
    private Long userId;
    /**功能id集合*/
    private List<Integer> funcid;

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

    public List<Integer> getFuncid() {
        return funcid;
    }

    public void setFuncid(List<Integer> funcid) {
        this.funcid = funcid;
    }

    @Override
    public String toString() {
        return "RoleFeaturesSaveDTO{" +
                "roleId=" + roleId +
                ", userId=" + userId +
                ", funcid=" + funcid +
                '}';
    }
}