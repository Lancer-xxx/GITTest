package com.yihuisoft.common.service;

import com.yihuisoft.common.exception.ApplicationException;

import java.util.concurrent.TimeUnit;

/**
 * redis常用基本接口
 *
 * @author zhangsh
 * @version V4.0.2
 * @date 2019/8/13 16:35
 **/
public interface IRedisCacheService {

    /**
     * 设置key
     *
     * @param key
     * @return void
     */
    void set(String key, Object o) throws ApplicationException;


    /**
     * 删除对应的key
     *
     * @param key
     * @return void
     */
    void delete(String key) throws ApplicationException;

    /**
     * 设置key
     *
     * @param key
     * @param timeUnit 时间单位
     * @param expireTimes 过期时间
     * @return void
     */
    void set(String key, Object o, TimeUnit timeUnit, long expireTimes) throws ApplicationException;
    /**
     * 获取key 对应的value
     *
     * @param key
     * @return String
     */
    String getKey(String key) throws ApplicationException;
    /**
     * 获取key 对应的value
     *
     * @param key
     * @return Object
     */
    Object getObject(String key) throws ApplicationException;

    /**
     * 生产发布消息
     *
     * @param topicKey
     * @param s 消息体
     * @return void
     */

    void pulish(String topicKey, String s) throws ApplicationException;
    /**
     * 生产发布消息
     * 队列形式
     * @param key
     * @param content 消息体
     * @return Long
     */
    Long leftPush(String key, Object content) throws ApplicationException;

    /**
     * 消息消费
     * 队列形式
     * @param key
     * @return Object
     */
    Object rightPop(String key) throws ApplicationException;


}
