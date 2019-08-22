package com.yihuisoft.authoritybiz.service.discache;

import com.yihuisoft.authoritybiz.entity.menu.RoleMenuDO;
import com.yihuisoft.authoritybiz.entity.token.LoginUser;
import com.yihuisoft.common.exception.ApplicationException;

import java.util.List;
import java.util.Map;

/**
 * 分布式缓存接口
 *
 * @author zhangsh
 * @version V4.0.1
 * @date 2019/7/29 16:35
 **/
public interface DistributeCacheService {

    /**
     * 设置用户信息
     *
     * @param key
     * @param loginUser   用户信息
     * @return void
     */
    void setLoginUserInfo(String key, LoginUser loginUser) throws ApplicationException;

    /**
     * 设置用户信息
     *
     * @param key
     * @param roleMenuDOS
     * @return void
     */

    void setUserAuthorityInterceptorUrl(String key, List<RoleMenuDO> roleMenuDOS) throws ApplicationException;

    /**
     * 删除对应的key
     *
     * @param key
     * @return void
     */
    void delete(String key) throws ApplicationException;

    /**
     * 设置用户token
     *
     * @param key
     * @param token       token
     * @param expireTimes 过期时间
     * @return void
     */
    void setUserToken(String key, String token, long expireTimes) throws ApplicationException;

    /**
     * 获取用户的token
     *
     * @param key
     * @return String
     */
    String getUserToken(String key) throws ApplicationException;

    /**
     * 获取用户的权限map
     *
     * @param key
     * @return Map<String   ,   String>
     */
    Map<String, String> getUserAuthrityUrl(String key) throws ApplicationException;

    /**
     * 获取用户登录信息
     *
     * @param key
     * @return LoginUser
     */
    LoginUser getUserAuthority(String key) throws ApplicationException;

     public void sendMessage(String channel,String s) throws ApplicationException;


}
