package com.yihuisoft.maintenancebiz.constant.systemscreen;

/**
 * @author dim
 * @version V4.0.0
 * @Title:
 * @ProjectName yihuisoft-maintenance
 * @Description: 屏保管理有关的参数
 * @date 2019/7/10
 *
 * {
 *     outclass :  BeanSingleton
 *          innerClass:
 *
 * }
 */
public class SystemScreenValidationErrorMessage {

    public static final String ORG_CODE_EMPTY_ERROR = "组织机构编码不是是空的" ;

    public static final String PICTURE_ALIAS_NAME_EXISTING_ERROR = "文件别名重复";

    public static final String ID_IS_NULL_ERROR = "id不能为空";

    public static final String STATUS_ACTIVE = "1";

    public static final String STATUS_INACTIVE = "0";

    private SystemScreenValidationErrorMessage(){

    }
}
