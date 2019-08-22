package com.yihuisoft.common.annotation;

import java.lang.annotation.*;

/**
 * Controller层日志拦截器
 * @author zhaodc
 * @version v1.0.0
 * @since 2018/8/29
 */
@Retention(RetentionPolicy.RUNTIME)//元注解，定义注解被保留策略，一般有三种策略
                                    //1、RetentionPolicy.SOURCE 注解只保留在源文件中，在编译成class文件的时候被遗弃
                                    //2、RetentionPolicy.CLASS 注解被保留在class中，但是在jvm加载的时候北欧抛弃，这个是默认的声明周期
                                    //3、RetentionPolicy.RUNTIME 注解在jvm加载的时候仍被保留
@Target({ElementType.METHOD}) //定义了注解声明在哪些元素之前
@Documented
public @interface ControllerLog {
    //定义成员
    String descrption() default "" ;//描述
    String actionType() default "" ;//操作的类型，1、添加 2、删除 3、修改 4、查询
    String businessType() default "" ;
}
