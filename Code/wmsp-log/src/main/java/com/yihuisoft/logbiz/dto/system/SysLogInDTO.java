package com.yihuisoft.logbiz.dto.system;


import java.io.Serializable;

/**
 * 定义前端传输公共字段
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */

public class SysLogInDTO implements Serializable {

    /**
     * 异常编码
     **/
    private String excepCode;
    /**
     * ID
     **/
    private Long id;
    /**
     * 用户ID
     **/
    private String userId;
    /**
     * 操作名称
     **/
    private String operation;
    /**
     * 请求地址
     **/
    private String reqIp;
    /**
     * 请求时间
     **/
    private String reqTime;
    /**
     * 类名
     **/
    private String clss;
    /**
     * 方法
     **/
    private String method;
    /**
     * 参数
     **/
    private String params;
    /**
     * 异常信息
     **/
    private String excepDetail;
    /**
     * 状态
     **/
    private String status;
    /**
     * 业务类型
     **/
    private String busiType;

    public String getExcepCode() {
        return excepCode;
    }

    public void setExcepCode(String excepCode) {
        this.excepCode = excepCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "SysLogInDTO{" +
                "excepCode='" + excepCode + '\'' +
                ", id=" + id +
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
                '}';
    }
}