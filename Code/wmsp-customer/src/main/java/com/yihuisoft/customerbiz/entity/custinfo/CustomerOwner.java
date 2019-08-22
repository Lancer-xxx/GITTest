package com.yihuisoft.customerbiz.entity.custinfo;

import javax.persistence.Table;

/**
 * 客户所有人信息
 * @author dim
 * @date 2019/8/17
 */
@Table(name = "T_CUST_RELATION")
public class CustomerOwner {

    /** 客户id（即记录理财经理id，为扩展使用） */
    private Long custId;

    /** 用户id（即记录理财经理id，为扩展使用） */
    private Long userId;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
