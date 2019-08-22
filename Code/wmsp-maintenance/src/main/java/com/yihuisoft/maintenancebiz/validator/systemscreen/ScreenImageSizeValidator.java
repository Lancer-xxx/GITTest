package com.yihuisoft.maintenancebiz.validator.systemscreen;

import com.yihuisoft.maintenancebiz.constant.systemscreen.SystemScreenErrorEnum;
import com.yihuisoft.maintenancebiz.constant.systemscreen.SystemScreenField;
import com.yihuisoft.maintenancebiz.service.screen.SystemScreenValidatorService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author dim
 * @version V4.0.0
 * @Title:
 * @ProjectName yihui-maintenance
 * @Description:
 * @date 2019/7/10
 */
@Component
public class ScreenImageSizeValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return MultipartFile.class.isAssignableFrom(clazz);
    }

    /**
     * 屏保上传的图片的约束校验
     * 1. 文件大小
     * 2. 文件后缀格式名称
     *
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        if(SystemScreenValidatorService.isScreenImageValid((MultipartFile) target)){
            errors.rejectValue(SystemScreenField.FIELD_PICTURE, SystemScreenErrorEnum.IMAGE_SIZE_ERROR.getCode(),SystemScreenErrorEnum.IMAGE_SIZE_ERROR.getMessage());
        }
    }
}
