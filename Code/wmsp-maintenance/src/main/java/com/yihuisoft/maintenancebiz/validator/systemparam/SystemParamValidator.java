package com.yihuisoft.maintenancebiz.validator.systemparam;//.systemparam;

import com.yihuisoft.maintenancebiz.constant.systemparam.SystemParamError;
import com.yihuisoft.maintenancebiz.constant.systemparam.SystemParamField;
import com.yihuisoft.maintenancebiz.entity.param.SystemParam;
import com.yihuisoft.maintenancebiz.service.param.SystemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import java.util.List;

/**
 * @author dim
 * @version V4.0.0
 * @Title:
 * @ProjectName WMSP
 * @Description:
 * @date 2019/6/26
 */
@Component
public class SystemParamValidator implements Validator {

    @Autowired
    SystemParamService service;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(SystemParam.class);
    }

    /**
     * 系统参数名称的 唯一性校验
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        SystemParam systemParamBean = new SystemParam();
        systemParamBean.setParamName(((SystemParam) target).getParamName());

        List<SystemParam> systemParamList = service.listAll(systemParamBean).getListData();

        if (systemParamList != null && !systemParamList.isEmpty()){
            errors.rejectValue(SystemParamField.FIELD_PARAM_NAME,
                    SystemParamError.SYSTEM_PAEAM_ALREADY_EXIST.getCode(),
                    SystemParamError.SYSTEM_PAEAM_ALREADY_EXIST.getMessage());
        }
    }

    @Bean
    MethodValidationPostProcessor getMethodValidationPostProcessor(){
        return new MethodValidationPostProcessor();
    }

}
