package com.yihuisoft.maintenancebiz.controller;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.maintenancebiz.dto.ProvinceDictDTO;
import com.yihuisoft.maintenancebiz.service.dictionary.ProvinceDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 省份字典控制层
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/26 23:23
 */
@RestController
@RequestMapping("wmsp/maintenance/province_dict")
public class ProvinceController {

    @Autowired
    ProvinceDictService provinceDictService;

    @PostMapping("/list_all")
    public OutDTO listAll(@Validated @RequestBody InVO<ProvinceDictDTO> inVO) {
        return provinceDictService.listAll(inVO.getData());
    }
}