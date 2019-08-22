package com.yihuisoft.common.exception;


import com.yihuisoft.common.dto.IResultEnum;
import com.yihuisoft.common.dto.ResultEnum;

/**
 * 应用程序异常类
 * @author huangxj
 * @version V4.0.0
 * @date 2019/6/14 14:16
 */
public class ApplicationException extends RuntimeException {

    /**序列id号*/
    private static final long serialVersionUID = 1L;
    /**错误码*/
    private String errCode;
    /**错误msg*/
    private String errMsg;

    private IResultEnum resultEnum;

    /**
     * 根据错误码定义异常
     * @param resultEnum
     */
    public ApplicationException(IResultEnum resultEnum) {
        this.errCode = resultEnum.getCode();
        this.errMsg = resultEnum.getMessage();
        this.resultEnum=resultEnum;
    }

    /**
      * 自定义异常
      * @author topz
      * @param errMsg 自定义异常信息
      * @param e 跑出异常
      * @return
      * @date
      **/
    public ApplicationException(String errMsg, Throwable e) {
        super(e);
        this.errMsg = errMsg;
        this.errCode = ResultEnum.ERROR_COMMON.getCode();
    }

    /**
     * 构造函数
     * @param errCode 错误码
     */
    public ApplicationException(String errCode) {
        this.errCode = errCode;
    }

    /**
     *
     * @param e 异常
     * @param errCode 错误码
     */
    public ApplicationException(Throwable e,String errCode) {
        super(e);
        this.errCode = errCode;
    }

    /**
     *
     * @return 错误码
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * 设置错误码
     * @param errCode 错误码
     */
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    /**
     * 获取错误消息
     * @return 错误消息
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * 设置错误消息
     * @param errMsg 错误消息
     */
    public ApplicationException setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    public IResultEnum getResultEnum() {
        return resultEnum;
    }

    public void setResultEnum(IResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }
}
