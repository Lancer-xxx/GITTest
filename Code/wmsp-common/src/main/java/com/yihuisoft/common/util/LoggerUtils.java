package com.yihuisoft.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhaodc
 * @author tianqs
 * @version v1.0.0
 * @since 2018/8/29
 */
public class LoggerUtils {

    private static Logger log = LoggerFactory.getLogger(LoggerUtils.class);

    public static final String LOGGER_RETURN = "logger_return";

    private LoggerUtils() {
    }

    /**
     * 打印error级别的log4j日志
     * @since 2019/5/8
     * @author tianqs
     * @param msg 日志信息
     * @param e   堆栈信息
     */
    public static void error(String msg, Throwable e) {
        log.error(msg, e);
    }

    /**
     * 打印debug级别的log4j日志
     * @since 2019/5/8
     * @author tianqs
     * @param msg 日志信息
     */
    public static void debug(String msg) {
        log.debug(msg);
    }

    /**
     * 打印info级别的log4j日志
     * @since 2019/5/8
     * @author tianqs
     * @param msg 日志信息
     */
    public static void info(String msg) {
        log.info(msg);
    }

    /**
     * 获取客户端ip地址
     *
     * @param request  客户端请求对象
     * @return ip地址
     */
    public static String getCliectIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ip.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ip = str;
                break;
            }
        }
        return ip;
    }

    /**
     * 判断是否为ajax请求<br></>
     * 若返回结果为null则是同步请求，若返回结果为XMLHttpRequest则为异步请求
     * @param request 客户端请求对象
     * @return null 或者 XMLHttpRequest
     */
    public static String getRequestType(HttpServletRequest request) {
        return request.getHeader("X-Requested-With");
    }
}
