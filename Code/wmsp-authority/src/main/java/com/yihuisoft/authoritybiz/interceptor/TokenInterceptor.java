package com.yihuisoft.authoritybiz.interceptor;

import com.yihuisoft.authoritybiz.constant.AppConsts;
import com.yihuisoft.authoritybiz.constant.RedisConstantsKey;
import com.yihuisoft.authoritybiz.service.token.TokenService;
import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 *
 * @author zhangsh
 * @version V4.0.1
 * @date 2019/7/29 16:35
 **/
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
    protected Logger logger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_AUTHORITY);
    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        //从header中获取token
        String userId = request.getHeader(AppConsts.USER_ID);
        //从header中获取token
        String token = request.getHeader(AppConsts.USER_TOKEN);
        //获取当前请求资源URL
        String requestUrl = request.getRequestURI();
        logger.info(getClass().getName() + "请求用户ID: " + userId + ", user token=" + token + ", 资源URL=" + requestUrl);
        if (!StringUtils.isEmpty(userId)) {
            if (!StringUtils.isEmpty(token)) {
                String redisToken = tokenService.getByToken(String.format(RedisConstantsKey.USER_TOKEN_KEY, userId));
                if (!StringUtils.isEmpty(redisToken)) {
                    if (token.equals(redisToken)) {
                        //匹配到真实的权限，正常放行,这样可以满足没有任何操作的情况下，30分钟过期
                        tokenService.setToken(String.format(RedisConstantsKey.USER_TOKEN_KEY, userId), redisToken);
                        return true;
                    } else {
                        //防止同一账号在存在两次登录同时又退出
                        logger.info("失效userId: " + userId + ", 失效 token=" + token + ", 资源URL=" + requestUrl);
                        throw new ApplicationException(ResultEnum.TOKEN_STATUS_INVALID);
                    }

                } else {
                    //提示token失效
                    logger.info("失效userId: " + userId + ", 失效 token=" + token + ", 资源URL=" + requestUrl);
                    throw new ApplicationException(ResultEnum.TOKEN_STATUS_INVALID);

                }
            } else {
                logger.info("token参数为空userId: " + userId + ", token=" + token + ", 资源URL=" + requestUrl);
                throw new ApplicationException(ResultEnum.TOKEN_PARAMETER_IS_BLANK);
            }
        } else {
            logger.info("用户不存在userId: " + userId + ", token=" + token + ", 资源URL=" + requestUrl);
            throw new ApplicationException(ResultEnum.ERROR_AUTHORITY_NOT_EXIST_USER);
        }

    }
}
