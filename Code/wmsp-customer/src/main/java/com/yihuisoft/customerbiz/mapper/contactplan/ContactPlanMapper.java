package com.yihuisoft.customerbiz.mapper.contactplan;

import com.yihuisoft.common.base.CommonMapper;
import com.yihuisoft.customerbiz.dto.contactplan.BatchContactPlanDTO;
import com.yihuisoft.customerbiz.dto.contactplan.ContactPlanAggregationDTO;
import com.yihuisoft.customerbiz.dto.contactplan.ContactPlanListDTO;
import com.yihuisoft.customerbiz.entity.contactplan.ContactPlan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 联络信息的映射对象
 * @author dim
 * @date 2019/8/9
 */
@Repository
public interface ContactPlanMapper extends CommonMapper<ContactPlan> {

    /**
     * 电访信息的查询
     * @param contactPlanListDTO
     * @return
     */
    List<ContactPlan> listByDTO(ContactPlanListDTO contactPlanListDTO);

    /**
     * 查询客户的 电访统计信息
     * @param contactPlan
     * @return
     */
    ContactPlanAggregationDTO getContactInfo(ContactPlan contactPlan);

    /**
     * 批量查询客户的 电访统计信息
     * @param batchContactPlanDTO
     * @return
     */
    List<ContactPlanAggregationDTO> getContactsInfo(BatchContactPlanDTO batchContactPlanDTO);
}
