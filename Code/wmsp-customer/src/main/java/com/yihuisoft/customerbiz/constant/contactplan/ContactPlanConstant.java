package com.yihuisoft.customerbiz.constant.contactplan;

/**
 * 客户线索有关的常量
 * @author dim
 * @date 2019/8/10
 */
public class ContactPlanConstant {

    /**
     * 客户类型 客户
     */
    public static final String TYPE_CUSTOMER = "customer";

    /**
     * 客户类型 线索客户
     */
    public static final String TYPE_SALES_LEAD = "salesLeadCustomer";

    /**
     * 计划状态 未执行
     */
    public static final String STATUS_UN_EXECUTED = "undo";


    /**
     * 计划状态 已完成
     */
    public static final String STATUS_COMPLETED = "completed";

    /**
     * 计划状态 已取消
     */
    public static final String STATUS_CANCELED = "cancelled";

    /**
     * 是否有联络计划 无
     */
    public static final String CONTACT_PLAN_NOT_EXIST = "0";

    /**
     * 是否有联络计划 有
     */
    public static final String CONTACT_PLAN_EXISTS = "1";

    /**
     * 联络类型 电访
     */
    public static final String CONTACT_TYPE_MOBILE_CALL = "mobileCall";

}
