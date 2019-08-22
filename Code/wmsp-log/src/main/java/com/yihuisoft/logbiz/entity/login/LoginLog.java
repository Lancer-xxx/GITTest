package com.yihuisoft.logbiz.entity.login;

/**
 * 定义前端传输公共字段
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */
public class LoginLog extends Login {
    /**
     * 用户名
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
     * 工作号
     **/
    private String workNo;
    /**
     * 机构名字
     **/
    private String orgnName;
    /**
     * 电话
     **/
    private String phone;
    /**
     * 性别
     **/
    private String gender;

    /**
     *开始时间
     **/
    private String startTime;
    /**
     * 结束时间
     **/
    private String endTime;

    /**
     * 机构编码
     */
    private String orgnCode;
    /**
     * 登录状态
     */
    private String loginStatus;
    /**
     * 原因
     */
    private String reason;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    @Override
    public String getOrgnCode() {
        return orgnCode;
    }

    @Override
    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
}
