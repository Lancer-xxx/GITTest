package com.yihuisoft.logbiz.dto.deal;


import java.io.Serializable;

/**
 * 定义前端传输公共字段
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */
public class SysTransactionLogDTO implements Serializable {
    /**
     * 异常Code
     */
    private String excepCode;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 操作名称
     */
    private String operation;
    /**
     * 请求ip
     */
    private String reqIp;
    /**
     * 请求时间
     */
    private String reqTime;
    /**
     * 访问类名
     */
    private String clss;
    /**
     * 方法名
     */
    private String method;
    /**
     * 请求参数
     */
    private String params;
    /**
     * 异常信息
     */
    private String excepDetail;
    /**
     * 状态
     */
    private String status;
    /**
     * xxxx
     */
    private String busiType;
    /**
     * 网点号
     */
    private String orgnCode;


    public String getExcepCode() {
        return excepCode;
    }

    public void setExcepCode(String excepCode) {
        this.excepCode = excepCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getReqIp() {
        return reqIp;
    }

    public void setReqIp(String reqIp) {
        this.reqIp = reqIp;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public String getClss() {
        return clss;
    }

    public void setClss(String clss) {
        this.clss = clss;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getExcepDetail() {
        return excepDetail;
    }

    public void setExcepDetail(String excepDetail) {
        this.excepDetail = excepDetail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode;
    }

    @Override
    public String toString() {
        return "SysTransactionLogDTO{" +
                "excepCode='" + excepCode + '\'' +
                ", userId='" + userId + '\'' +
                ", operation='" + operation + '\'' +
                ", reqIp='" + reqIp + '\'' +
                ", reqTime='" + reqTime + '\'' +
                ", clss='" + clss + '\'' +
                ", method='" + method + '\'' +
                ", params='" + params + '\'' +
                ", excepDetail='" + excepDetail + '\'' +
                ", status='" + status + '\'' +
                ", busiType='" + busiType + '\'' +
                ", orgnCode='" + orgnCode + '\'' +
                '}';
    }
}