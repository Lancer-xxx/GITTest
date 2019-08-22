package com.yihuisoft.logbiz.consumer;

import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.service.IRedisCacheService;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.logbiz.dto.job.JobRunlogInDTO;
import com.yihuisoft.logbiz.entity.log.JobRunlog;
import com.yihuisoft.logbiz.service.JobRunlogService;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName JobConsumer
 * @ProjectName wmsp-log
 * @Author genghongbo
 * @Date 2019/08/17 16:36
 * @Version 4.0.2
 **/
@Transactional
@Component
public class JobConsumer {
    protected Logger logger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_LOG);
    protected Logger errorLogger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_ERROR);
    @Autowired
    private IRedisCacheService redisCacheService;
    @Autowired
    private JobRunlogService jobRunlogService;

    @PostConstruct
    public void run() {
        new Thread(()->{
            while (true){
                Date dates = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String transTime = format.format(dates);
                JobRunlog jobRunlog = (JobRunlog)redisCacheService.rightPop(CommonConstants.QUEUE_SYS_TASK_JOB);
                logger.info("接收到消息" + jobRunlog);
                  if(!ObjectUtils.isEmpty(jobRunlog)){
                      JobRunlogInDTO jobRunlogInDTO=new JobRunlogInDTO();
                      try {
                          CopyUtils.copy(jobRunlog,jobRunlogInDTO);
                          jobRunlogInDTO.setResultStatus(0L);
                          jobRunlogInDTO.setEndTime(transTime);
                          jobRunlogService.insertJobRunLog(jobRunlogInDTO);
                      }catch (Exception e){
                          //消费一异常放回队列
                          jobRunlogInDTO.setResultStatus(1L);
                          jobRunlogInDTO.setMistakeInform(ArrayUtils.toString(e.getStackTrace()));
                          jobRunlogService.insertJobRunLog(jobRunlogInDTO);
                          redisCacheService.leftPush(CommonConstants.QUEUE_SYS_USER_LOGIN,jobRunlog);
                          errorLogger.error(e.getMessage(),e);
                      }
                  }



            }

        }).start();

    }
}
