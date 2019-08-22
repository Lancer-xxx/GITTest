package com.yihuisoft.risktipbiz.service;

import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.risktipbiz.entity.RiskTip;

/**
 * @description: 风险话术服务
 * @author: heyaning
 * @date: 2019/8/20 10:08
 * @version: 4.0.3
 **/
public interface RiskTipService {
    /**
     * 分页查询风险话术列表
     * @param pagerVO
     * @return
     */
    OutDTO<RiskTip> listRiskTip(PagerVO<RiskTip> pagerVO);
}
