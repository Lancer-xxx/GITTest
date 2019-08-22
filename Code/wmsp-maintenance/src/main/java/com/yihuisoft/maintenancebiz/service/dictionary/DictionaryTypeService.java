package com.yihuisoft.maintenancebiz.service.dictionary;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionaryTypeListDTO;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionaryTypeSaveDTO;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionaryTypeUpdateDTO;

/**
* 字典类别业务接口层
* @author laijd
* @date 2019-08-12 17:13
* @version V4.0.2
*/
public interface DictionaryTypeService {

     /**
      *
      * 保存字典类别信息
      * @param dictionaryTypeSaveDTO
      * @return OutDTO
      */
    OutDTO saveDictionaryType(DictionaryTypeSaveDTO dictionaryTypeSaveDTO);

     /**
      * 修改字典类别信息
      * @param dictionaryTypeUpdateDTO
      * @return OutDTO
      */
    OutDTO updateDictionaryType(DictionaryTypeUpdateDTO dictionaryTypeUpdateDTO);

     /**
      * 查询字典类别信息列表
      * @param dictionaryTypeListDTO
      * @param pageMessage
      * @return OutDTO
      */
     OutDTO listDictionaryType(DictionaryTypeListDTO dictionaryTypeListDTO, PageMessage pageMessage);

    /**
     * 校验字典类别名称/标识是否重复
     * @param  dictTypeName 字典类别名称
     * @param dictTypeCode 字典类别标识
     * @param id 字典类别ID
     * @param isUpdate true:修改字典类别信息，false:新增字典类别信息
     * @return boolean true:重复，false：不重复
     */
     boolean checkParamExists(String dictTypeName,String dictTypeCode,Long id,boolean isUpdate);
}
