package com.yihuisoft.logbiz.dto.message;
/**
 * 定义前端传输公共字段
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */

import java.io.Serializable;


public class TransLogSocketQueryDTO implements Serializable {
    /**
     * 网点号
     */
    private String orgnCode;
    /**
     * socket通信类型
     */
    private String socketType;
    /**
     * 错误代码
     */
    private String transStatus;
    /**
     * 错误代码
     */
    private String transHead;
    /**
     * 交易开始时间（yyyy-MM-dd）
     */
    private String timeStart;
    /**
     * 交易结束时间（yyyy-MM-dd）
     */
    private String timeEnd;

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

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public String getTransHead() {
        return transHead;
    }

    public void setTransHead(String transHead) {
        this.transHead = transHead;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "TransLogSocketQueryDTO{" +
                "orgnCode='" + orgnCode + '\'' +
                ", socketType='" + socketType + '\'' +
                ", transStatus='" + transStatus + '\'' +
                ", transHead='" + transHead + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                '}';
    }
}
