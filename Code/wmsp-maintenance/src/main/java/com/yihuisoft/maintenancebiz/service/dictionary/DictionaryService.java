package com.yihuisoft.maintenancebiz.service.dictionary;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.maintenancebiz.dto.dictionary.*;

import java.util.Map;

/**
* 字典项业务接口层
* @author laijd
* @date 2019-08-13 15:13
* @version V4.0.2
*/
public interface DictionaryService {

     /**
      *
      * 保存字典项信息
      * @param dictionarySaveDTO
      * @return OutDTO
      */
    OutDTO saveDictionary(DictionarySaveDTO dictionarySaveDTO);

     /**
      * 修改字典项信息：修改页面修改，修改排序，修改状态：启用/禁用
      * @param dictionaryUpdateDTO
      * @return OutDTO
      */
    OutDTO updateDictionary(DictionaryUpdateDTO dictionaryUpdateDTO);

     /**
      * 查询字典项信息列表
      * @param dictionaryListDTO
      * @param pageMessage
      * @return OutDTO
      */
     OutDTO listDictionary(DictionaryListDTO dictionaryListDTO, PageMessage pageMessage);

      /**
       * 前端下拉框调用字典数据接口
       * @param dictionaryListSelectDTO 状态，字典类别标识
       * @return OutDTO
       */
     OutDTO listDictionarySelect(DictionaryListSelectDTO dictionaryListSelectDTO);
      /**
       * 根据字典类别标识查询出该列别下的所有字典项，并封装成map返回，供其模块间调用
       * @param dictTypeCode 字典类别标识
       * @return OutDTO  Map<String,Object> key=dictValue 字典值,value=dictName 字典名称
       */
     Map<String,Object> listDictionaryByDictCodeType(String dictTypeCode);
}
