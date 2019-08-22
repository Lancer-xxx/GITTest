package com.yihuisoft.logbiz.dto.satff;


import java.io.Serializable;

/**
 * 定义前端传输公共字段
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */

public class UserLoginLogQueryDTO implements Serializable {

    /**
     * 人员姓名
     */
    private String userName;
    /**
     * 人员工号
     */
    private String workNo;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 机构编码
     */
    private String orgnCode;
    /**
     *开始时间
     **/
    private String startTime;
    /**
     * 结束时间
     **/
    private String endTime;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode;
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

    @Override
    public String toString() {
        return "UserLoginLogQueryDTO{" +
                "userName='" + userName + '\'' +
                ", workNo='" + workNo + '\'' +
                ", roleId=" + roleId +
                ", orgnCode='" + orgnCode + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
