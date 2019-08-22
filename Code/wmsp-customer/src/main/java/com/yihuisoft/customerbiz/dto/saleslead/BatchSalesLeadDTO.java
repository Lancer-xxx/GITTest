package com.yihuisoft.customerbiz.dto.saleslead;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;
import java.util.Set;

/**
 * 销售线索的批处理 数据传输对象
 * @author dim
 * @date 2019/7/31
 */
public class BatchSalesLeadDTO {

    /**
     * 批量处理时，线索id的集合
     */
    @NotEmpty
    @JsonTypeInfo(use = JsonTypeInfo.Id.NONE,include = JsonTypeInfo.As.WRAPPER_ARRAY)
    Set<Long> salesLeadList;

    /**
     * 理财经理的id
     */
    String customerManagerId;

    /**
     * 理财经理姓名
     */
    String customerManager;

    /**
     * 操作的描述
     */
    String operationDesc;

    public Set<Long> getSalesLeadList() {
        return salesLeadList;
    }

    public void setSalesLeadList(Set<Long> salesLeadList) {
        this.salesLeadList = salesLeadList;
    }

    public String getCustomerManagerId() {
        return customerManagerId;
    }

    public void setCustomerManagerId(String customerManagerId) {
        this.customerManagerId = customerManagerId;
    }

    public String getCustomerManager() {
        return customerManager;
    }

    public void setCustomerManager(String customerManager) {
        this.customerManager = customerManager;
    }

    public String getOperationDesc() {
        return operationDesc;
    }

    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc;
    }
}
