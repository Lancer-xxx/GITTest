package com.yihuisoft.authoritybiz.dto.login;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *人员管理-登出DTO
 * @author laijd
 * @version V4.0.0
 * @date 2019/6/29
 */
public class LogoutDTO implements Serializable {
    /**登出主键 */
    private Long logId;
    @NotNull(message = "用户ID不能为空")
    private String userId;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "LogoutDTO{" +
                "logId=" + logId +
                ", userId='" + userId + '\'' +
                '}';
    }
}
