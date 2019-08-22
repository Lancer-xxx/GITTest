package com.yihuisoft.maintenancebiz.validator.systemscreen;

import com.yihuisoft.authoritybiz.service.organization.OrganizationService;
import com.yihuisoft.maintenancebiz.constant.systemscreen.SystemScreenErrorEnum;
import com.yihuisoft.maintenancebiz.entity.screen.SystemScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author dim
 * @version V4.0.0
 * @Title:
 * @ProjectName yihui-maintenance
 * @Description:
 * @date 2019/7/10
 */
@Component
public class ScreenOrganizationValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(SystemScreen.class);
    }

    @Autowired
    OrganizationService orgnizationService;

    /**
     * 屏保的组织机构信息的校验
     *
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        String orgnCode =((SystemScreen)target).getOrgnCode();
        if(orgnCode == null || orgnizationService.getOrganizationInfo(orgnCode) == null){
            ValidationUtils.rejectIfEmpty(errors,
                    SystemScreenErrorEnum.ORG_NOT_EXIST_ERROR.getCode(),
                    SystemScreenErrorEnum.ORG_NOT_EXIST_ERROR.getMessage());
        }
    }
}
