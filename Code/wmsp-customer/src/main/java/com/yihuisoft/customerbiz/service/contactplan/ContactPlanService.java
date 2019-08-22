package com.yihuisoft.customerbiz.service.contactplan;

import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.customerbiz.dto.contactplan.*;
import com.yihuisoft.customerbiz.entity.contactplan.ContactPlan;

import java.util.List;

/**
 * 联络计划的接口服务类
 * @author dim
 * @date 2019/8/9
 */
public interface ContactPlanService {

    /**
     * 对客户制定联络计划
     * @return
     */
    OutDTO saveWithCustomer(ContactPlan contactPlan, User user);

    /**
     * 对销售线索制定 联络计划
     * @return
     */
    OutDTO saveWithSalesLead(ContactPlan contactPlan, User user);

    /**
     * 批量保存 联络计划
     * @return
     */
    OutDTO<ContactPlan> saveBatch(BatchContactPlanSaveDTO batchContactPlanSaveDTO) ;

    /**
     * 批量更新 联络计划
     * @return
     */
    OutDTO<ContactPlan> updateBatch(BatchContactPlanDTO batchContactPlanDTO);

    /**
     * 批量取消
     * @param batchContactPlanDTO
     * @return
     */
    OutDTO<ContactPlan> cancelBatchContactPlan(BatchContactPlanDTO batchContactPlanDTO);

    /**
     * 查询联络计划信息
     * @param pagerVO
     * @return
     */
    OutDTO<ContactPlan> listPagerByDTO(PagerVO<ContactPlanListDTO> pagerVO);

    /**
     * 联络计划的修改
     * @param contactPlan
     * @return
     */
    OutDTO update(ContactPlan contactPlan);

    List<ContactPlanAggregationDTO> getContactInfo(BatchContactPlanDTO batchContactPlanDTO);


    OutDTO updateBatchContactInfo(List<ContactPlanAggregationDTO> contactPlanAggregationDTOList);

    /**
     * 更新 电访的联系信息
     * @param contactPlan
     * @return
     */
    OutDTO updateByContactInfoChange(ContactPlan contactPlan);
}
