package com.yihuisoft.customerbiz.entity;

import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.common.base.SnowFlakeIdGen;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 销售线索的归属信息实体
 * @author dim
 * @version V4.0.0
 * @date 2019/7/25
 */
@Table(name = "T_CUST_SALES_LEAD_OWNERSHIP")
public class SalesLeadOwnership {

    @Id
    @KeySql(genId = SnowFlakeIdGen.class)
    private Long id;

    /**
     * 销售线索的id
     */
    private Long salesLeadId;

    /**
     * 客户经理id
     */
    private Long customerManagerId;

    /**
     * 组织机构id
     */
    private Long organizationId;

    /**
     * 组织机构编码
     */
    private String organizationCode;

    /**
     * 初始化销售线索的所属信息
     * 初始化使，客户经理的id为空
     * @param salesLead
     * @param user
     * @return
     */
    public static SalesLeadOwnership initSalesLeadOwnership(SalesLead salesLead, User user) {
        SalesLeadOwnership salesLeadOwnership = new SalesLeadOwnership();
        salesLeadOwnership.setSalesLeadId(salesLead.getId());
        salesLeadOwnership.setOrganizationId(user.getOrgnId());
        salesLeadOwnership.setOrganizationCode(user.getOrgnCode());
        salesLeadOwnership.setCustomerManagerId(null);

        return salesLeadOwnership;
    }

    /**
     * 销售线索信息分配给自己的
     * @param salesLead
     * @param user
     * @return
     */
    public static SalesLeadOwnership selfAssignSalesLeadOwnership(SalesLead salesLead, User user) {
        SalesLeadOwnership salesLeadOwnership = initSalesLeadOwnership(salesLead,user);

        salesLeadOwnership.setCustomerManagerId(user.getId());
        return salesLeadOwnership;
    }

    /**
     * 获取空的销售线索信息，所有人是user的所属信息
     * @param user
     * @return
     */
    public static SalesLeadOwnership getEmptySalesLeadOfOwner(User user) {
        SalesLeadOwnership salesLeadOwnership = new SalesLeadOwnership();
        salesLeadOwnership.setOrganizationId(user.getOrgnId());
        salesLeadOwnership.setOrganizationCode(user.getOrgnCode());
        salesLeadOwnership.setCustomerManagerId(user.getId());

        return salesLeadOwnership;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSalesLeadId() {
        return salesLeadId;
    }

    public void setSalesLeadId(Long salesLeadId) {
        this.salesLeadId = salesLeadId;
    }

    public Long getCustomerManagerId() {
        return customerManagerId;
    }

    public void setCustomerManagerId(Long customerManagerId) {
        this.customerManagerId = customerManagerId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }
}
