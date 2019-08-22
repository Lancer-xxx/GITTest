package com.yihuisoft.customerbiz.controller.saleslead;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.customerbiz.entity.SalesLeadRecord;
import com.yihuisoft.customerbiz.service.SalesLeadRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 销售线索记录的 控制器
 * @author dim
 * @date 2019/7/25
 */
@RequestMapping("wmsp/customer/sale_lead/record")
@RestController
public class SalesLeadRecordController {

    @Autowired
    SalesLeadRecordService salesLeadRecordService;

    /**
     * 销售线索记录的查询
     * @param pagerVO
     * @return
     */
    @PostMapping("list")
    public OutDTO list(@RequestBody PagerVO<SalesLeadRecord> pagerVO){
        // 封装返回信息
        return salesLeadRecordService.list(pagerVO);

    }

}
