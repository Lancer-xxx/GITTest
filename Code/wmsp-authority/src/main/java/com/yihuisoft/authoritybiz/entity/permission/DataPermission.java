package com.yihuisoft.authoritybiz.entity.permission;

import java.util.Date;
/**
 * 数据权限实体类
 * @author mengfanbang
 * @version 4.0.2
 * @date 2019/08/17 10:11
 * @author laijd
 */
public class DataPermission {
    /**主键id*/
    private Long id;
    /**数据权限名称*/
    private String name;
    /**1：本人机构相关，2：其他待定义*/
    private String type;
    /**是否正常1：是，0：否*/
    private String status;
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
    /**1：本人，2：本机构，3：本机构及自己够4：全部*/
    private String subType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }
}
