package com.yihuisoft.maintenancebiz.service.dictionary.impl;

import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.util.app.RedisUtil;
import com.yihuisoft.maintenancebiz.constant.DictionaryConstants;
import com.yihuisoft.maintenancebiz.dto.ProvinceDictDTO;
import com.yihuisoft.maintenancebiz.entity.dictionary.ProvinceDict;
import com.yihuisoft.maintenancebiz.mapper.dictionary.ProvinceDictMapper;
import com.yihuisoft.maintenancebiz.service.dictionary.ProvinceDictService;
import com.yihuisoft.maintenancebiz.vo.ProvinceDictVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * 省份字典服务层
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/26 23:10
 */
@Service
public class ProvinceDictServiceImpl implements ProvinceDictService {

    @Autowired
    ProvinceDictMapper provinceDictMapper;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public OutDTO listAll(ProvinceDictDTO provinceDictDTO) {

        // 指定查询条件
        Example example = new Example(ProvinceDict.class);
        example.setOrderByClause(DictionaryConstants.FIELD_DICT_PROVINCE_ID_ORDER);
        example.createCriteria().andEqualTo(DictionaryConstants.FIELD_DICT_PROVINCE_PARENT_ID, provinceDictDTO.getParentId());
        example.createCriteria().andEqualTo(DictionaryConstants.FIELD_DICT_PROVINCE_STATUS, CommonConstants.STATUS_VALIDE);

        List<ProvinceDict> provinceDicts = provinceDictMapper.selectByExample(example);
        List<ProvinceDictVO> list = new ArrayList<>();
        if(provinceDicts != null) {
            for(ProvinceDict province : provinceDicts) {
                ProvinceDictVO provinceDictVO = new ProvinceDictVO();
                CopyUtils.copy(province,provinceDictVO);
                list.add(provinceDictVO);
            }
        }
        return OutDTOFactory.getSucceedOutDTO().putList(list);
    }
}