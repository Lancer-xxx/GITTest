package com.yihuisoft.risktipbiz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.risktipbiz.entity.RiskTip;
import com.yihuisoft.risktipbiz.mapper.RiskTipMapper;
import com.yihuisoft.risktipbiz.service.RiskTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: heyaning
 * @date: 2019/8/20 10:09
 * @version: 4.0.3
 **/
@Service
public class RiskTipServiceImpl implements RiskTipService {
    @Autowired
    private RiskTipMapper riskTipMapper;
    /**
     * 分页查询风险话术列表
     * @param pagerVO
     * @return
     */
    @Override
    public OutDTO<RiskTip> listRiskTip(PagerVO<RiskTip> pagerVO) {
        //分页查询
        PageMessage pageMessage=PageMessage.check(pagerVO.getPageMessage());
        PageHelper.startPage(pageMessage.getPageNo(),pageMessage.getPageSize());
        List<RiskTip> list = riskTipMapper.list(pagerVO.getData());
        //对结果进行封装
        PageInfo<RiskTip> pageInfo = new PageInfo<>(list);
        return OutDTOFactory.getSucceedOutDTO().
                putList(list).setSumCount(pageInfo.getTotal());
    }
}
