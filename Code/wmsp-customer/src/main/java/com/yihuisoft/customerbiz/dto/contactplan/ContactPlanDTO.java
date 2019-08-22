package com.yihuisoft.customerbiz.dto.contactplan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yihuisoft.common.base.SnowFlakeIdGen;
import io.swagger.annotations.ApiModelProperty;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @author dim
 * @date 2019/8/17
 */
public class ContactPlanDTO {
    /**
     * id
     */
    @Id
    @KeySql(genId = SnowFlakeIdGen.class)
    private Long id;

    /**
     * 客户类型
     */
    @ApiModelProperty(value = "客户类型",required = true)
    private String customerType;

    /**
     * 联络方式
     */
    @ApiModelProperty(value = "联络方式",required = true)
    private String contactType;

    @ApiModelProperty(value = "计划电访时间",required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planTime;

    @ApiModelProperty(value = "最后电访时间",required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date contactTime;

    @ApiModelProperty(value = "电访目标",required = true)
    private String contactObjective;

    @ApiModelProperty(value = "电访状态",required = false)
    private String planStatus;

    @ApiModelProperty(value = "客户姓名",required = true)
    private String customerName;

    @ApiModelProperty(value = "手机号码",required = true)
    private String phone;

    @ApiModelProperty(value = "客户id/销售线索客户的id",required = true)
    private Long contactResourceId;

    /**
     * 销售线索的id
     */
    private Long salesLeadId;

    /**
     * 客户的id
     */
    @Transient
    private Long customerId;

    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
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

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getContactResourceId() {
        return contactResourceId;
    }

    public void setContactResourceId(Long contactResourceId) {
        this.contactResourceId = contactResourceId;
    }

    public Long getSalesLeadId() {
        return salesLeadId;
    }

    public void setSalesLeadId(Long salesLeadId) {
        this.salesLeadId = salesLeadId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
