package com.yihuisoft.common.dto;

/**
 * 返回码
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/1 16:20
 */
public enum ResultEnum implements IResultEnum{

    /**操作成功*/
    SUCCESS("E00000","操作成功"),
    /**自定义错误码*/
    ERROR_COMMON("E88888",""),

    /**列表查询失败*/
    ERROR_RESULT_FALSE("E03001","任务列表查询失败"),
    /**列表查询失败*/
    ERROR_RESULT_EXECUTE("E03002","任务运行中，请稍后再试"),
    /**名称重复*/
    ERROR_RESULT_NAME("E03003","定时任务名称重复"),
    /**名称重复*/
    ERROR_RESULT_SUCCESS("E03004","保存定时任务成功"),
    /**名称字数限制*/
    ERROR_RESULT_NAME_SIZE("E03005","任务名称输入超出字数限制"),
    /**描述字数限制*/
    ERROR_RESULT_DESC_SIZE("E03006","任务描述输入超出字数限制"),
    /**启动任务*/
    ERROR_RESULT_START("E03007","任务启动成功"),
    /**禁用任务*/
    ERROR_RESULT_STOP("E03008","任务禁用成功"),
    /**手动执行成功任务*/
    ERROR_RESULT_HAND_SUCCESS("E03009","任务已执行"),
    /**手动执行失败任务*/
    ERROR_RESULT_HAND_FALSE("E03010","执行失败，请稍后再试"),
    /**禁用失败任务*/
    ERROR_RESULT_JOB_STOP("E03011","禁用失败，请稍后再试"),
    /**服务名称重复*/
    ERROR_RESULT_SERVICE_NAME("E03012","服务名称重复"),

    /**系统繁忙*/
    ERROR_SYSTEM_BUSY("E00001","系统繁忙"),
    /**服务调用异常*/
    ERROR_SYSTEM_REQUEST("E00002","服务调用异常"),
    /**请求参数有误*/
    ERROR_REQUEST_ARGUMENT("E00021","请求参数有误"),
    /**未查询到记录*/
    ERROR_NOT_FOUND("E00022","未查询到记录"),
    /**更新数据失败*/
    ERROR_UPDATE("E00023","更新数据失败"),
    /**删除数据失败*/
    ERROR_DELETE("E00024","删除数据失败"),
    /**新增数据失败*/
    ERROR_INSERT("E00025","新增数据失败"),
    /**缓存名为空*/
    ERROR_NO_CACHE_NAME("E00026","缓存名为空"),
    /**缓存key为空*/
    ERROR_NO_CACHE_KEY("E00027","缓存key为空"),

    /**机构管理：查询失败，orgnCode错误*/
    ERROR_AUTHORITY_ORGANIZATION_LIST("E01601","查询失败，orgnCode错误"),
    /**菜单管理：菜单名称已存在*/
    ERROR_AUTHORITY_MENU_NAME_EXIST("E01602","菜单名称已存在"),
    /**菜单管理：菜单URL已存在*/
    ERROR_AUTHORITY_MENU_URL_EXIST("E01603","菜单URL已存在"),
    /**菜单管理：菜单已被使用*/
    ERROR_AUTHORITY_MENU_USED("E01604","菜单已被使用"),
    /**功能管理：功能已被使用*/
    ERROR_AUTHORITY_FEATURES_USED("E01605","功能已被使用"),
    /**功能管理：功能存在子功能*/
    ERROR_AUTHORITY_FEATURES_PARENT("E01614","功能存在子功能"),
    /**菜单管理：功能存在子功能*/
    ERROR_AUTHORITY_MENU_PARENT("E01615","该菜单存在子菜单"),
    /**菜单管理：功能存在子功能*/
    ERROR_AUTHORITY_MENU_FEATURES("E01616","该菜单已有功能权限"),
    /**功能管理：给角色分配功能失败*/
    ERROR_AUTHORITY_ROLE_FEATURES_SAVE_FAIL("E01606","分配失败"),
    /**登录登出：用户名或密码错误*/
    ERROR_AUTHORITY_LOGIN_USER_NAME_PASSWORD("E01607","用户名或密码错误"),
    /**登录登出：该账户未启用*/
    ERROR_AUTHORITY_LOGIN_ACCOUNT_DISABLE("E01608","该账户未启用"),
    /**登录登出：该账户未被分配角色*/
    ERROR_AUTHORITY_LOGIN_ACCOUNT_FORBIDDEN("E01609","该账户未被分配角色"),
    /**登录登出：您不是该行的客户经理，无权登录!*/
    ERROR_AUTHORITY_LOGIN_ACCOUNT_MANAGER_FORBIDDEN("E01610","您不是该行的客户经理，无权登录!"),
    /**功能管理：功能名称已存在*/
    ERROR_AUTHORITY_FEATURES_EXIST("E01611","功能名称已存在"),
    /**菜单管理：分配角色菜单失败*/
    ERROR_AUTHORITY_ROLE_MENU_SAVE_FAIL("E01612","分配角色菜单失败"),
    /**登陆：当前登陆用户机构不可用，进行提示*/
    ERROR_LOGIN_ORGANIZATION_NOT_EXIST("E01613","账号异常，请联系管理员"),
    /**机构管理：机构ID数组不可为空*/
    ERROR_AUTHORITY_NOT_NULL_ORGANISATION_ID("E01614","机构ID数组不可为空"),

