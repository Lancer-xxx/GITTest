package com.yihuisoft.authoritybiz.handler;

import com.alibaba.fastjson.JSON;
import com.yihuisoft.authoritybiz.constant.AppConsts;
import com.yihuisoft.authoritybiz.dto.login.LoginDTO;
import com.yihuisoft.authoritybiz.entity.organization.Organization;
import com.yihuisoft.authoritybiz.entity.role.Role;
import com.yihuisoft.authoritybiz.entity.token.LoginUser;
import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.authoritybiz.service.discache.DistributeCacheService;
import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.service.IRedisCacheService;
import com.yihuisoft.common.util.app.SnowFlakeIdWorker;
import com.yihuisoft.logbiz.message.UserLoginMessage;
import org.apache.commons.collections.MapUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 人员登录日志日志处理
 *
 * @author zhangsh
 * @version V4.0.2
 * @date 2019/8/5 14:16
 */
@Aspect
@Component
@Order(1)
public class UserLoginLogProducer {
    protected Logger logger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_AUTHORITY);
    protected Logger errorLogger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_ERROR);

    @Autowired
    private IRedisCacheService redisCacheService;

    @Pointcut("execution(* com.yihuisoft.authoritybiz.service.login.UserLoginService.userLogin(..))")
    public void userLoginLog() {
    }

    ThreadLocal<Map<String, Object>> local = new ThreadLocal<Map<String, Object>>();

    /**
     * 切入点之前业务操作
     *
     * @param joinPoint 切入点连接点
     *                  return void
     */
    @Before(value = "userLoginLog()")
    public void doBefore(JoinPoint joinPoint) {

        try {
            // 接收到请求，记录请求内容
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();

            logger.info("人员登录日志请求参数" + Arrays.toString(joinPoint.getArgs()));
            LoginDTO loginDTO = (LoginDTO) joinPoint.getArgs()[0];

            long startTime = System.currentTimeMillis();

            Map<String, Object> threadInfo = new HashMap<>();
            threadInfo.put(AppConsts.START_TIME, startTime);
            threadInfo.put(AppConsts.IP, request.getRemoteAddr());
            threadInfo.put(AppConsts.DEVICE_ID, loginDTO.getLogDeviceId());
            threadInfo.put(AppConsts.USER_CODE, loginDTO.getUserCode());
            local.set(threadInfo);
        } catch (Exception e) {
            errorLogger.error(e.getMessage(), e);
        }
    }

    /**
     * 切入点处理业务操作之后
     *
     * @param res 响应结果
     *            return void
     */
    @AfterReturning(value = "userLoginLog()", returning = "res")
    public void doAfterReturning(Object res) {
        UserLoginMessage userLoginMessage = new UserLoginMessage();
        userLoginMessage.setId(SnowFlakeIdWorker.generateId());
        Map<String, Object> threadInfo = local.get();

        try {
            OutDTO outDTO = (OutDTO) res;

            long takeTime = System.currentTimeMillis() - (long) threadInfo.getOrDefault(AppConsts.START_TIME, System.currentTimeMillis());
            logger.info("人员登录日志响应耗时" + takeTime + " ms" + ",结果" + res);
            userLoginMessage.setId(SnowFlakeIdWorker.generateId());

            if (MapUtils.isNotEmpty(threadInfo) && !ObjectUtils.isEmpty(outDTO)) {
                userLoginMessage.setLogDeviceId(threadInfo.get(AppConsts.DEVICE_ID).toString());
                userLoginMessage.setLoginDate(new Date());
                userLoginMessage.setLoginIp(threadInfo.get(AppConsts.IP).toString());
                if (AppConsts.SUCCESS_CODE.equals(outDTO.getErrorCode())) {
                    userLoginMessage.setLoginStatus(AppConsts.SUCCESS_STATUS);
                } else {
                    userLoginMessage.setLoginStatus(AppConsts.FAIL_STATUS);
                }
                userLoginMessage.setReason(outDTO.getErrorMsg());
                userLoginMessage.setWorkNo(threadInfo.get(AppConsts.USER_CODE).toString());
                Map<String, Object> reponseMap = outDTO.getData();
                if (MapUtils.isNotEmpty(reponseMap)) {
                    LoginUser loginUser = (LoginUser) reponseMap.get(OutDTO.RESULT_INFO);
                    if (!ObjectUtils.isEmpty(loginUser)) {
                        userLoginMessage.setUserId(Long.parseLong(loginUser.getUserId()));
                        Organization organization = loginUser.getOrganization();
                        if (!ObjectUtils.isEmpty(organization)) {
                            userLoginMessage.setOrgnCode(organization.getOrgnCode());
                            userLoginMessage.setOrgnName(organization.getOrgnName());
                        }
                        Role role = loginUser.getRole();
                        if (!ObjectUtils.isEmpty(role)) {
                            userLoginMessage.setRoleId(role.getId());
                            userLoginMessage.setRoleName(role.getRoleName());
                        }
                        User user = loginUser.getUser();
                        if (!ObjectUtils.isEmpty(user)) {
                            userLoginMessage.setUserName(user.getUserName());
                            userLoginMessage.setWorkNo(user.getWorkNo());
                        }
                    }

                }
                //distributeCacheService.sendMessage(CommonConstants.TOPIC_SYS_USER_LOGIN, JSON.toJSONString(userLoginMessage));
                Long length=  redisCacheService.leftPush(CommonConstants.QUEUE_SYS_USER_LOGIN, userLoginMessage);
                 logger.info("队列"+CommonConstants.QUEUE_SYS_USER_LOGIN+"大小"+length);
                local.remove();
            }
        } catch (Exception e) {
            errorLogger.error(e.getMessage(), e);
        }

    }

    /**
     * 切入点处理业务出现异常
     *
     * @param throwable 异常信息
     *            return void
     */
    @AfterThrowing(value = "userLoginLog()", throwing = "throwable")
    public void doAfterThrowing(Throwable throwable) {
        UserLoginMessage userLoginMessage = new UserLoginMessage();
        userLoginMessage.setId(SnowFlakeIdWorker.generateId());
        Map<String, Object> threadInfo = local.get();

        try {
            long takeTime = System.currentTimeMillis() - (long) threadInfo.getOrDefault(AppConsts.START_TIME, System.currentTimeMillis());
            logger.info("人员登录日志响应耗时" + takeTime + " ms" + ",异常信息" + throwable.getMessage());
            userLoginMessage.setLogDeviceId(threadInfo.get(AppConsts.DEVICE_ID).toString());
            userLoginMessage.setLoginDate(new Date());
            userLoginMessage.setLoginIp(threadInfo.get(AppConsts.IP).toString());
            userLoginMessage.setReason(throwable.getMessage());
            userLoginMessage.setWorkNo(threadInfo.get(AppConsts.USER_CODE).toString());
            Long length=  redisCacheService.leftPush(CommonConstants.QUEUE_SYS_USER_LOGIN, userLoginMessage);
            logger.info("队列"+CommonConstants.QUEUE_SYS_USER_LOGIN+"大小"+length);

            local.remove();

        } catch (Exception e) {
            errorLogger.error(e.getMessage(), e);
        }
    }
}