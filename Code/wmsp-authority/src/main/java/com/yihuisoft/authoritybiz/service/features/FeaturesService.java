package com.yihuisoft.authoritybiz.service.features;

import com.yihuisoft.authoritybiz.dto.features.*;
import com.yihuisoft.authoritybiz.entity.features.Features;
import com.yihuisoft.authoritybiz.entity.features.RoleFeatures;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.vo.PageMessage;

/**
 * 功能管理接口定义
 * @author laijd
 * @version V4.0.0
 * @date 2019/7/3
 */
public interface FeaturesService {
    /**
     * 修改功能信息
     * @param featuresUpdateDTO
     * @return OutDTO
     * @throws ApplicationException
     */
    OutDTO updateFeatures(FeaturesUpdateDTO featuresUpdateDTO) throws ApplicationException;

    /**
     * 删除功能信息
     * @param featuresDTO
     * @return
     * @throws ApplicationException
     */
    OutDTO deleteFeatures(FeaturesDTO featuresDTO) throws ApplicationException;

    /**
     * 新增功能信息
     * @param featuresSaveDTO
     * @return
     * @throws ApplicationException
     */
    OutDTO saveFeatures(FeaturesSaveDTO featuresSaveDTO) throws ApplicationException;

    /**
     *查询功能列表
     * @param featuresListDTO
     * @param pageMessage
     * @return
     */
    OutDTO listFeatures(FeaturesListDTO featuresListDTO, PageMessage pageMessage);
}
