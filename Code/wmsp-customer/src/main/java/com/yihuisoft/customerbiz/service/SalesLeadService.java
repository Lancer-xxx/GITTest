package com.yihuisoft.customerbiz.service;

import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.customerbiz.dto.saleslead.BatchSalesLeadDTO;
import com.yihuisoft.customerbiz.dto.saleslead.SalesLeadDetailDTO;
import com.yihuisoft.customerbiz.dto.saleslead.SalesLeadListDTO;
import com.yihuisoft.customerbiz.entity.SalesLead;

import javax.validation.Valid;
import java.util.List;

/**
 * 销售线索服务
 * @author dim
 * @version V4.0.0
 * @date 2019/7/25
 */
public interface SalesLeadService{

    /**
     * 销售线索的保存
     * @param salesLead
     * @return
     */
    public OutDTO<SalesLead> save(SalesLead salesLead);

    /**
     * 销售线索的保存
     * @param salesLead
     * @param user
     * @return
     */
    public OutDTO<SalesLead> save(SalesLead salesLead, User user);

    /**
     * 销售线索的保存并且自分配
     * @param salesLead
     * @return
     */
    public OutDTO<SalesLead> saveAndSelfAssign(SalesLead salesLead);

    /**
     * 销售线索的保存并且自分配
     * @param salesLead
     * @param user
     * @return
     */
    public OutDTO<SalesLead> saveAndSelfAssign(SalesLead salesLead, User user);

    /**
     * 销售线索的分页查询
     * @param pagerVO
     * @return
     */
    public OutDTO<SalesLeadDetailDTO> list(PagerVO<SalesLeadListDTO> pagerVO);

    /**
     * 更新客户经理
     * @param salesLead
     * @return
     */
    public OutDTO<SalesLead> updateCustomerManager(SalesLead salesLead);

    /**
     * 分配线索
     * @param salesLead
     * @return
     */
    public OutDTO<SalesLead> assign(SalesLead salesLead);

    /**
     * 修改线索
     * @param salesLead
     * @return
     */
    public OutDTO<SalesLead> update(SalesLead salesLead);

    /**
     * 删除线索
     * @param salesLead
     * @return
     */
    public OutDTO<SalesLead> delete(SalesLead salesLead);

    /**
     * 销售线索
     * @param salesLead
     * @param user
     * @return
     */
    public OutDTO<SalesLead> delete(SalesLead salesLead, User user);

    /**
     * 查询线索
     * @param salesLead
     * @return
     */
    public OutDTO<SalesLead> get(SalesLead salesLead);

    /**
     * 获取线索的明细
     * @param salesLeadDetailDTO
     * @return
     */
    public OutDTO<SalesLeadDetailDTO> getDetail(SalesLeadDetailDTO salesLeadDetailDTO);

    /**
     * 更新线索信息
     * @param salesLead
     * @param user
     * @return
     */
    public OutDTO<SalesLead> update(SalesLead salesLead, User user);

    /**
     * 批量分配销售线索
     * @param batchSalesLeadDTO
     * @param user
     * @param assigner
     * @return
     */
    public OutDTO<SalesLead> assignBatch(BatchSalesLeadDTO batchSalesLeadDTO,User user,User assigner);
}
