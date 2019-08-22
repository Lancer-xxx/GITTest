package com.yihuisoft.customerbiz.controller.saleslead;

import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.authoritybiz.service.user.UserService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.customerbiz.dto.saleslead.BatchSalesLeadDTO;
import com.yihuisoft.customerbiz.dto.saleslead.SalesLeadDetailDTO;
import com.yihuisoft.customerbiz.dto.saleslead.SalesLeadListDTO;
import com.yihuisoft.customerbiz.entity.SalesLead;
import com.yihuisoft.customerbiz.service.SalesLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 销售线索接口的控制器
 * @author dim
 * @version V4.0.0
 * @date 2019/7/25
 */
@RequestMapping("/wmsp/customer/sale_lead")
@RestController
public class SalesLeadController {

    @Autowired
    SalesLeadService salesLeadService;

    @Autowired
    UserService userService;


    /**
     * 分页查询线索功能接口
     *      根据数据权限规则过滤
     * @param pagerVO
     * @return
     */
    @PostMapping("/list")
    public OutDTO<SalesLeadDetailDTO> list(@RequestBody PagerVO<SalesLeadListDTO> pagerVO){
        // 封装返回信息
        return salesLeadService.list(pagerVO);

    }



    /**
     * 线索新增功能接口（管理员）
     * 管理员创建线索
     * @param inVO
     * @return
     */
    @PostMapping("save")
    public OutDTO<SalesLead> save(@RequestBody InVO<SalesLead> inVO){
        User user = userService.getContextUser();
        return salesLeadService.save(inVO.getData(),user);
    }

    /**
     * 理财经理创建线索功能接口
     * @param inVO
     * @return
     */
    @PostMapping("save_and_self_assign")
    public OutDTO<SalesLead> saveAndSelfAssign(@RequestBody InVO<SalesLead> inVO){
        User user = userService.getContextUser();
        return salesLeadService.saveAndSelfAssign(inVO.getData(),user);
    }

    /**
     * 线索分配功能接口
     * @param inVO
     * @return
     */
    @PostMapping("assign")
    public OutDTO<SalesLead> assign(@RequestBody InVO<SalesLead> inVO){
        return salesLeadService.assign(inVO.getData());
    }

    /**
     * 批量分配线索功能接口
     * @param inVO
     * @return
     */
    @PostMapping("assignBatch")
    public OutDTO<SalesLead> assignBatch(@RequestBody InVO<BatchSalesLeadDTO> inVO){
        User user = (User)userService.getUser(Long.parseLong(inVO.getData().getCustomerManagerId())).getInfoData();
        User assigner = userService.getContextUser();
        return salesLeadService.assignBatch(inVO.getData(),user,assigner);
    }

    /**
     * 线索信息更新接口
     * @param inVO
     * @return
     */
    @PostMapping("update")
    public OutDTO<SalesLead> update(@RequestBody InVO<SalesLead> inVO){
        User user = userService.getContextUser();
        return salesLeadService.update(inVO.getData(),user);
    }

    /**
     * 线索信息关联客户功能接口
     * @param inVO
     * @return
     */
    @PostMapping("update_customer")
    public OutDTO<SalesLead> updateCustomer(@RequestBody InVO<SalesLead> inVO){
        return salesLeadService.updateCustomerManager(inVO.getData());
    }

    /**
     * 删除线索功能接口
     * @param inVO
     * @return
     */
    @PostMapping("delete")
    public OutDTO<SalesLead> delete(@RequestBody InVO<SalesLead> inVO){
        User user = userService.getContextUser();
        return salesLeadService.delete(inVO.getData(),user);
    }

    /**
     * 查询单个线索功能接口
     * @param inVO
     * @return
     */
    @PostMapping("get")
    public OutDTO<SalesLead> get(@RequestBody InVO<SalesLead> inVO){
        return salesLeadService.get(inVO.getData());
    }
}
