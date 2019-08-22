package com.yihuisoft.authoritybiz.dto.terminal;

import java.util.Date;

/**
 * 分页传入实体类
 * @author topz
 * @date 2019/7/16 16:35
 * @version V4.0.0
 **/
public class TerminalPageDTO {

    /**终端设备标识*/
    private String logDeviceId;

    /**交易终端号*/
    private String transNo;

    /**交易行号*/
    private String bankNo;

    /** 机构代码 */
    private String orgnCode;

    /** 交易柜员号 */
    private String tellerNo;

    public String getLogDeviceId() {
        return logDeviceId;
    }

    public void setLogDeviceId(String logDeviceId) {
        this.logDeviceId = logDeviceId;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode;
    }

    public String getTellerNo() {
        return tellerNo;
    }

    public void setTellerNo(String tellerNo) {
        this.tellerNo = tellerNo;
    }

    @Override
    public String toString() {
        return "TerminalPageDTO{" +
                "logDeviceId='" + logDeviceId + '\'' +
                ", transNo='" + transNo + '\'' +
                ", bankNo='" + bankNo + '\'' +
                ", orgnCode='" + orgnCode + '\'' +
                ", tellerNo='" + tellerNo + '\'' +
                '}';
    }
}
