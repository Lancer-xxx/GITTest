package com.yihuisoft.maintenancebiz.validator.systemscreen;

import com.yihuisoft.maintenancebiz.constant.systemscreen.SystemScreenErrorEnum;
import com.yihuisoft.maintenancebiz.constant.systemscreen.SystemScreenField;
import com.yihuisoft.maintenancebiz.entity.screen.SystemScreen;
import com.yihuisoft.maintenancebiz.service.screen.SystemScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * @author dim
 * @version V4.0.0
 * @Title:
 * @ProjectName WMSP
 * @Description:
 * @date 2019/7/10
 */
@Component
public class ScreenImageAliasNameValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(SystemScreen.class);
    }

    @Autowired
    SystemScreenService service;

    /**
     * 屏保图片别名的唯一性校验
     *
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        SystemScreen systemScreenBean = new SystemScreen();
        systemScreenBean.setFileAliasName(((SystemScreen) target).getFileAliasName());
        systemScreenBean.setId(((SystemScreen) target).getId());

        List<SystemScreen> systemScreenList= service.listAll(systemScreenBean).getListData();

        if(systemScreenList != null && !systemScreenList.isEmpty()) {
            errors.rejectValue(SystemScreenField.FIELD_FILE_ALIAS_NAME
                    , SystemScreenErrorEnum.IMAGE_FILE_ALIAS_NAME_EXIST_ERROR.getCode()
                    , SystemScreenErrorEnum.IMAGE_FILE_ALIAS_NAME_EXIST_ERROR.getMessage());

        }
    }


}
