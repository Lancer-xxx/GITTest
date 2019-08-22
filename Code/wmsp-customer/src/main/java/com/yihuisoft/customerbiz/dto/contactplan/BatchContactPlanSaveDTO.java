package com.yihuisoft.customerbiz.dto.contactplan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.yihuisoft.customerbiz.constant.contactplan.ContactPlanConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 批量保存联络计划的数据传输对象
 * @author dim
 * @date 2019/8/9
 */
@ApiModel
public class BatchContactPlanSaveDTO implements Serializable {

    /**
     * 联系信息列表
     */
    @ApiModelProperty("被访人的列表")
    private List<ContactDTO> contactList;

    /**
     * 联系方式
     */
    @ApiModelProperty(value = "联络方式",required = true)
    private String contactType;

    /**
     * 计划的电访时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planTime;

    /**
     * 完成的最后电访时间
     */
    @ApiModelProperty(value = "最后电访时间",required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date contactTime;

    /**
     * 电访目标
     */
    @ApiModelProperty(value = "电访目标",required = true)
    private String contactObjective;

    /**
     * 客户类型
     */
    @ApiModelProperty(value = "客户类型",required = true)
    private String customerType;

    /**
     * 电访备注
     */
    @ApiModelProperty(value = "电访备注",required = true)
    @Length(min = 0,max = 200,message = "备注最多输入200个字符")
    private String remark;

    public List<ContactDTO> getContactList() {
        return contactList;
    }

    public void setContactList(List<ContactDTO> contactList) {
        this.contactList = contactList;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public Date getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Date planTime) {
        this.planTime = planTime;
    }

    public Date getContactTime() {
        return contactTime;
    }

    public void setContactTime(Date contactTime) {
        this.contactTime = contactTime;
    }

    public String getContactObjective() {
        return contactObjective;
    }

    public void setContactObjective(String contactObjective) {
        this.contactObjective = contactObjective;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
