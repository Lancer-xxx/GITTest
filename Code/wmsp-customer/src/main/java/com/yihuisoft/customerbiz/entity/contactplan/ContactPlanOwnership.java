package com.yihuisoft.customerbiz.entity.contactplan;

import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.common.base.SnowFlakeIdGen;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 联络计划的归属信息
 * @author dim
 * @date 2019/8/7
 */
@Table(name = "T_CUST_CONTACT_PLAN_OWNERSHIP")
public class ContactPlanOwnership {

    /**
     * id
     */
    @Id
    @KeySql(genId = SnowFlakeIdGen.class)
    private Long id;

    private Long contactPlanId;

    /**
     * 所有人的id
     */
    private Long ownerUserId;

    /**
     * 客户类型
     */
    private String customerType;


    /**
     * 客户的所有者id
     */
    private Long customerOwnerId;

    /**
     * 所属人的机构id
     */
    @Transient
    private String organizationId;

    /**
     * 所属的父机构
     */
    @Transient
    private String parentOrginzations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Long ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getParentOrginzations() {
        return parentOrginzations;
    }

    public void setParentOrginzations(String parentOrginzations) {
        this.parentOrginzations = parentOrginzations;
    }

    public Long getContactPlanId() {
        return contactPlanId;
    }

    public void setContactPlanId(Long contactPlanId) {
        this.contactPlanId = contactPlanId;
    }

    public Long getCustomerOwnerId() {
        return customerOwnerId;
    }

    public void setCustomerOwnerId(Long customerOwnerId) {
        this.customerOwnerId = customerOwnerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    /**
     * 生成联络计划的所有关系数据
     * @param contactPlan
     * @param user
     * @return
     */
    public static ContactPlanOwnership getContactPlanOwnership(ContactPlan contactPlan, User user){
        ContactPlanOwnership contactPlanOwnership = new ContactPlanOwnership();
        contactPlanOwnership.setContactPlanId(contactPlan.getId());
        contactPlanOwnership.setOwnerUserId(user.getId());
        contactPlanOwnership.setCustomerType(contactPlan.getCustomerType());

        return contactPlanOwnership;
    }
}