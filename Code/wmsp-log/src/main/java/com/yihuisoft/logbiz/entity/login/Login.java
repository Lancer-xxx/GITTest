package com.yihuisoft.logbiz.entity.login;


/**
 * 定义前端传输公共字段
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */
public class Login {
    /**
     * 唯一标志
     **/
    private Long id;
    /**
     * 唯一标志
     **/
    private Long userId;
    /**
     * 系统ID
     **/
    private Long sysId;
    /**
     * 机构ID
     **/
    private Short organId;
    /**
     * 机构号
     **/
    private String orgnCode;
    /**
     * 登陆日期
     **/
    private String loginDate;
    /**
     * 推出系统日期
     **/
    private String logoutDate;
    /**
     * 登陆IP
     **/
    private String loginIp;
    /**
     * 登陆设备ID
     **/
    private String logDeviceId;
    /**
     * 登陆日期
     **/
    private String terminalMac;
    /**
     * 登陆渠道
     **/
    private String loginChannel;

    /**
     * 登陆状态1:成功，2：失败，3：异常，0：其他
     **/
    private String loginStatus;
    /**
     * 失败原因
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

    public Long getSysId() {
        return sysId;
    }

    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    public Short getOrganId() {
        return organId;
    }

    public void setOrganId(Short organId) {
        this.organId = organId;
    }

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode == null ? null : orgnCode.trim();
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
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getLogDeviceId() {
        return logDeviceId;
    }

    public void setLogDeviceId(String logDeviceId) {
        this.logDeviceId = logDeviceId == null ? null : logDeviceId.trim();
    }

    public String getTerminalMac() {
        return terminalMac;
    }

    public void setTerminalMac(String terminalMac) {
        this.terminalMac = terminalMac == null ? null : terminalMac.trim();
    }

    public String getLoginChannel() {
        return loginChannel;
    }

    public void setLoginChannel(String loginChannel) {
        this.loginChannel = loginChannel == null ? null : loginChannel.trim();
    }
}