package com.yihuisoft.authoritybiz.entity.terminal;
import java.util.Date;

/**
 * 终端实体类
 * @author topz
 * @date 2019/7/16 16:35
 * @version V4.0.0
 **/
public class Terminal {

    /** 设备标识 */
    private String logDeviceId;
    /** 设备MAC */
    private String terminalMac;
    /** 机构代码 */
    private String orgnCode;
    /** IP地址 */
    private String terminalIp;
    /** 交易行号 */
    private String bankNo;
    /** 交易终端号 */
    private String transNo;
    /** 交易柜员号 */
    private String tellerNo;
    /** 负责人 */
    private String userName;
    /** 贵宾室 */
    private String vipAddr;
    /** 备注 */
    private String termNote;
    /** 起效时间 */
    private Date startDate;
    /** 截止时间 */
    private Date endDate;

    private String mainCode;
    private String workCode;
    private String workCodeDate;
    private String code;

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

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode == null ? null : orgnCode.trim();
    }

    public String getTerminalIp() {
        return terminalIp;
    }

    public void setTerminalIp(String terminalIp) {
        this.terminalIp = terminalIp == null ? null : terminalIp.trim();
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo == null ? null : transNo.trim();
    }

    public String getTellerNo() {
        return tellerNo;
    }

    public void setTellerNo(String tellerNo) {
        this.tellerNo = tellerNo == null ? null : tellerNo.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getVipAddr() {
        return vipAddr;
    }

    public void setVipAddr(String vipAddr) {
        this.vipAddr = vipAddr == null ? null : vipAddr.trim();
    }

    public String getTermNote() {
        return termNote;
    }

    public void setTermNote(String termNote) {
        this.termNote = termNote == null ? null : termNote.trim();
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

    public String getMainCode() {
        return mainCode;
    }

    public void setMainCode(String mainCode) {
        this.mainCode = mainCode;
    }

    public String getWorkCode() {
        return workCode;
    }

    public void setWorkCode(String workCode) {
        this.workCode = workCode;
    }

    public String getWorkCodeDate() {
        return workCodeDate;
    }

    public void setWorkCodeDate(String workCodeDate) {
        this.workCodeDate = workCodeDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}