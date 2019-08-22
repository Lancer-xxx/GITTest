package com.yihuisoft.authoritybiz.interceptor;

import com.yihuisoft.authoritybiz.constant.AppConsts;
import com.yihuisoft.authoritybiz.constant.RedisConstantsKey;
import com.yihuisoft.authoritybiz.service.discache.DistributeCacheService;
import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 拦截器
 *
 * @author zhangsh
 * @version V4.0.1
 * @date 2019/7/29 16:35
 **/
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    protected Logger logger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_AUTHORITY);
    @Autowired
    private DistributeCacheService distributeCacheService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {

        //从header中获取token
        String userId = request.getHeader(AppConsts.USER_ID);
        //从header中获取token
        String token = request.getHeader(AppConsts.USER_TOKEN);
        //获取当前请求资源URL
        String requestUrl = request.getRequestURI();
        logger.info(getClass().getName() + "请求用户ID: " + userId + ", user token=" + token + ", 资源URL=" + requestUrl);
        //如果header中不存在token，则从参数中获取token

        if (!StringUtils.isEmpty(userId) && !StringUtils.isEmpty(token)) {

            Map<String, String> map = distributeCacheService.getUserAuthrityUrl(String.format(RedisConstantsKey.USER_AUTHORITY_RULE_KEY, userId));
            if (MapUtils.isNotEmpty(map)) {

                if (map.containsKey(requestUrl)) {
                    return true;
                } else {
                    //提示无真实的对应权限
                    logger.info(getClass().getName() + "权限校验: " + userId + ", user token=" + token + ", 资源URL=" + requestUrl);
                    throw new ApplicationException(ResultEnum.AUTHORITY_IS_INCORRECT);
                }

            } else {
                //提示无真实的对应权限
                logger.info(getClass().getName() + "登录或更新校验: " + userId + ", user token=" + token + ", 资源URL=" + requestUrl);
                throw new ApplicationException(ResultEnum.AUTHORITY_IS_INCORRECT);
            }

        } else {
            logger.info(getClass().getName() + "用户不存在userId: " + userId + ", token=" + token + ", 资源URL=" + requestUrl);
            throw new ApplicationException(ResultEnum.ERROR_AUTHORITY_NOT_EXIST_USER);
        }
    }
}
