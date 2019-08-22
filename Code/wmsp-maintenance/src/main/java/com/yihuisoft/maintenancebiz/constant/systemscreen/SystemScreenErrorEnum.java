package com.yihuisoft.maintenancebiz.constant.systemscreen;

 /**
 * @author dim
 * @version V4.0.0
 * @Title:
 * @ProjectName yihuisoft-maintenance
 * @Description: 系统字典的错误参数
 * @date 2019/7/10
 */
 public enum SystemScreenErrorEnum{
     /**
      * 图片大小错误
      */
    IMAGE_SIZE_ERROR("E0101", "图片尺寸不能过大"),

     /**
      * 图片名称别名已经存在错误
      */
    IMAGE_FILE_ALIAS_NAME_EXIST_ERROR("E0102", "图片别名已经存在"),
     /**
      * 组织机构不存在错误
      */
    ORG_NOT_EXIST_ERROR("E0103", "组织机构不存在"),
     /**
      * 屏保记录不存在错误
      */
    SYSTEM_SCREEN_NOT_EXIST_ERROR("E0104", "屏保记录不存在"),
     /**
      * 屏保已经被上层领导配置过了
      */
    SCREEN_CONFIGED_BY_LEADER_ALREADY("E0003","上级机构设置的屏保记录不可修改！"),
     /**
      * 屏保的图片不存在
      */
    SCREEN_IMAGE_IS_EMPTY("E0004","屏保的图片不存在！");

        /**
         * 错误编码
         */
        private String code;
        /**
         *  错误消息
         */
        private String message;

        private SystemScreenErrorEnum(String code,String message){
            this.code = code;
            this.message = message;
        }

     /**
      * 错误消息
      * @return
      */
     public String getMessage() {
            return message;
        }

     /**
      * 错误编码
      * @return
      */
     public String getCode() {
            return code;
        }

 }