    /**系统名称已存在*/
    ERROR_AUTHORITY_EXIST_SYS_NAME("E01021","系统名称已存在"),
    /**存在系统子菜单无法删除系统信息*/
    ERROR_AUTHORITY_EXIST_SUB_MENU("E01022","存在系统子菜单无法删除系统信息"),
    /**用户已存在*/
    ERROR_AUTHORITY_EXIST_USER("E01023","用户已存在"),
    /**用户不存在*/
    ERROR_AUTHORITY_NOT_EXIST_USER("E01024","用户不存在"),
    /**根菜单删除失败*/
    ERROR_AUTHORITY_DELETE_ROOT_MUNU("E01025","根菜单删除失败"),
    /**角色名称已存在*/
    ERROR_AUTHORITY_EXIST_ROLE("E01026","角色名称已存在"),
    /**角色启用失败*/
    RROR_ROLE_ENABLE_FAIL("E01027","角色启用失败"),
    /**角色禁用失败*/
    RROR_ROLE_DISENABLE_FAIL("E01028","角色禁用失败"),
    /**该角色下已存在用户信息*/
    ERROR_AUTHORITY_USER_EXIST_ROLE("E01027","该角色下已存在用户信息"),
    /**角色名称重复*/
    ERROR_AUTHORITY_REPETITION_ROLE("E01028","角色名称重复"),
    /**此设备已经存在*/
    ERROR_AUTHORITY_REPETITION_TERMINAL("E01029","此设备已经存在"),
    /**此机构编码不存在，请输入正确的机构编码*/
    ERROR_AUTHORITY_ORGNCODE_REPETITION_TERMINAL("E01030","此机构编码不存在，请输入正确的机构编码"),
    /**该机构下已存在相同的ip地址*/
    ERROR_AUTHORITY_IP_REPETITION_TERMINAL("E01031","该机构下已存在相同的ip地址"),

    /**Job执行失败*/
    ERROR_JOB_RUN("E03000","Job执行失败"),
    /**Job转换失败*/
    ERROR_JOB_TRANSFORM("E03001","Job转换失败"),

    /**token和权限相关枚举定义*/
    INTERCEPTOR_IS_EXCEPTION("E07005","拦截器出现异常"),
    AUTHORITY_IS_INCORRECT("E07004","无权限"),
    TOKEN_VALUE_INCORRECT("E07003","传入token值与服务端不匹配"),
    TOKEN_STATUS_INVALID("E07002","token失效"),
    TOKEN_PARAMETER_IS_BLANK("E07001","token传入值不存在"),

    /**维护管理-字典管理：字典类别名称已存在*/
    ERROR_MAINTANCE_EXIST_DICT_TYPE_NAME("E05600","字典类别名称已存在"),
    /**维护管理-字典管理：字典类别标识已存在*/
    ERROR_MAINTANCE_EXIST_DICT_TYPE_CODE("E05601","字典类别标识已存在"),
    /**维护管理-字典管理：字典项名称已存在*/
    ERROR_MAINTANCE_EXIST_DICT_NAME("E05600","字典项名称已存在"),
    /**维护管理-字典管理：字典值已存在*/
    ERROR_MAINTANCE_EXIST_DICT_CODE("E05601","字典值已存在"),
    /**维护管理-字典管理：字典类别不存在*/
    ERROR_MAINTANCE_EXIST_DICT_DICT_TYPE_CODE("E05602","字典类别不存在,无法为其添加字典项");

    /**返回码*/
    public String code;
    /**错误信息*/
    public String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
