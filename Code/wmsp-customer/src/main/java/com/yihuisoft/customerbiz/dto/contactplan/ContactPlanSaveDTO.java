package com.yihuisoft.customerbiz.dto.contactplan;

import com.yihuisoft.customerbiz.entity.SalesLead;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 联络计划的保存 数据传输对象
 * @author dim
 * @date 2019/8/9
 */
public class ContactPlanSaveDTO implements Serializable {

    /**
     * 销售线索
     */
    @ApiModelProperty("销售线索的具体信息")
    private SalesLead salesLead;

    /**
     * 电访计划时间
     */
    @ApiModelProperty("电访计划时间")
    private Date planTime;

    /**
     * 电访时间
     */
    @ApiModelProperty("电访时间")
    private Date contactTime;

    /**
     * 电访目标
     */
    @ApiModelProperty("电访目标")
    private String contactObjective;

    /**
     * 客户性质
     */
    @ApiModelProperty("客户性质")
    private String customerType;

    /**
     * 电访计划状态
     */
    @ApiModelProperty("计划状态")
    private String planStatus;

    public SalesLead getSalesLead() {
        return salesLead;
    }

    public void setSalesLead(SalesLead salesLead) {
        this.salesLead = salesLead;
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
}
