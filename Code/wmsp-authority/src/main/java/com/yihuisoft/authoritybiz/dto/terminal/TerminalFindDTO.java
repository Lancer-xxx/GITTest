package com.yihuisoft.authoritybiz.dto.terminal;

import javax.validation.constraints.NotNull;

/**
  * 设备信息查询实体
  * @author topz
  * @date 2019/7/16 16:35
  * @version V4.0.0
  **/
public class TerminalFindDTO {

    /**终端设备id*/
    @NotNull(message = "设备标识不能为空！")
    private String logDeviceId;

    public String getLogDeviceId() {
        return logDeviceId;
    }

    public void setLogDeviceId(String logDeviceId) {
        this.logDeviceId = logDeviceId;
    }
}
