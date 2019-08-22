package com.yihuisoft.maintenancebiz.service.screen;

import com.yihuisoft.maintenancebiz.constant.ScreenConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author dim
 * @version V4.0.0
 * @Title: SystemScreenValidatorService
 * @ProjectName WMSP
 * @Description: 用于 屏保模块的系统校验
 * @date 2019/7/9
 */
public class SystemScreenValidatorService {

    public static final Logger LOG = LoggerFactory.getLogger(SystemScreenValidatorService.class);
    /**
     * 图片的规则校验
     * @param imageFile
     * @return
     */
    public static boolean isScreenImageValid(MultipartFile imageFile){

        if ( imageFile != null) {
            Integer picSize = Integer.parseInt(String.valueOf(imageFile.getSize()));

            // 文件过大 验证不通过
            return (picSize > ScreenConstant.RULE_ALLOWED_MAX_SIZE);
        }else{
            return false;
        }
    }


    private SystemScreenValidatorService(){

    }
}
