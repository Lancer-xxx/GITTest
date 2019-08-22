package com.yihuisoft.customerbiz.service.impl;

import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.util.app.SnowFlakeIdWorker;
import com.yihuisoft.customerbiz.constant.contactplan.ContactPlanConstant;
import com.yihuisoft.customerbiz.entity.SalesLead;
import com.yihuisoft.customerbiz.entity.SalesLeadOwnership;
import com.yihuisoft.customerbiz.entity.contactplan.ContactPlan;
import com.yihuisoft.customerbiz.entity.contactplan.ContactPlanOwnership;
import com.yihuisoft.customerbiz.mapper.contactplan.ContactPlanMapper;
import com.yihuisoft.customerbiz.mapper.contactplan.ContactPlanOwnershipMapper;
import com.yihuisoft.customerbiz.mapper.saleslead.SalesLeadOwnershipMapper;
import com.yihuisoft.customerbiz.service.SalesLeadOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 销售线索的所属信息的接口服务
 * @author dim
 * @version V4.0.0
 * @date 2019/7/25
 */
@Service
public class SalesLeadOwnershipServiceImpl implements SalesLeadOwnershipService {

    @Autowired
    SalesLeadOwnershipMapper salesLeadOwnershipMapper;

    @Autowired
    ContactPlanOwnershipMapper contactPlanOwnershipMapper;

    @Autowired
    ContactPlanMapper contactPlanMapper;

    /**
     * 保存销售线索的归属信息
     * @param salesLeadOwnership
     * @return
     */
    @Override
    public OutDTO<SalesLeadOwnership> save(SalesLeadOwnership salesLeadOwnership) {
        int result = salesLeadOwnershipMapper.insert(salesLeadOwnership);

        // 更新 线索对应的所有人信息
        ContactPlanOwnership contactPlanOwnership = new ContactPlanOwnership();
        contactPlanOwnership.setCustomerOwnerId(salesLeadOwnership.getSalesLeadId());
        contactPlanOwnership.setCustomerOwnerId(salesLeadOwnership.getCustomerManagerId());
        contactPlanOwnership.setCustomerType(ContactPlanConstant.TYPE_SALES_LEAD);


        Example contactPlanExample = new Example(ContactPlan.class);
        contactPlanExample.createCriteria()
                .andEqualTo("contactResourceId",salesLeadOwnership.getSalesLeadId())
                .andEqualTo("customerType", ContactPlanConstant.TYPE_SALES_LEAD);

        List<ContactPlan> contactPlans = contactPlanMapper.selectByExample(contactPlanExample);
        List<Long> idSets = contactPlans.stream().map(contactPlan -> {
            return contactPlan.getId();
        }).collect(Collectors.toList());

        if(ObjectUtils.isEmpty(idSets)){
           return  OutDTOFactory.getSucceedOutDTO();
        }

        Example example = new Example(ContactPlanOwnership.class);
        example.createCriteria()
                .andIn("contactPlanId",idSets);
        contactPlanOwnershipMapper.updateByExampleSelective(contactPlanOwnership,example);
        return result > 0 ? OutDTOFactory.getSucceedOutDTO() : OutDTOFactory.getSucceedOutDTO().setStatus(OutDTOFactory.STATUS_FAIL);
    }

    /**
     * 获取销售线索的所有人信息
     * @param salesLead
     * @return
     */
    @Override
    public SalesLeadOwnership getOwnerOfSalesLead(SalesLead salesLead) {
        if(salesLead == null){
            return null;
        }

        Example example = new Example(SalesLeadOwnership.class);
        example.createCriteria()
                .andEqualTo("salesLeadId",salesLead.getId());
        return salesLeadOwnershipMapper.selectOneByExample(example);
    }


    public List<SalesLeadOwnership> getOwnersOfSalesLeads(List<Long> salesLeadIds){
        if(!ObjectUtils.isEmpty(salesLeadIds)){
            return null;
        }

        Example example = new Example(SalesLeadOwnership.class);
        example.createCriteria()
                .andIn("salesLeadId",salesLeadIds);
        return salesLeadOwnershipMapper.selectByExample(example);
    }
    /**
     * 批量分配销售线索
     * @param salesLeadList
     * @param user
     * @return
     */
    @Override
    public OutDTO assignBatchSalesLead(Set<Long> salesLeadList, User user) {
        Example example = new Example(SalesLeadOwnership.class);
        example.createCriteria()
                .andIn("salesLeadId",salesLeadList);
        List<SalesLeadOwnership> salesLeadOwnerships = salesLeadOwnershipMapper.selectByExample(example);

        List<Long> updatedOwnershipIds = salesLeadOwnerships.stream()
                .filter(ownership -> salesLeadList.contains(ownership.getSalesLeadId()))
                .map(ownership -> ownership.getSalesLeadId())
                .collect(Collectors.toList());

        salesLeadOwnershipMapper.updateByExampleSelective(SalesLeadOwnership.getEmptySalesLeadOfOwner(user),example);

        Set<Long> ownershipsToSave = new HashSet<>();
        ownershipsToSave.addAll(salesLeadList);
        ownershipsToSave.removeAll(updatedOwnershipIds);

        ownershipsToSave.forEach(salesLeadId ->{
            SalesLead salesLead = new SalesLead();
            salesLead.setId(salesLeadId);

            this.save(SalesLeadOwnership.initSalesLeadOwnership(salesLead,user));
        });

        return OutDTOFactory.getSucceedOutDTO();
    }

}
