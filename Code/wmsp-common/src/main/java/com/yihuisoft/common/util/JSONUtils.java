package com.yihuisoft.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

import java.util.Map;

/**
 * JSON工具类
 * @author tonywu
 * @version v1.0.0
 */
@SuppressWarnings("unchecked")
public final class JSONUtils {

    /**谷歌Gson对象*/
    private static Gson gson;

    /**
     * 构造函数
     */
    private JSONUtils() {
    }

    static {
        GsonBuilder gb = new GsonBuilder();
        gb.setDateFormat("yyyy-MM-dd HH:mm:ss");
        gson = gb.create();
    }

    /**
     * 对象转字符串
     * @param obj java 对象
     * @return 对象转换后的json字符串
     */
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * 从JSon字符串到类
     * @param json json字符串
     * @param clazz java 对象
     * @param <T> 要转换成的java对象类型
     * @return 转换后的java对象
     */
    public static <T> T fromJson(final String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    /**
     * 从JSon字符串到类
     * @param json json字符串
     * @param t
     * @param <T> 要转换成的java对象类型
     * @return 转换后的java对象
     */
    public static <T> T fromJson(final String json, Type t) {
        return gson.fromJson(json, t);
    }

    /**
     * 从字符串到Map
     * @param json json格式字符串
     * @return map
     */
    public static Map<String, Object> fromJson(final String json) {
        return fromJson(json, Map.class);
    }

    /**
     * 从Object到类
     * @param obj 对象
     * @param clazz 字节码对象
     * @param <T> 要转换的类型
     * @return 转换后的对象
     */
    public static <T> T fromObject(Object obj, Class<T> clazz) {
        String json = toJson(obj);
        return gson.fromJson(json, clazz);
    }

}
