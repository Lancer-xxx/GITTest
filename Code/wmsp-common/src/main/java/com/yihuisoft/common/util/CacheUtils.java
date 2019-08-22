package com.yihuisoft.common.util;

import com.yihuisoft.common.dto.InDTO;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.commons.lang3.StringUtils;

import java.io.NotSerializableException;
import java.io.Serializable;

/**
 * 缓存工具类
 * @author tonywu
 * @version v1.0.0
 */
public class CacheUtils implements Serializable {
    /**序列id*/
	private static final long serialVersionUID = 1L;
    /**缓存管理*/
	private static CacheManager cacheManager = CacheManager.create();

    /**
     * 获取缓存管理器
     * @return 缓存管理器
     */
    public static String getManager() {
        return cacheManager.toString();
    }

    /**
     * 获取缓存
     * @param cacheName 缓存名称
     * @param key key值
     * @return value值
     */
    public static Object get(String cacheName, String key) throws NotSerializableException {
        Element element = getCache(cacheName).get(key);
        return element==null?null:element.getObjectValue();
    }

    /**
     * 写入缓存
     * @param cacheName 缓存名称
     * @param key key值
     * @param value value值
     */
    public static void put(String cacheName, String key, Object value) throws Exception {
        //先删除
        remove(cacheName,key);

        Element element = null;
        try {
            element = new Element(key, value);
//            if (value instanceof java.util.List) {
//            	//element = new Element(key, (Serializable)value);
//                element = new Element(key, value);
//            }else if(value instanceof java.util.Map){
//            	//element = new Element(key, (Serializable)value);
//                element = new Element(key, value);
//            }else{
//            	element = new Element(key, value);
//            }
            getCache(cacheName).put(element);
		} catch (Exception e) {
			//e.printStackTrace();
            System.out.println(e);
		}
    }

    /**
     * 从缓存中移除
     * @param cacheName 缓存名称
     * @param key key值
     */
    public static void remove(String cacheName, String key) {
        getCache(cacheName).remove(key);
    }
    
    /**
     * 获得一个Cache，没有则创建一个。
     * @param cacheName 缓存名字
     * @return 缓存对象
     */
    public static Cache getCache(String cacheName){
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null){
            cacheManager.addCache(cacheName);
            cache = cacheManager.getCache(cacheName);
            cache.getCacheConfiguration().setEternal(true);
        }
        return cache;
    }
    
    /**
     * 清除所有缓存
     */
    public static void removeAll() {

        String[] cacheNames = cacheManager.getCacheNames();
        for(String cacheName:cacheNames){
            //清除该缓存下的所有值
            getCache(cacheName).removeAll();
        }
	}

    /**
     * 将inDTO中纪录的缓存存入outDTO中
     * @param inDTO 存储缓存名称以及该缓存中的key
     * @return 存有key以及value值的outDTO
     * @throws Exception 异常
     */
    public static OutDTO get(InDTO inDTO) throws Exception {

        OutDTO result = new OutDTO();
        //取得缓存名称
        String cacheName = (String) inDTO.get("cacheName");
        if (StringUtils.isEmpty(cacheName)) {
            throw new ApplicationException(ResultEnum.ERROR_NO_CACHE_NAME);
        }
        //取得缓存cachekey
        String cachekey = (String) inDTO.get("cachekey");
        if (StringUtils.isEmpty(cachekey)) {
            throw new ApplicationException(ResultEnum.ERROR_NO_CACHE_KEY);
        }
        result.put(cachekey, CacheUtils.get(cacheName, cachekey));
        return result;
    }


}
