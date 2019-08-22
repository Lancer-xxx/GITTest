package com.yihuisoft.logbiz.dto.satff;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 定义前端传输公共字段
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */
public class UserLoginLogInDTO implements Serializable {
    private Long id;
    /**
     * 用户ID
     **/
    @NotNull(message = "用户ID不能为空")
    private Long userId;
    /**
     * 系统ID
     **/

    private String sysId;
    @NotNull(message = "机构ID不能为空")
    /**机构ID**/

    private Long orgnId;
    @NotNull(message = "机构编码不能为空")
    /**网点号**/

    private String orgnCode;
    /**
     * 登录日期
     **/

    @NotNull(message = "登陆日期不能为空")
    private String loginDate;
    /**
     * 登出日期
     **/

    private String logoutDate;
    /**
     * 用户登录IP
     **/

    private String loginIp;
    /**
     * 设备ID
     **/

    private String logDeviceId;
    /**
     * 终端mac
     **/

    private String terminalMac;
    /**
     * 频道名称
     **/

    private String loginChannel;
    /**
     * 用户名
     **/
    @NotNull(message = "用户名不能为空")
    private String userName;
    /**
     * 工作号
     **/
    @NotNull(message = "工作号不能为空")
    private String workNo;
    /**
     * 角色ID
     **/
    @NotNull(message = "角色ID不能为空")
    private Long roleId;
    /**
     * 机构名称
     **/
    private String orgnName;

    /**
     * 角色名称
     **/
    private String roleName;
    /**
     * 登陆状态
     **/
    private String loginStatus;
    /**
     * 原因
     **/
    private String reason;


    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    public String getLogoutDate() {
        return logoutDate;
    }

    public void setLogoutDate(String logoutDate) {
        this.logoutDate = logoutDate;
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

    public String getTerminalMac() {
        return terminalMac;
    }

    public void setTerminalMac(String terminalMac) {
        this.terminalMac = terminalMac;
    }

    public String getLoginChannel() {
        return loginChannel;
    }

    public void setLoginChannel(String loginChannel) {
        this.loginChannel = loginChannel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }


    public String getOrgnName() {
        return orgnName;
    }

    public void setOrgnName(String orgnName) {
        this.orgnName = orgnName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrgnId() {
        return orgnId;
    }

    public void setOrgnId(Long orgnId) {
        this.orgnId = orgnId;
    }

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
        return "UserLoginLogInDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", sysId='" + sysId + '\'' +
                ", orgnId=" + orgnId +
                ", orgnCode='" + orgnCode + '\'' +
                ", loginDate='" + loginDate + '\'' +
                ", logoutDate='" + logoutDate + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", logDeviceId='" + logDeviceId + '\'' +
                ", terminalMac='" + terminalMac + '\'' +
                ", loginChannel='" + loginChannel + '\'' +
                ", userName='" + userName + '\'' +
                ", workNo='" + workNo + '\'' +
                ", roleId=" + roleId +
                ", orgnName='" + orgnName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", loginStatus='" + loginStatus + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
