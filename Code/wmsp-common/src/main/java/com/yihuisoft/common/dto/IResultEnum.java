package com.yihuisoft.common.dto;

/**
 * 返回码接口
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/30 19:16
 */
public interface IResultEnum {
    /**
     * 返回码
     * @return
     */
    String getCode();

    /**
     * 获取错误信息
     * @return
     */
    String getMessage();
}
