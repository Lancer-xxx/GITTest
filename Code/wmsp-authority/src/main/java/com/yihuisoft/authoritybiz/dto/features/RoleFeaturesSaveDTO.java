package com.yihuisoft.authoritybiz.dto.features;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 功能管理-角色功能分配保存DTO
 * @author laijd
 * @date 2019/07/04
 * @version V4.0.0
 * */
public class RoleFeaturesSaveDTO implements Serializable {
    /**角色id*/
    @NotNull(message = "角色ID不能为空！")
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
