package com.yihuisoft.maintenancebiz.mapper.dictionary;

import com.yihuisoft.common.base.CommonMapper;
import com.yihuisoft.maintenancebiz.entity.dictionary.DictionaryType;
import com.yihuisoft.maintenancebiz.entity.dictionary.DictionaryTypeListDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* 字典管理-字典类别mapper
* @author laijd
* @date 2019-08-12 17:53
* @version V4.0.2
*/
@Mapper
@Repository
public interface DictionaryTypeMapper extends CommonMapper<DictionaryType> {
     /**
      * 校验字典类别中参数是否存在
      * @param dictionaryType
      * @return List<Long> 字典类别ID列表
      */
    List<Long> checkParamExists(DictionaryType dictionaryType);

     /**
      * 字典管理-字典类别信息列别展示
      * @param dictionaryType
      * @return List<DictionaryTypeListDO> 字典类别信息+字典项个数，归属菜单列表
      */
    List<DictionaryTypeListDO> listDictionaryTypes(DictionaryType dictionaryType);
}
