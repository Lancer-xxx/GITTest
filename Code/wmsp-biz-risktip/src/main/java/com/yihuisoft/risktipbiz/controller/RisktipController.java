package com.yihuisoft.risktipbiz.controller;

import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.authoritybiz.service.user.UserService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.risktipbiz.entity.RiskTip;
import com.yihuisoft.risktipbiz.service.RiskTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wmsp/risktip/risk_tip")
public class RisktipController {
    @Autowired
    RiskTipService riskTipService;
    @Autowired
    UserService userService;
    /**
     * @Description: 风险话术列表查询
     * @author: heyaning
     * @date:   2019/8/20
     * @return:
     */
    @PostMapping("list")
    public OutDTO<RiskTip> list(@RequestBody PagerVO<RiskTip> pagerVO){
        return riskTipService.listRiskTip(pagerVO);
    }

    /**
     * @Description: 新增风险话术
     * @author: heyaning
     * @date:   2019/8/20
     */
    @PostMapping("save_risk_tip")
    public OutDTO saveRiskTip(@RequestBody InVO<RiskTip> inVO){
        return OutDTOFactory.getSucceedOutDTO();
    }

    /**
     * @Description: 修改风险话术
     * @author: heyaning
     * @date: 2019/8/20 10:38
     */
    @PostMapping("update_risk_tip")
    public OutDTO updateRiskTip(@RequestBody InVO<RiskTip> inVO){
        return null;
    }

    /**
     * @Description: 删除风险话术
     * @author: heyaning
     * @date: 2019/8/20 11:21
     */
    @PostMapping("delete_risk_tip")
    public OutDTO deleteRiskTip(@RequestBody InVO<RiskTip> inVO){
        return null;
    }
}


