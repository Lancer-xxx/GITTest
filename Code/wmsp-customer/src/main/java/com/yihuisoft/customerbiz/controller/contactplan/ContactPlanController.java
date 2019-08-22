package com.yihuisoft.customerbiz.controller.contactplan;

import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.authoritybiz.service.user.UserService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.customerbiz.dto.contactplan.BatchContactPlanDTO;
import com.yihuisoft.customerbiz.dto.contactplan.BatchContactPlanSaveDTO;
import com.yihuisoft.customerbiz.dto.contactplan.ContactPlanListDTO;
import com.yihuisoft.customerbiz.entity.contactplan.ContactPlan;
import com.yihuisoft.customerbiz.service.contactplan.ContactPlanService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 联络计划接口的控制器
 * @author dim
 * @date 2019/8/8
 */
@ApiOperation("联络计划")
@RequestMapping("wmsp/customer/contact_plan")
@RestController
public class ContactPlanController {

    @Autowired
    ContactPlanService contactPlanService;

    @Autowired
    UserService userService;

    /**
     * 通过销售线索 制定联络计划
     * @param inVO
     * @return
     */
    @ApiOperation("创建联络计划")
    @PostMapping("save_with_sales_lead")
    public OutDTO saveWithSalesLead(@RequestBody @ApiParam(value = "联络计划", required = true)  InVO<ContactPlan> inVO){
        User user =  userService.getContextUser();
        return contactPlanService.saveWithSalesLead(inVO.getData(),user);
    }


    /**
     * 通过客户信息 创建联络计划
     * @param inVO
     * @return
     */
    @ApiOperation("创建联络计划")
    @PostMapping("save_with_customer")
    public OutDTO saveWithCustomer(@RequestBody InVO<ContactPlan> inVO){
        User user =  userService.getContextUser();
        return contactPlanService.saveWithCustomer(inVO.getData(),user);
    }

    /**
     * 批量 制定联络计划
     * @param inVO
     * @return
     */
    @ApiOperation("批量制定联络计划")
    @PostMapping("saveBatch")
    public OutDTO saveBatch(@RequestBody @ApiParam InVO<BatchContactPlanSaveDTO> inVO){
        User user =  userService.getContextUser();
        return contactPlanService.saveBatch(inVO.getData());
    }


    /**
     * 分页查询 联络计划的列表
     * @param pagerVO
     * @return
     */
    @ApiOperation("分页查询")
    @PostMapping("list")
    public OutDTO list(@RequestBody PagerVO<ContactPlanListDTO> pagerVO){
        User user =  userService.getContextUser();
        pagerVO.getData().setUserId(user.getId());
        return contactPlanService.listPagerByDTO(pagerVO);
    }

    /**
     * 批量更新 联络计划
     * @param inVO
     * @return
     */
    @ApiOperation("批量更新")
    @PostMapping("updateBatch")
    public OutDTO updateBatch(@RequestBody InVO<BatchContactPlanDTO> inVO){
        return contactPlanService.updateBatch(inVO.getData());
    }

    /**
     * 批量
     * @param inVO
     * @return
     */
    @ApiOperation("批量取消")
    @PostMapping("cancelBatch")
    public OutDTO cancelBatch(@RequestBody InVO<BatchContactPlanDTO> inVO){
        return contactPlanService.cancelBatchContactPlan(inVO.getData());
    }

    @ApiOperation("修改")
    @PostMapping("update")
    public OutDTO  update(@RequestBody @ApiParam InVO<ContactPlan> inVO){
       return contactPlanService.update(inVO.getData());
    }
}
