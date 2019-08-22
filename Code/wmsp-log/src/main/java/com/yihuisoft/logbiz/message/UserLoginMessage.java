package com.yihuisoft.logbiz.message;

import java.io.Serializable;
import java.util.Date;


/**
 *用户登录消息实体
 * @author zhangsh
 * @version V4.0.2
 * @date 2019/8/9 14:16
 */
public class UserLoginMessage implements Serializable {
    /**
     * 唯一标志
     **/
    private Long id;
    /**
     * 唯一标志
     **/
    private Long userId;

    /**
     * 唯一标志
     **/
    private String userName;
    /**
     * 角色ID
     **/
    private Long roleId;
    /**
     * 角色名称
     **/
    private String roleName;
    /**
     * 机构号
     **/
    private String orgnCode;
    /**
     * 机构名称
     **/
    private String orgnName;
    /**
     * 登陆日期
     **/
    private Date loginDate;
    /**
     * 登陆IP
     **/
    private String loginIp;
    /**
     * 登陆设备ID
     **/
    private String logDeviceId;
    /**
     * 登陆状态
     **/
    private String loginStatus;

    /**
     * 工作号
     **/
    private String workNo;
    /**
     * 原因
     **/
    private String reason;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode;
    }

    public String getOrgnName() {
        return orgnName;
    }

    public void setOrgnName(String orgnName) {
        this.orgnName = orgnName;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLogDeviceId() {
        return logDeviceId;
    }

    public void setLogDeviceId(String logDeviceId) {
        this.logDeviceId = logDeviceId;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    @Override
    public String toString() {
        return "UserLoginMessage{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", orgnCode='" + orgnCode + '\'' +
                ", orgnName='" + orgnName + '\'' +
                ", loginDate=" + loginDate +
                ", loginIp='" + loginIp + '\'' +
                ", logDeviceId='" + logDeviceId + '\'' +
                ", loginStatus='" + loginStatus + '\'' +
                ", workNo='" + workNo + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
