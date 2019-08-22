package com.yihuisoft.maintenancebiz.service.dictionary;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.maintenancebiz.dto.ProvinceDictDTO;

/**
 * 省份字典服务层接口
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/26 23:11
 */
public interface ProvinceDictService {

    /**
     * 查询所有省份信息
     * @return
     * @param inVO
     */
    OutDTO listAll(ProvinceDictDTO inVO);
}
