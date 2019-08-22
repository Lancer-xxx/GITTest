package com.yihuisoft.customerbiz.constant;

import com.yihuisoft.common.dto.IResultEnum;

/**
 * 客户模块错误消息的枚举
 * @author dim
 * @date 2019/8/14
 */
public enum ErrorResultEnum implements IResultEnum {

    // 线索有关的错误代码
    SAVING_INVALID_SALESLEAD_PHONE_ERROR("E08101","该线索没有手机号，不能制定联络计划"),
    SAVING_INVALID_CUSTOMER_PHONE_ERROR("E08102","该客户没有手机号，不能制定联络计划"),
    REMARK_TOO_LONG_ERROR("E08103","备注最多输入200个字符"),
    NO_PLAN_TIME_ERROR("E08104","请选择电访时间"),
    PLAN_TIME_INVALID_ERROR("E08105","请选择正确的日期和时间"),
    ERROR_SAVE_REPEATED_ID("E08106","该身份证号对应线索客户已存在"),
    ERROR_SAVE_TOO_LONG_REMARK("E08107","备注最多输入200个字母或汉字"),
    ERROR_HAS_NO_DATA_ACCESS_PREVILLEGE("E08108","您没有权限删除该线索客户"),
    ERROR_NO_USER("E08109","用户信息不存在"),
    ERROR_NO_USER_PERMISSION("E08110","用户数据权限获取失败！"),
    // 联络计划有关的错误代码
    ERROR_SAVING_EMPTY_CONTACT("E08201","您没有选择客户信息");



    /**
     * 错误编码
     */
    private String code;
    /**
     *  错误消息
     */
    private final String message;

    private ErrorResultEnum(String code,String message){
        this.code = code;
        this.message = message;
    }

    /**
     * 错误消息
     * @return
     */
    @Override
    public final String getMessage() {
        return message;
    }

    /**
     * 错误编码
     * @return
     */
    @Override
    public String getCode() {
        return code;
    }
}
