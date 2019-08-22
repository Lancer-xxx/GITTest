package com.yihuisoft.customerbiz.entity;

import com.yihuisoft.common.base.SnowFlakeIdGen;
import com.yihuisoft.customerbiz.constant.contactplan.ContactPlanConstant;
import com.yihuisoft.customerbiz.dto.contactplan.ContactPlanAggregationDTO;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 销售线索的电访联络信息
 * @author: heyaning
 * @date: 2019/8/8 20:58
 * @version: 1.0
 **/
@Table(name="T_CUST_SALES_LEAD_CONTACT")
public class SalesLeadContact {
    @Id
    @KeySql(genId = SnowFlakeIdGen.class)
    private Long id;
    /**
     * 线索id
     */
    private Long contactResourceId;

    /**
     * 最新计划电访时间
     */
    private Date planedContactTime;

    /**
     * 未执行电访计划数
     */
    private Long unexecutePlanNum;

    /**
     * 最后电访时间
     */
    private Date lastContactTime;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 客户类型
     */
    private String customerType;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContactResourceId() {
        return contactResourceId;
    }

    public void setContactResourceId(Long contactResourceId) {
        this.contactResourceId = contactResourceId;
    }

    public Date getPlanedContactTime() {
        return planedContactTime;
    }

    public void setPlanedContactTime(Date planedContactTime) {
        this.planedContactTime = planedContactTime;
    }

    public Long getUnexecutePlanNum() {
        return unexecutePlanNum;
    }

    public void setUnexecutePlanNum(Long unexecutePlanNum) {
        this.unexecutePlanNum = unexecutePlanNum;
    }

    public Date getLastContactTime() {
        return lastContactTime;
    }

    public void setLastContactTime(Date lastContactTime) {
        this.lastContactTime = lastContactTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public static SalesLeadContact getContactInfo4SalesLead(ContactPlanAggregationDTO contactPlanAggregationDTO){
        SalesLeadContact salesLeadContact = new SalesLeadContact();
        salesLeadContact.setContactResourceId(contactPlanAggregationDTO.getContactResourceId());
        salesLeadContact.setLastContactTime(contactPlanAggregationDTO.getContactTime());
        salesLeadContact.setPlanedContactTime(contactPlanAggregationDTO.getPlanTime());
        salesLeadContact.setUnexecutePlanNum(contactPlanAggregationDTO.getUnexecutePlanNum());
        salesLeadContact.setCustomerType(ContactPlanConstant.TYPE_SALES_LEAD);
        return salesLeadContact;
    }
}
