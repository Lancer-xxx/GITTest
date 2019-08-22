package com.yihuisoft.authoritybiz.entity.permission;

import java.util.Date;
/**
 * 角色数据权限中间表实体类
 * @author mengfanbang
 * @version 4.0.2
 * @date 2019/08/17 10:11
 * @author laijd
 */
public class RoleDataPermission {
    /**主键id*/
    private Long id;
    /**角色ID*/
    private Long roleId;
    /**数据权限ID*/
    private Long dataId;
    /**是否删除0：否，1：是*/
    private String isDeleted;
    /**创建人*/
    private Long createUserId;
    /**创建时间*/
    private Date createTime;
    /**修改人*/
    private Long updateUserId;
    /**修改时间*/
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
