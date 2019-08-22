package com.yihuisoft.maintenancebiz.mapper.dictionary;

import com.yihuisoft.common.base.CommonMapper;
import com.yihuisoft.maintenancebiz.entity.dictionary.ProvinceDict;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 省份Mapper
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/26 22:59
 */
@Mapper
@Repository
public interface ProvinceDictMapper extends CommonMapper<ProvinceDict> {
}