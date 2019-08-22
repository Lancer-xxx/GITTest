package com.yihuisoft.logbiz.consumer;

import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.service.IRedisCacheService;
import com.yihuisoft.logbiz.service.UserLoginLogService;
import com.yihuisoft.logbiz.task.UserLoginTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * MessageConsumer
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/8/15 9:55
 */
@Component
public class MessageConsumer {
    protected Logger logger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_LOG);

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;
    @Autowired
    private IRedisCacheService redisCacheService;
    @Autowired
    private UserLoginLogService userLoginLogService;
    @PostConstruct
    public void run() {
        for (int i = 1; i <= taskExecutor.getMaxPoolSize(); i++) {
            UserLoginTask task = new UserLoginTask(String.valueOf(i),redisCacheService,userLoginLogService);
            taskExecutor.execute(task);
        }

    }


}

