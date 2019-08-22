package com.yihuisoft.logbiz.threadpool;

import com.yihuisoft.common.constant.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * RejectHander 拒绝策略
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/8/15 9:55
 */
public class RejectHander  implements RejectedExecutionHandler {
    protected Logger errorLogger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_ERROR);
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        // 可做日志记录等
        errorLogger.error( r.toString() + " rejected");
    }
}
