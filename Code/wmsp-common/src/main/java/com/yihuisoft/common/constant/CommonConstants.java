package com.yihuisoft.common.constant;

/**
 * 公共常量
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/27 20:44
 */
public class CommonConstants {

    /**数据库状态:*/
    /**有效*/
    public final static String STATUS_VALIDE= "1";
    /**无效*/
    public final static String STATUS_NOT_VALIDE = "0";
    /**删除*/
    public final static String STATUS_DELETE = "2";

    /**数据权限类型:*/
    /**本人机构相关*/
    public final static String DATA_TYPE_ORGN_USER= "1";
    /*系统管理员*/
    public final static Long ADMINISTRATOR = 1008L;

    /**系统log区分 ADD BY ZHANG SHI HUI*/
    public final static String SYS_LOG_APP_AUTHORITY = "app_authority";
    public final static String SYS_LOG_APP_COMMON = "app_common";
    public final static String SYS_LOG_APP_CUSTOMER = "app_customer";
    public final static String SYS_LOG_APP_LOG = "app_log";
    public final static String SYS_LOG_APP_MAINTENANCE = "app_maintenance";
    public final static String SYS_LOG_APP_ERROR = "app_error";
    public final static String SYS_LOG_APP_JOB = "app_job";


    /**定时任务产生的日志 ADD BY ZHANG SHI HUI*/
    public final static String QUEUE_SYS_TASK_JOB = "queue_sys_job_job";

    /**系统人员登录日志队列 ADD BY ZHANG SHI HUI*/
    public final static String QUEUE_SYS_USER_LOGIN = "queue_sys_user_login";

    /**redis前缀**/
    public final static String PROPERTY_REDIS_SUFFIX = "spring.redis.suffix";
    /**权限过滤**/
    public final static String PROPERTY_INTERCEPTOR_EXCLUDE = "spring.interceptor.exclude";
    /**登录过滤**/
    public final static String PROPERTY_INTERCEPTOR_LOGIN = "spring.interceptor.login";
    /**redis过期时间设置**/
    public final static String SPRING_REDIS_EXPIRE = "spring.redis.expire";

    // 统一认证过滤配置
    public final static String PROPERTY_INTERCEPTOR_AUTHORITY = "spring.interceptor.authority";
    // 维护管理过滤配置
    public final static String PROPERTY_INTERCEPTOR_MAINTENANCE = "spring.interceptor.maintenance";
    // 维护管理过滤配置
    public final static String PROPERTY_INTERCEPTOR_CUSTOMER = "spring.interceptor.customer";

}