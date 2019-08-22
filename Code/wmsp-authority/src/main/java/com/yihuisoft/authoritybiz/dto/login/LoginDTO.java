package com.yihuisoft.authoritybiz.dto.login;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 人员管理-登录信息DTO
 * @author laijd
 * @date 2019/07/17
 * @version V4.0.0
 */
public class LoginDTO implements Serializable {

    /**输入的用户名*/
    @NotNull(message = "用户名不能为空！")
    private String userCode;

    /**终端登录设备的ip地址*/
    @NotNull(message = "终端登录设备的ip地址不能为空！")
    private String ip;

    /**终端登录设备的mac地址*/
    @NotNull(message = "终端登录设备的mac地址不能为空！")
    private String macId;

    /**终端标识 1为终端，0为网页*/
    private String flag;

    /**登录设备的Id*/
    private String logDeviceId;

    /**输入的密码*/
    @NotNull(message = "密码菜单URL不能为空！")
    private String passWord;

    /**是否需要密码标识 true 密码登录,false 指纹登录*/
    @NotNull(message = "是否需要密码标识不能为空！")
    private String isPasswordLoginFlag;

    /**指纹仪设备类型*/
    private String companyType;

    /**指纹特征值*/
    private String fingerPrint;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public String getFlag() {
        return flag;
    }

    public String getLogDeviceId() {
        return logDeviceId;
    }

    public void setLogDeviceId(String logDeviceId) {
        this.logDeviceId = logDeviceId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getIsPasswordLoginFlag() {
        return isPasswordLoginFlag;
    }

    public void setIsPasswordLoginFlag(String isPasswordLoginFlag) {
        this.isPasswordLoginFlag = isPasswordLoginFlag;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "userCode='" + userCode + '\'' +
                ", ip='" + ip + '\'' +
                ", macId='" + macId + '\'' +
                ", flag='" + flag + '\'' +
                ", logDeviceId='" + logDeviceId + '\'' +
                ", passWord='" + passWord + '\'' +
                ", isPasswordLoginFlag='" + isPasswordLoginFlag + '\'' +
                ", companyType='" + companyType + '\'' +
                ", fingerPrint='" + fingerPrint + '\'' +
                '}';
    }
}
