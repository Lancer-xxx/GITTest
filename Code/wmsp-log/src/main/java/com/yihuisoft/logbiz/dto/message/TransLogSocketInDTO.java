package com.yihuisoft.logbiz.dto.message;
/**
 * 定义前端传输公共字段
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */

import java.io.Serializable;
import java.math.BigDecimal;

public class TransLogSocketInDTO implements Serializable {

    /**
     * 序号
     **/
    private String serialNo;

    /**
     * 服务号
     **/
    private String serviceNo;
    /**
     * 交易标注
     **/
    private String transMakr;
    /**
     * 交易码
     **/
    private String transHead;
    /**
     * 终端号
     **/
    private String terminalNo;
    /**
     * 设备号
     **/
    private String deviceId;

    /**
     * 卡号
     **/
    private String cardNo;

    /**
     * 交易时间
     **/
    private String transTime;
    /**
     * 发送报文
     **/
    private String socketSend;
    /**
     * 接收报文
     **/
    private String socketRec;

    /**
     * 错误码
     **/
    private String errorCode;

    /**
     * 错误消息
     **/
    private String errorMessage;
    /**
     * 定位
     **/
    private String errorLocation;
    /**
     * 错误描述
     **/
    private String errorDescription;
    /**
     * 错误堆栈
     **/
    private String errorStack;
    /**
     * 交易通讯是否成功
     **/
    private BigDecimal transStatus;

    /**
     * 网点号(机构CODE)
     **/
    private String orgnCode;

    /**
     * 报文类型
     **/
    private String socketType;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    public String getTransMakr() {
        return transMakr;
    }

    public void setTransMakr(String transMakr) {
        this.transMakr = transMakr;
    }

    public String getTransHead() {
        return transHead;
    }

    public void setTransHead(String transHead) {
        this.transHead = transHead;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public String getSocketSend() {
        return socketSend;
    }

    public void setSocketSend(String socketSend) {
        this.socketSend = socketSend;
    }

    public String getSocketRec() {
        return socketRec;
    }

    public void setSocketRec(String socketRec) {
        this.socketRec = socketRec;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorLocation() {
        return errorLocation;
    }

    public void setErrorLocation(String errorLocation) {
        this.errorLocation = errorLocation;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorStack() {
        return errorStack;
    }

    public void setErrorStack(String errorStack) {
        this.errorStack = errorStack;
    }

    public BigDecimal getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(BigDecimal transStatus) {
        this.transStatus = transStatus;
    }

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode;
    }

    public String getSocketType() {
        return socketType;
    }

    public void setSocketType(String socketType) {
        this.socketType = socketType;
    }

    @Override
    public String toString() {
        return "TransLogSocketInDTO{" +
                "serialNo='" + serialNo + '\'' +
                ", serviceNo='" + serviceNo + '\'' +
                ", transMakr='" + transMakr + '\'' +
                ", transHead='" + transHead + '\'' +
                ", terminalNo='" + terminalNo + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", transTime='" + transTime + '\'' +
                ", socketSend='" + socketSend + '\'' +
                ", socketRec='" + socketRec + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorLocation='" + errorLocation + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                ", errorStack='" + errorStack + '\'' +
                ", transStatus=" + transStatus +
                ", orgnCode='" + orgnCode + '\'' +
                ", socketType='" + socketType + '\'' +
                '}';
    }
}