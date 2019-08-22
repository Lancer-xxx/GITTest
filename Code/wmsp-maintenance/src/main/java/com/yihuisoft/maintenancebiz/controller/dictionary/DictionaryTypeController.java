package com.yihuisoft.maintenancebiz.controller.dictionary;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionaryTypeListDTO;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionaryTypeSaveDTO;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionaryTypeUpdateDTO;
import com.yihuisoft.maintenancebiz.service.dictionary.DictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
*字典管理-字典类别控制层
* @author laijd
* @date 2019-08-12 17:02
* @version V4.0.2
*/
@RestController
@RequestMapping("/wmsp/maintenance/dict_type/")
public class DictionaryTypeController {

    @Autowired
    DictionaryTypeService dictionaryTypeService;

     /**
      * 保存字典类别信息
      * @param inVO
      * @return OutDTO
      */
    @PostMapping(value = "/save")
    public OutDTO saveDictionaryType(@Validated @RequestBody InVO<DictionaryTypeSaveDTO> inVO){
        return dictionaryTypeService.saveDictionaryType(inVO.getData());
    }
     /**
      * 修改字典类别信息
      * @param inVO
      * @return OutDTO
      */
    @PostMapping(value = "/update")
    public OutDTO updateDictionaryType(@Validated @RequestBody InVO<DictionaryTypeUpdateDTO> inVO){
        return dictionaryTypeService.updateDictionaryType(inVO.getData());
    }

     /**
      * 字典类别列表取数接口
      * @param pagerVO 分页查询字典类别信息
      * @return OutDTO
      */
    @PostMapping(value = "/list")
    public OutDTO listDictionaryType(@RequestBody PagerVO<DictionaryTypeListDTO> pagerVO){
        return dictionaryTypeService.listDictionaryType(pagerVO.getData(),pagerVO.getPageMessage());
    }
}
