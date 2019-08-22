package com.yihuisoft.customerbiz.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.common.base.SnowFlakeIdGen;
import com.yihuisoft.customerbiz.constant.SalesLeadRecordConstant;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 销售线索的操作记录
 * @author dim
 * @version V4.0.0

 * @date 2019/7/25
 */
@Table(name = "T_CUST_SALES_LEAD_RECORD")
public class SalesLeadRecord {
    @Id
    @Column(name = "ID")
    @KeySql(genId = SnowFlakeIdGen.class)
    private Long id;

    /**
     * 销售线索的id
     */
    private Long salesLeadId;

    /**
     * 操作类型
     */
    private String operateType;

    /**
     * 操作人的姓名
     */
    private String operatorName;

    /**
     * 操作人的角色
     */
    private String operatorRole;

    /**
     * 客户经理姓名
     */
    private String customerManager;

    /**
     * 操作人id
     */
    private String operatorId;

    /**
     * 操作人备注
     */
    private String operationDesc;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date operateTime;

    /**
     * 按操作类型，初始化销售线索的操作记录
     * @param salesLead
     * @param user
     * @param operateType
     * @return
     */
    public static SalesLeadRecord initSalesLeadRecord(SalesLead salesLead, User user, String operateType) {
        SalesLeadRecord salesLeadRecord = new SalesLeadRecord();

        salesLeadRecord.addAssignerInfo(user);

        salesLeadRecord.setOperateType(operateType);
        salesLeadRecord.setSalesLeadId(salesLead.getId());
        // 如果是分配
        if(SalesLeadRecordConstant.OPERATE_TYPE_ASSIGN.equals(operateType) || SalesLeadRecordConstant.OPERATE_TYPE_ASSIGN.equals(operateType)){
            salesLeadRecord.setCustomerManager(salesLead.getCustomerManager());
        }

        return salesLeadRecord;
    }

    /**
     * 按操作类型操作备注，初始化销售线索的操作记录
     * @param salesLead
     * @param user
     * @param operateType
     * @param operationDesc
     * @return
     */
    public static SalesLeadRecord initSalesLeadRecord(SalesLead salesLead, User user, String operateType,String operationDesc) {
        SalesLeadRecord salesLeadRecord = initSalesLeadRecord(salesLead,user,operateType);
        salesLeadRecord.setOperationDesc(operationDesc);
        return salesLeadRecord;
    }

    /**
     * 增加分配人的操作信息
     * @param assigner
     * @return
     */
    public SalesLeadRecord addAssignerInfo(User assigner){
        if(this != null && assigner != null){
            this.setOperatorId(Long.toString(assigner.getId()));
            this.setOperatorName(assigner.getUserName());
            this.setOperatorRole(assigner.getRoleName());
        }
        return this;
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

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorRole() {
        return operatorRole;
    }

    public void setOperatorRole(String operatorRole) {
        this.operatorRole = operatorRole;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperationDesc() {
        return operationDesc;
    }

    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc;
    }

    public void setSalesLeadId(Long salesLeadId) {
        this.salesLeadId = salesLeadId;
    }

    public String getCustomerManager() {
        return customerManager;
    }

    public void setCustomerManager(String customerManager) {
        this.customerManager = customerManager;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}
