package com.yihuisoft.logbiz.dto.job;


import java.io.Serializable;

/**
 * 定义前端传输公共字段
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */
public class JobRunlogFindDTO implements Serializable {
    /**
     * jobID
     */
    private Long jobId;
    /**
     * 运行结果
     */
    private Long resultStatus;
    /**
     * 任务名称
     */
    private String serviceName;
    /**
     * 结束日期
     */
    private String endTime;
    /**
     * 开始日期
     */
    private String startTime;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(Long resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}