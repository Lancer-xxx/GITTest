package com.yihuisoft.customerbiz.controller.custinfo;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.customerbiz.dto.custinfo.CustInfomationListDTO;
import com.yihuisoft.customerbiz.service.custinfo.CustInfomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
  * 客户信息模块控制层
  * @author topz
  * @date 2019/8/8 15:39
  * @version V4.0.0
  **/
@RestController
@RequestMapping(value = "wmsp/customer/custinfo")
public class CustInfomationController {

    @Autowired
    private CustInfomationService custInfoService;

    /**
      * 客户信息列表查询
      * @author topz
      * @param pagerVO 分页参数
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 15:46 2019/8/8
      **/
    @PostMapping(value = "list")
    public OutDTO list(@Validated @RequestBody PagerVO<CustInfomationListDTO> pagerVO){
        return custInfoService.list(pagerVO.getData(),pagerVO.getPageMessage());
    }
}
