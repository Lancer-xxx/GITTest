package com.yihuisoft.common.service.impl;
import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.service.IRedisCacheService;
import com.yihuisoft.common.util.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

/**
 * redis常用的基本操作
 *后续慢慢增加
 * @author zhangsh
 * @version V4.0.2
 * @date 2019/8/12 16:35
 **/
@Service
public class RedisCacheServiceImpl implements IRedisCacheService {
    protected Logger logger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_ERROR);
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置KEY对应值
     * @param key
     * @param o 数据对象
     * @throws ApplicationException
     * return void
     */
    @Override
    public void set(String key, Object o) throws ApplicationException {
        try {
            key = PropertiesUtils.getProperty(CommonConstants.PROPERTY_REDIS_SUFFIX) + key;
            redisTemplate.opsForValue().set(key, o);
        } catch (Exception e) {
            logger.error(getClass().getName() + e.getMessage(), e);
        }
    }
    /**
     * 删除KEY对应值
     * @param key
     * @throws ApplicationException
     * return void
     */
    @Override
    public void delete(String key) throws ApplicationException {
        key = PropertiesUtils.getProperty(CommonConstants.PROPERTY_REDIS_SUFFIX) + key;
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
            logger.error(getClass().getName() + e.getMessage(), e);
        }
    }
    /**
     * 设置KEY对应值
     * @param key
     * @param o 数据对象
     * @param timeUnit  时间单位
     * @param expireTimes 过期时间
     * @throws ApplicationException
     * return void
     */
    @Override
    public void set(String key, Object o, TimeUnit timeUnit, long expireTimes) throws ApplicationException {
        key = PropertiesUtils.getProperty(CommonConstants.PROPERTY_REDIS_SUFFIX) + key;
        try {
            redisTemplate.opsForValue().set(key, o, expireTimes, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error(getClass().getName() + e.getMessage(), e);
        }
    }
    /**
     * 获取KEY对应值
     * @param key
     * @throws ApplicationException
     * return String
     */
    @Override
    public String getKey(String key) throws ApplicationException {
        key = PropertiesUtils.getProperty(CommonConstants.PROPERTY_REDIS_SUFFIX) + key;
      String str=null;
        try {
            str = (String)redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            logger.error(getClass().getName() + e.getMessage(), e);
        }
        return str;
    }
    /**
     * 获取KEY对应值
     * @param key
     * @throws ApplicationException
     * return Object
     */
    @Override
    public Object getObject(String key) throws ApplicationException {
        key = PropertiesUtils.getProperty(CommonConstants.PROPERTY_REDIS_SUFFIX) + key;
        Object o=null;
        try {
            o = (String)redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            logger.error(getClass().getName() + e.getMessage(), e);
        }
        return o;
    }
    /**
     * 生产发布消息
     * @param topicKey  topic
     * @param s  通道内容
     * @throws ApplicationException
     * return void
     */
    @Override
    public void pulish(String topicKey, String s) throws ApplicationException {
        try {
            topicKey = PropertiesUtils.getProperty(CommonConstants.PROPERTY_REDIS_SUFFIX) + topicKey;
            redisTemplate.convertAndSend(topicKey, s);
        } catch (Exception e) {
            logger.error(getClass().getName() + e.getMessage(), e);
        }
    }
    /**
     * 生产发布消息
     * 队列形式
     * @param key
     * @param content 消息体
     * @return Long  返回当前队列的大小
     */
    @Override
    public Long leftPush(String key, Object content) throws ApplicationException {
        Long length=0L;
        try {
            key = PropertiesUtils.getProperty(CommonConstants.PROPERTY_REDIS_SUFFIX) + key;
            length=redisTemplate.opsForList().leftPush(key, content);
        } catch (Exception e) {
            logger.error(getClass().getName() + e.getMessage(), e);
        }
        return length;
    }

    @Override
    public Object rightPop(String key) throws ApplicationException {
        Object o=null;
        try {
            key= PropertiesUtils.getProperty(CommonConstants.PROPERTY_REDIS_SUFFIX) + key;
            o=redisTemplate.opsForList().rightPop(key, 5L, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error(getClass().getName() + e.getMessage(), e);
        }
        return o;
    }
}
