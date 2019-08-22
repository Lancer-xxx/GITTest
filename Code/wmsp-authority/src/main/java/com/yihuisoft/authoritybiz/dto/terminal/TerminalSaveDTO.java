package com.yihuisoft.authoritybiz.dto.terminal;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 新增设备DTO对象
 * @author topz
 * @date 2019/7/16 16:35
 * @version V4.0.0
 **/
public class TerminalSaveDTO {

    /** 设备标识 */
    @NotBlank(message = "设备表示不能为空！")
    private String logDeviceId;

    /** 机构代码 */
    @NotBlank(message = "机构代码不能为空！")
    private String orgnCode;

    /** 交易行号 */
    @NotBlank(message = "交易行号不能为空！")
    private String bankNo;

    /** 交易终端号 */
    private String transNo;

    /** 交易柜员号 */
    @NotBlank(message = "交易柜员号不能为空！")
    private String tellerNo;

    /** 设备MAC */
    private String terminalMac;

    /** IP地址 */
    @NotBlank(message = "ip地址不能为空！")
    private String terminalIp;

    /** 负责人 */
    private String userName;

    /** 贵宾室 */
    private String vipAddr;

    /** 备注 */
    private String termNote;

    /** 起效时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @NotNull(message = "起效时间不能为空！")
    private Date startDate;

    /** 截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @NotNull(message = "截止时间不能为空！")
    private Date endDate;


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

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode;
    }

    public String getTerminalIp() {
        return terminalIp;
    }

    public void setTerminalIp(String terminalIp) {
        this.terminalIp = terminalIp;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getTellerNo() {
        return tellerNo;
    }

    public void setTellerNo(String tellerNo) {
        this.tellerNo = tellerNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVipAddr() {
        return vipAddr;
    }

    public void setVipAddr(String vipAddr) {
        this.vipAddr = vipAddr;
    }

    public String getTermNote() {
        return termNote;
    }

    public void setTermNote(String termNote) {
        this.termNote = termNote;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    @Override
    public String toString() {
        return "TerminalSaveDTO{" +
                "logDeviceId='" + logDeviceId + '\'' +
                ", orgnCode='" + orgnCode + '\'' +
                ", bankNo='" + bankNo + '\'' +
                ", transNo='" + transNo + '\'' +
                ", tellerNo='" + tellerNo + '\'' +
                ", terminalMac='" + terminalMac + '\'' +
                ", terminalIp='" + terminalIp + '\'' +
                ", userName='" + userName + '\'' +
                ", vipAddr='" + vipAddr + '\'' +
                ", termNote='" + termNote + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
