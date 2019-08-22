package com.yihuisoft.maintenancebiz.constant.systemparam;

/**
 * @author dim
 * @version V4.0.0
 * @Title: ValidationErrorMessage
 * @ProjectName yihui-maintenance
 * @Description:
 * @date 2019/6/26
 */
public enum SystemParamError{

    /**
     * 系统参数已经存在
     */
    SYSTEM_PAEAM_ALREADY_EXIST("E0101", SystemParamErrorMessage.PARAM_NAME_EXIST_ALREADY);

    /**
     * 字典类型错误的编码
     */
    private String code;

    /**
     * 字典类型错误的消息
     */
    private String message;

    private SystemParamError(String code,String message){
        this.code = code;
        this.message = message;
    }

        public String getMessage() {
            return message;
        }

        public String getCode() {
            return code;
        }
}