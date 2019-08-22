package com.yihuisoft.logbiz.dto.satff;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 定义前端传输公共字段
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */
public class UserLoginLogModifyInDTO implements Serializable {
    /**
     * 日志ID
     **/
    @NotNull(message = "logId不能为空")
    private String logId;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    @Override
    public String toString() {
        return "UserLoginLogModifyInDTO{" +
                "logId='" + logId + '\'' +
                '}';
    }
}
