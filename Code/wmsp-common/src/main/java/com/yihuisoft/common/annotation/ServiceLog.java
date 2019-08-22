package com.yihuisoft.common.annotation;

import java.lang.annotation.*;

/**
 * Service层日志拦截器
 * @author zhaodc
 * @version v1.0.0
 * @since 2018/8/29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ServiceLog {
    //定义成员
    String decription() default "" ;
    String businessType() default "" ;//1:系统操作 2：交易日志 3：定时任务
}
