package com.yihuisoft.authoritybiz.entity.system;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统信息
 * @author huangxj
 * @version V4.0.0
 * @date 2019/6/28 11:56
 */
public class SystemModel implements Serializable {
    /**系统ID*/
    private Long id;
    /**系统编码*/
    private String sysCode;
    /**系统名称*/
    private String sysName;
    /**系统主机名*/
    private String sysHost;
    /**系统端口*/
    private String sysPort;
    /**状态*/
    private String status;
    /**创建人ID*/
    private Long createUserid;
    /**创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    /**更新人ID*/
    private Long updateUserid;
    /**更新时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysHost() {
        return sysHost;
    }

    public void setSysHost(String sysHost) {
        this.sysHost = sysHost;
    }

    public String getSysPort() {
        return sysPort;
    }

    public void setSysPort(String sysPort) {
        this.sysPort = sysPort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Long createUserid) {
        this.createUserid = createUserid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Long updateUserid) {
        this.updateUserid = updateUserid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}