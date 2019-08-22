package com.yihuisoft.authoritybiz.service.discache.impl;

import com.yihuisoft.authoritybiz.entity.menu.RoleMenuDO;
import com.yihuisoft.authoritybiz.entity.token.LoginUser;
import com.yihuisoft.authoritybiz.service.discache.DistributeCacheService;
import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.PropertiesUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 分布式缓存实现
 *
 * @author zhangsh
 * @version V4.0.1
 * @date 2019/7/29 16:35
 **/
@Service
public class DistributeCacheServiceImpl implements DistributeCacheService {
    protected Logger logger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_ERROR);
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置用户信息
     *
     * @param key
     * @param loginUser   用户信息
     * @return void
     */
    @Override
    public void setLoginUserInfo(String key, LoginUser loginUser) throws ApplicationException {
        try {
            key= PropertiesUtils.getProperty(CommonConstants.PROPERTY_REDIS_SUFFIX)+key;
            redisTemplate.opsForValue().set(key, loginUser);
        } catch (Exception e) {
            logger.error(getClass().getName() + e.getMessage(), e);
        }

    }

    /**
     * 设置用户信息
     *
     * @param key
     * @param roleMenuDOS
     * @return void
     */
    @Override
    public void setUserAuthorityInterceptorUrl(String key, List<RoleMenuDO> roleMenuDOS) throws ApplicationException {
        Map<String, String> map = new HashMap<String, String>();
        key= PropertiesUtils.getProperty(CommonConstants.PROPERTY_REDIS_SUFFIX)+key;
        try {
            roleMenuDOS.forEach(menu -> {
                if (!StringUtils.isEmpty(menu.getMenuUrl())) {
                    map.put(menu.getMenuUrl(), menu.getMenuUrl());

                }
            });
            redisTemplate.opsForValue().set(key, map);
        } catch (Exception e) {
            logger.error(getClass().getName() + e.getMessage(), e);
        }

    }

    /**
     * 删除对应的key
     *
     * @param key
     * @return void
     */
    @Override
    public void delete(String key) throws ApplicationException {
        key= PropertiesUtils.getProperty(CommonConstants.PROPERTY_REDIS_SUFFIX)+key;
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
            logger.error(getClass().getName() + e.getMessage(), e);
        }
    }


    /**
     * 设置用户token
     *
     * @param key
     * @param token       token
     * @param expireTimes 过期时间
     * @return void
     */
    @Override
    public void setUserToken(String key, String token, long expireTimes) throws ApplicationException {
       String  expire=PropertiesUtils.getProperty(CommonConstants.SPRING_REDIS_EXPIRE);
       if(!StringUtils.isEmpty(expire)){
           expireTimes=Long.parseLong(expire);
       }
        key= PropertiesUtils.getProperty(CommonConstants.PROPERTY_REDIS_SUFFIX)+key;
        try {
            redisTemplate.opsForValue().set(key, token, expireTimes, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error(getClass().getName() + e.getMessage(), e);
        }
    }

    /**
     * 获取用户的token
     *
     * @param key
     * @return String
     */
    @Override
    public String getUserToken(String key) throws ApplicationException {
        String rt = null;
        key= PropertiesUtils.getProperty(CommonConstants.PROPERTY_REDIS_SUFFIX)+key;
        try {
            rt = (String) redisTemplate.opsForValue().get(key);

        } catch (Exception e) {
            logger.error(getClass().getName() + e.getMessage(), e);
        }
        return rt;
    }

    /**
     * 获取用户的权限map
     *
     * @param key
     * @return Map<String       ,       String>
     */
    @Override
    public Map<String, String> getUserAuthrityUrl(String key) throws ApplicationException {
        key= PropertiesUtils.getProperty(CommonConstants.PROPERTY_REDIS_SUFFIX)+key;
        Map<String, String> map = new HashMap<String, String>();
        try {
            map = (Map<String, String>) redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            logger.error(getClass().getName() + e.getMessage(), e);
        }
        return map;
    }

    /**
     * 获取用户登录信息
     *
     * @param key
     * @return LoginUser
     */
    @Override
    public LoginUser getUserAuthority(String key) throws ApplicationException {
        LoginUser loginUser = null;
        key= PropertiesUtils.getProperty(CommonConstants.PROPERTY_REDIS_SUFFIX)+key;
        try {
            loginUser = (LoginUser) redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            logger.error(getClass().getName() + e.getMessage(), e);
        }
        return loginUser;
    }

    /**
     * 生产消息
     *
     * @param key
     * @param s
     * @return LoginUser
     */
    @Override
    public void sendMessage(String key,String s) throws ApplicationException {
         try {
             key= PropertiesUtils.getProperty(CommonConstants.PROPERTY_REDIS_SUFFIX)+key;
             redisTemplate.convertAndSend(key,s);
         }catch (Exception e){
             logger.error(getClass().getName() + e.getMessage(), e);
         }
    }




}
