package com.yihuisoft.logbiz.entity.log;


/**
 * 实体
 * @author genghongbo
 * @version V4.0.2
 * @date 2019/8/11 16:55
 */
public class JobRunlog {
    /**
     * id
     */
    private Long id;
    /**
     * 创建日期
     */
    private String gmtCreate;
    /**
     * 修改日期
     */
    private String gmtModified;
    /**
     * jobID
     */
    private Long jobId;
    /**
     * job描述
     */
    private String jobDesc;
    /**
     * 运行日期
     */
    private String runDate;
    /**
     * 运行次数
     */
    private Long runTimes;
    /**
     * 运行结果
     */
    private Long resultStatus;
    /**
     * 备注
     */
    private String memo;
    /**
     * 修改时间
     */
    private String endTime;

    /**
     * 任务名称
     */
    private String serviceName;

    /**
     * 出错信息
     */
    private String mistakeInform;

    /**
     * 执行人
     */
    private String executeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getRunDate() {
        return runDate;
    }

    public void setRunDate(String runDate) {
        this.runDate = runDate;
    }

    public Long getRunTimes() {
        return runTimes;
    }

    public void setRunTimes(Long runTimes) {
        this.runTimes = runTimes;
    }

    public Long getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(Long resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMistakeInform() {
        return mistakeInform;
    }

    public void setMistakeInform(String mistakeInform) {
        this.mistakeInform = mistakeInform;
    }

    public String getExecuteId() {
        return executeId;
    }

    public void setExecuteId(String executeId) {
        this.executeId = executeId;
    }

    @Override
    public String toString() {
        return "JobRunlog{" +
                "id=" + id +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", gmtModified='" + gmtModified + '\'' +
                ", jobId=" + jobId +
                ", jobDesc='" + jobDesc + '\'' +
                ", runDate='" + runDate + '\'' +
                ", runTimes=" + runTimes +
                ", resultStatus=" + resultStatus +
                ", memo='" + memo + '\'' +
                ", endTime='" + endTime + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", mistakeInform='" + mistakeInform + '\'' +
                ", executeId='" + executeId + '\'' +
                '}';
    }
}