package com.yihuisoft.customerbiz.dto.contactplan;

import com.yihuisoft.customerbiz.constant.contactplan.ContactPlanConstant;

import java.io.Serializable;
import java.util.Date;

/**
 * 电访信息的统计信息的数据传输对象
 * @author dim
 * @date 2019/8/12
 */
public class ContactPlanAggregationDTO implements Serializable {

    /**
     * 联络资源信息的id
     */
    private Long contactResourceId;

    /**
     * 最后联络时间
     */
    private Date contactTime;

    /**
     * 计划联络时间
     */
    private Date planTime;

    /**
     * 是否有未执行的联络信息
     */
    private String ifPlanNonExecution;

    /**
     * 未执行的联络计划数量
     */
    private Long unexecutePlanNum;

    /**
     * 客户类型
     */
    private String customerType;

    /**
     * 默认的 电访联络数据
     * @param contactResourceId
     * @return
     */
    public static ContactPlanAggregationDTO getDefaultInstance(Long contactResourceId){
        ContactPlanAggregationDTO instance = new ContactPlanAggregationDTO();

        instance.setContactResourceId(contactResourceId);
        instance.setIfPlanNonExecution(ContactPlanConstant.CONTACT_PLAN_NOT_EXIST);

        return instance;
    }

    public Long getContactResourceId() {
        return contactResourceId;
    }

    public void setContactResourceId(Long contactResourceId) {
        this.contactResourceId = contactResourceId;
    }

    public Date getContactTime() {
        return contactTime;
    }

    public void setContactTime(Date contactTime) {
        this.contactTime = contactTime;
    }

    public Date getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Date planTime) {
        this.planTime = planTime;
    }

    public String getIfPlanNonExecution() {
        return ifPlanNonExecution;
    }

    public void setIfPlanNonExecution(String ifPlanNonExecution) {
        this.ifPlanNonExecution = ifPlanNonExecution;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Long getUnexecutePlanNum() {
        return unexecutePlanNum;
    }

    public void setUnexecutePlanNum(Long unexecutePlanNum) {
        this.unexecutePlanNum = unexecutePlanNum;
    }

}
