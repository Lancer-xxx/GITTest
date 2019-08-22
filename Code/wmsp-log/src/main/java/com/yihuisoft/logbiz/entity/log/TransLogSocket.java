package com.yihuisoft.logbiz.entity.log;

/**
 * 定义前端传输公共字段
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */
public class TransLogSocket {
    /**
     * 交易吗
     **/
    private String rowid;
    /**
     * 交易吗
     **/
    private String serialNo;

    /**
     * 服务号
     **/
    private String serviceNo;
    /**
     * 交易吗
     **/
    private String transMakr;
    /**
     * 交易吗
     **/
    private String transHead;
    /**
     * 交易吗
     **/
    private String terminalNo;
    /**
     * 交易吗
     **/
    private String deviceId;

    /**
     * 卡号
     **/
    private String cardNo;

    /**
     * 客户工号
     **/
    private String cis;

    /**
     * 交易时间
     **/
    private String transTime;
    /**
     * 报文发送
     **/
    private String socketSend;
    /**
     * 报文接受
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
     * 错误位置
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
     * 响应时间
     **/
    private String transRespTime;
    /**
     * ID
     **/
    private Long id;
    /**
     * 交状态
     **/
    private Long transStatus;

    /**
     * 网点号
     **/
    private String orgnCode;

    /**
     * 报文类型
     **/
    private String socketType;

    public String getRowid() {
        return rowid;
    }

    public void setRowid(String rowid) {
        this.rowid = rowid;
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

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo == null ? null : serviceNo.trim();
    }

    public String getTransMakr() {
        return transMakr;
    }

    public void setTransMakr(String transMakr) {
        this.transMakr = transMakr == null ? null : transMakr.trim();
    }

    public String getTransHead() {
        return transHead;
    }

    public void setTransHead(String transHead) {
        this.transHead = transHead == null ? null : transHead.trim();
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo == null ? null : terminalNo.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getCis() {
        return cis;
    }

    public void setCis(String cis) {
        this.cis = cis == null ? null : cis.trim();
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }



    public String getTransRespTime() {
        return transRespTime;
    }

    public void setTransRespTime(String transRespTime) {
        this.transRespTime = transRespTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(Long transStatus) {
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


}