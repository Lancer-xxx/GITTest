package com.yihuisoft.customerbiz.dto.contactplan;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 联络对象列表查询 数据传输对象
 * @author dim
 * @date 2019/8/9
 */
public class ContactPlanListDTO implements Serializable {

    /**
     * 客户id
     */
    private String customerId;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 销售线索客户的id
     */
    private String salesLeadId;

    /**
     * 电访计划的开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planTimeStart;

    /**
     * 电访计划的结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planTimeEnd;

    /**
     * 电访时间的开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date contactTimeStart;

    /**
     * 电访时间的结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date contactTimeEnd;

    /**
     * 电访目标
     */
    private String contactObjective;

    /**
     * 客户类型
     */
    private String customerType;

    /**
     * 电访状态
     */
    private String planStatus;

    /**
     * 登录用户的id
     */
    private Long userId;

    /**
     * 查询排序的字段
     */
    private String orderColumn;

    /**
     * 查询排序的顺序
     */
    private String orderAsc;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getSalesLeadId() {
        return salesLeadId;
    }

    public void setSalesLeadId(String salesLeadId) {
        this.salesLeadId = salesLeadId;
    }

    public Date getPlanTimeStart() {
        return planTimeStart;
    }

    public void setPlanTimeStart(Date planTimeStart) {
        this.planTimeStart = planTimeStart;
    }

    public Date getPlanTimeEnd() {
        return planTimeEnd;
    }

    public void setPlanTimeEnd(Date planTimeEnd) {
        this.planTimeEnd = planTimeEnd;
    }

    public Date getContactTimeStart() {
        return contactTimeStart;
    }

    public void setContactTimeStart(Date contactTimeStart) {
        this.contactTimeStart = contactTimeStart;
    }

    public Date getContactTimeEnd() {
        return contactTimeEnd;
    }

    public void setContactTimeEnd(Date contactTimeEnd) {
        this.contactTimeEnd = contactTimeEnd;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderAsc() {
        return orderAsc;
    }

    public void setOrderAsc(String orderAsc) {
        this.orderAsc = orderAsc;
    }
}
