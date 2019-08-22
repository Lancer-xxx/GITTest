package com.yihuisoft.logbiz.task;

import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.service.IRedisCacheService;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.logbiz.dto.satff.UserLoginLogInDTO;
import com.yihuisoft.logbiz.message.UserLoginMessage;
import com.yihuisoft.logbiz.service.UserLoginLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

/**
 * UserLoginTask 线程任务
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */
public class UserLoginTask implements Runnable {
    protected Logger logger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_LOG);
    protected Logger errorLogger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_ERROR);

    private String name;
    private IRedisCacheService redisCacheService;
    private UserLoginLogService userLoginLogService;


    public UserLoginTask(String name,IRedisCacheService redisCacheService,UserLoginLogService userLoginLogService) {
        this.name = name;
        this.redisCacheService = redisCacheService;
        this.userLoginLogService =userLoginLogService;
    }

    @Override
    public void run() {


        while (true) {
            Object message = redisCacheService.rightPop(CommonConstants.QUEUE_SYS_USER_LOGIN);
            if (!ObjectUtils.isEmpty(message)) {
                logger.info("线程" + Thread.currentThread().getName() + "接收到消息" + message + "=" + userLoginLogService);
                try {

                    UserLoginMessage userLoginMessage = (UserLoginMessage) message;
                    UserLoginLogInDTO userLoginLogInDTO = new UserLoginLogInDTO();
                    CopyUtils.copy(userLoginMessage, userLoginLogInDTO);
                    userLoginLogService.addLoginRecord(userLoginLogInDTO);
                } catch (Exception e) {
                    //消费一异常放回队列
                    redisCacheService.leftPush(CommonConstants.QUEUE_SYS_USER_LOGIN, message);
                    errorLogger.error(e.getMessage(), e);
                }
            } else {
                logger.info("队列" + CommonConstants.QUEUE_SYS_USER_LOGIN + "为空,等待中----");
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {

                }
            }
        }
    }

    public String getName() {
        return name;
    }

}