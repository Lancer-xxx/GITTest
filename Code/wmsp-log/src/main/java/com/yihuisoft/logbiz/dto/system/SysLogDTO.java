package com.yihuisoft.logbiz.dto.system;


import java.io.Serializable;

/**
 * 定义前端传输公共字段
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */

public class SysLogDTO implements Serializable {

    /**
     * 请求IP
     */
    private String reqIp;
    /**
     * 操作名称
     */
    private String operation;
    /**
     * 请求开始时间（yyyy-MM-dd）
     */
    private String startTime;
    /**
     * 请求结束时间（yyyy-MM-dd）
     */
    private String endTime;
    /**
     * 记录状态
     */
    private String status;
    /**
     * 页面大小
     */
    private Integer pageSize;
    /**
     * 当前页码
     */
    private Integer pageNo;

    public String getReqIp() {
        return reqIp;
    }

    public void setReqIp(String reqIp) {
        this.reqIp = reqIp;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "SysLogDTO{" +
                "reqIp='" + reqIp + '\'' +
                ", operation='" + operation + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", status='" + status + '\'' +
                ", pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                '}';
    }
}
