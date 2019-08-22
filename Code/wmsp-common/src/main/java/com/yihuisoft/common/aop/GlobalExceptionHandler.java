package com.yihuisoft.common.aop;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.app.OutDTOFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统一异常处理
 *
 * @author huangxj
 * @version V4.0.0
 * @date 2019/6/14 14:16
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 处理数据绑定异常
     *
     * @param validException 数据校验异常
     * @return 统一返回对象
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    @ResponseBody
    public OutDTO paramCheckExceptionHandler(Exception validException) {
        validException.printStackTrace();
        Errors errors = null;
        if (validException instanceof MethodArgumentNotValidException) {
            errors = ((MethodArgumentNotValidException) validException).getBindingResult();
        } else if (validException instanceof BindException) {
            errors = ((BindException) validException).getBindingResult();
        }
        return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_REQUEST_ARGUMENT).putInfo(getErrors(errors));

    }
    /**
     * 统一业务异常处理
     *
     * @author zhangsh
     * @version V4.0.0
     * @date 2019/7/30 16:46
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ApplicationException.class})
    @ResponseBody
    public OutDTO applicationExceptionHandler(Exception e) {
        e.printStackTrace();
        if (e instanceof ApplicationException) {
            return OutDTOFactory.getFailOutDTO(((ApplicationException) e).getResultEnum());
        }
        return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON);
    }

    /**
     * 模糊异常处理
     *
     * @param exception exception
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public OutDTO exceptionHandler(Exception exception) {
        return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_SYSTEM_REQUEST).putInfo(exception.toString());

    }

    /**
     * 将错误信息封装成map
     *
     * @param errors
     * @return
     */
    private Map<String, Object> getErrors(Errors errors) {
        Map<String, Object> map = new HashMap<>(16);
        List<FieldError> list = errors.getFieldErrors();
        for (FieldError error : list) {
            map.put(error.getField(), error.getDefaultMessage());
        }
        return map;
    }
}
