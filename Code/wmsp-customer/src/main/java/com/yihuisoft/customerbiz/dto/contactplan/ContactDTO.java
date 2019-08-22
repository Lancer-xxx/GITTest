package com.yihuisoft.customerbiz.dto.contactplan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 电访人员信息
 * @author dim
 * @date 2019/8/12
 */
@ApiModel("电访人员")
public class ContactDTO {

    /**
     * 被访人的id
     */
    @ApiModelProperty("被访人的id")
    private Long id;

    /**
     * 客户姓名
     */
    @ApiModelProperty("客户姓名")
    private String customerName;

    /**
     * 客户手机号
     */
    @ApiModelProperty("手机号码")
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
