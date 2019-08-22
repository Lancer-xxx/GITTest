package com.yihuisoft.customerbiz.service;

import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.customerbiz.entity.SalesLead;
import com.yihuisoft.customerbiz.entity.SalesLeadOwnership;
import com.yihuisoft.customerbiz.entity.SalesLeadRecord;

import java.util.List;
import java.util.Set;

/**
 * 销售线索的所有服务信息
 * @author dim
 * @date 2019/7/30
 */
public interface SalesLeadOwnershipService {

    /**
     * 保存销售线索的所有信息
     * @param salesLeadOwnership
     * @return
     */
    public OutDTO<SalesLeadOwnership> save(SalesLeadOwnership salesLeadOwnership);

    /**
     * 获取销售线索的所有人信息
     * @param salesLead
     * @return
     */
    public SalesLeadOwnership getOwnerOfSalesLead(SalesLead salesLead);

    /**
     * 批量分配销售线索
     * @param salesLeadList
     * @param user
     * @return
     */
    public OutDTO assignBatchSalesLead(Set<Long> salesLeadList, User user);
}
