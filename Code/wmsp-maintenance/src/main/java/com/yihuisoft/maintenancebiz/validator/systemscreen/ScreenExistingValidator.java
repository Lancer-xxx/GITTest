package com.yihuisoft.maintenancebiz.validator.systemscreen;

import com.yihuisoft.maintenancebiz.constant.systemscreen.SystemScreenErrorEnum;
import com.yihuisoft.maintenancebiz.entity.screen.SystemScreen;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author dim
 * @version V4.0.0
 * @Title:
 * @ProjectName WMSP
 * @Description:
 * @date 2019/7/10
 */
public class ScreenExistingValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(SystemScreen.class);
    }

    /**
     * 系统屏保的唯一性校验
     *
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        if(target == null){
            ValidationUtils.rejectIfEmpty(errors,
                    SystemScreenErrorEnum.SYSTEM_SCREEN_NOT_EXIST_ERROR.getCode(),
                    SystemScreenErrorEnum.SYSTEM_SCREEN_NOT_EXIST_ERROR.getMessage());
        }
    }
}
