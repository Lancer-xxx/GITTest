package com.yihuisoft.authoritybiz.dto.permission;
/**
 * 数据权限获取DTO
 * @author mengfanbang
 * @date 2019/8/17
 * @version V4.0.2
 */
public class RoleDataPermissionSelectDTO {
    /**角色id*/
    private Long roleId;
    /**类型*/
    private String type;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
