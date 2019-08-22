package com.yihuisoft.maintenancebiz.mapper.dictionary;

import com.yihuisoft.common.base.CommonMapper;
import com.yihuisoft.maintenancebiz.entity.dictionary.Dictionary;
import com.yihuisoft.maintenancebiz.entity.dictionary.DictionaryListDO;
import com.yihuisoft.maintenancebiz.entity.dictionary.DictionaryListSelectDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* 字典管理-字典项mapper
* @author laijd
* @date 2019-08-12 17:53
* @version V4.0.2
*/
@Mapper
@Repository
public interface DictionaryMapper extends CommonMapper<Dictionary> {
     /**
      * 校验字典项中参数是否存在
      * @param dictionary
      * @return List<Long> 字典类别ID列表
      */
    List<Long> checkParamExists(Dictionary dictionary);

     /**
      * 字典管理-字典项信息列别展示
      * @param dictionary
      * @return List<DictionaryListDO> 字典项详情信息+字典类别名称
      */
    List<DictionaryListDO> listDictionary(Dictionary dictionary);

    /**
     * 前端下拉框调用字典数据接口
     * @param dictionary
     * @return List<DictionaryListSelectDO>
     */
    List<DictionaryListSelectDO> listDictionarySelect(Dictionary dictionary);
}
