package com.yihuisoft.logbiz.threadpool;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * ThreadConfig 线程池配置
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */
@Configuration
@PropertySource(value = "classpath:config/context.properties", ignoreResourceNotFound = false)
public class ThreadConfig {
    @Value("${spring.thread.corePoolSize}")
    private int corePoolSize;
    @Value("${spring.thread.maxPoolSize}")
    private int maxPoolSize;
    @Value("${spring.thread.keepAliveSeconds}")
    private int keepAliveSeconds;

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {

        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        taskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        taskExecutor.setRejectedExecutionHandler(new RejectHander());
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        return taskExecutor;
    }
}
