package com.yihuisoft.authoritybiz.controller.features;

import com.yihuisoft.authoritybiz.dto.features.*;
import com.yihuisoft.authoritybiz.service.features.FeaturesService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.common.vo.PagerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能管理控制层
 * @author laijd
 * @date 2019/06/24
 * @version V4.0.0
 * */
@RestController
@RequestMapping("/wmsp/authority/features")
public class FeaturesController {
    @Autowired
    private FeaturesService featuresService;

    /**
     *新增功能数据接口
     * @param inVO
     * @return OutDTO
     * @throws ApplicationException
     */
    @PostMapping(value = "/save")
    public OutDTO saveFeatures(@RequestBody InVO<FeaturesSaveDTO> inVO) throws ApplicationException {
        return featuresService.saveFeatures(inVO.getData());
    }

    /**
     *修改功能数据接口
     * @param inVO
     * @return OutDTO
     * @throws ApplicationException
     */
    @PostMapping(value = "/update")
    public OutDTO updateFeatures(@RequestBody InVO<FeaturesUpdateDTO> inVO) throws ApplicationException {
        return featuresService.updateFeatures(inVO.getData());
    }

    /**
     *删除功能数据接口
     * @param inVO
     * @return OutDTO
     * @throws ApplicationException
     */
    @PostMapping(value = "/delete")
    public OutDTO deleteFeatures(@RequestBody InVO<FeaturesDTO> inVO) throws ApplicationException {
        return featuresService.deleteFeatures(inVO.getData());
    }

    /**
     *查找功能列表，可条件查询
     * @param pagerVO
     * @return OutDTO
     */
    @PostMapping(value = "/list")
    public OutDTO listFeatures(@RequestBody PagerVO<FeaturesListDTO> pagerVO){
        return featuresService.listFeatures(pagerVO.getData(),pagerVO.getPageMessage());
    }
}
