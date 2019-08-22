package com.yihuisoft.risktipbiz.mapper;

import com.yihuisoft.common.base.CommonMapper;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.risktipbiz.entity.RiskTip;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiskTipMapper extends CommonMapper<RiskTip> {
    /**
     * @Description: 列表查询
     * @author: heyaning
     * @date: 2019/8/21 9:18
     */
    List<RiskTip> list(RiskTip data);
}
