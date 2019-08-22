package com.yihuisoft.customerbiz.dto.contactplan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 批量操作联络计划的数据传输对象
 * @author dim
 * @date 2019/8/9
 */
public class BatchContactPlanDTO implements Serializable {

    /**
     * 联络对象的id 集合
     */
    @JsonTypeInfo(use = JsonTypeInfo.Id.NONE,include = JsonTypeInfo.As.WRAPPER_ARRAY)
    public Set<Long> idSet;

    /**
     * 计划电访时间
     */
    @ApiModelProperty(value = "计划电访时间",required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planTime;

    /**
     * 最后电访时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date contactTime;

    /**
     * 电访目标
     */
    private String contactObjective;

    /**
     * 客户类型
     */
    private String customerType;

    /**
     * 联络的状态
     */
    private String planStatus;

    private String contactType;

    private String remark;

    public Set<Long> getIdSet() {
        return idSet;
    }

    public void setIdSet(Set<Long> idSet) {
        this.idSet = idSet;
    }

    public Date getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Date planTime) {
        this.planTime = planTime;
    }

    public Date getContactTime() {
        return contactTime;
    }

    public void setContactTime(Date contactTime) {
        this.contactTime = contactTime;
    }

    public String getContactObjective() {
        return contactObjective;
    }

    public void setContactObjective(String contactObjective) {
        this.contactObjective = contactObjective;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
