package com.yihuisoft.maintenancebiz.controller.dictionary;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionaryListDTO;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionaryListSelectDTO;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionarySaveDTO;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionaryUpdateDTO;
import com.yihuisoft.maintenancebiz.service.dictionary.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*字典管理-字典项控制层
* @author laijd
* @date 2019-08-13 14:15
* @version V4.0.2
*/
@RestController
@RequestMapping("/wmsp/maintenance/dict")
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;

     /**
      * 字典项列表取数接口
      * @param pagerVO 字典项列表分页查询条件
      * @return OutDTO
      */
     @PostMapping(value = "/list")
     public OutDTO listDictionary(@RequestBody PagerVO<DictionaryListDTO> pagerVO){
        return dictionaryService.listDictionary(pagerVO.getData(),pagerVO.getPageMessage());
    }
     /**
      * 新增字典项信息
      * @param inVO
      * @return OutDTO
      */
     @PostMapping(value = "/save")
    public  OutDTO saveDictionary(@Validated @RequestBody InVO<DictionarySaveDTO> inVO){
        return dictionaryService.saveDictionary(inVO.getData());
    }
    /**
     * 修改字典项信息：修改页面修改，修改排序，修改状态：启用/禁用
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/update")
    public OutDTO updateDictionary(@Validated @RequestBody InVO<DictionaryUpdateDTO> inVO){
        return dictionaryService.updateDictionary(inVO.getData());
    }

    @PostMapping(value = "/use")
    public OutDTO listDicttionarySelect(@Validated @RequestBody InVO<DictionaryListSelectDTO> inVO){
        return  dictionaryService.listDictionarySelect(inVO.getData());
    }
}
