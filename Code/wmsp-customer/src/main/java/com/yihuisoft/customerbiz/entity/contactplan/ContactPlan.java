package com.yihuisoft.customerbiz.entity.contactplan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yihuisoft.common.base.SnowFlakeIdGen;
import com.yihuisoft.customerbiz.dto.contactplan.BatchContactPlanDTO;
import com.yihuisoft.customerbiz.dto.contactplan.BatchContactPlanSaveDTO;
import com.yihuisoft.customerbiz.dto.contactplan.ContactDTO;
import com.yihuisoft.customerbiz.dto.contactplan.ContactPlanSaveDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 联络计划的 实体
 * @author dim
 * @date 2019/8/7
 */
@ApiModel("联络计划")
@Table(name = "T_CUST_CONTACT_PLAN")
public class ContactPlan {
    /**
     * id
     */
    @Id
    @KeySql(genId = SnowFlakeIdGen.class)
    private Long id;

    /**
     * 客户类型
     */
    @ApiModelProperty(value = "客户类型",required = true)
    private String customerType;

    /**
     * 联络方式
     */
    @ApiModelProperty(value = "联络方式",required = true)
    private String contactType;

    @ApiModelProperty(value = "计划电访时间",required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planTime;

    @ApiModelProperty(value = "最后电访时间",required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date contactTime;

    @ApiModelProperty(value = "电访目标",required = true)
    private String contactObjective;

    @ApiModelProperty(value = "电访状态",required = false)
    private String planStatus;

    @ApiModelProperty(value = "客户姓名",required = true)
    private String customerName;

    @ApiModelProperty(value = "手机号码",required = true)
    private String phone;

    @ApiModelProperty(value = "客户id/销售线索客户的id",required = true)
    @NotNull(message = "请选择联络用户")
    private Long contactResourceId;

    /**
     * 销售线索的id
     */
    @Transient
    private Long salesLeadId;

    /**
     * 客户的id
     */
    @Transient
    private Long customerId;

    @Length(min = 0,max = 200)
    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    /**
     * 通过 联络计划保存的对象 生成联络对象实例
     * @param contactPlanSaveDTO
     * @return
     */
    public static ContactPlan getContactPlanInstance(ContactPlanSaveDTO contactPlanSaveDTO) {
        ContactPlan contactPlan = new ContactPlan();

        contactPlan.setPlanTime(contactPlanSaveDTO.getPlanTime());
        contactPlan.setContactTime(contactPlanSaveDTO.getContactTime());
        contactPlan.setContactObjective(contactPlanSaveDTO.getContactObjective());
        contactPlan.setCustomerType(contactPlanSaveDTO.getCustomerType());

        return contactPlan;
    }

    /**
     * 通过 批量联络计划保存的对象 生成联络对象需要更新的数据对象
     * @param batchContactPlanSaveDTO
     * @return
     */
    public static ContactPlan getContactPlanInstance(BatchContactPlanSaveDTO batchContactPlanSaveDTO) {
        ContactPlan contactPlan = new ContactPlan();

        contactPlan.setContactType(batchContactPlanSaveDTO.getContactType());
        contactPlan.setCustomerType(batchContactPlanSaveDTO.getCustomerType());
        contactPlan.setContactObjective(batchContactPlanSaveDTO.getContactObjective());
        contactPlan.setContactTime(batchContactPlanSaveDTO.getContactTime());
        contactPlan.setPlanTime(batchContactPlanSaveDTO.getPlanTime());
        contactPlan.setRemark(batchContactPlanSaveDTO.getRemark());

        return contactPlan;
    }

    /**
     * 为客户制定联络计划，通过客户对象 生成实例
     * @param batchContactPlanSaveDTO
     * @return
     */
    public static List<ContactPlan> getContactPlansWithCustomers(BatchContactPlanSaveDTO batchContactPlanSaveDTO) {
        //toDo
        List <ContactPlan> contactPlans = new ArrayList<>();

        return contactPlans;
    }

    /**
     * 通过销售线索 制定联络计划，生成联络计划的对象列表
     * @param batchContactPlanSaveDTO
     * @return
     */
    public static List<ContactPlan> getContactPlansWithSalesLeads(BatchContactPlanSaveDTO batchContactPlanSaveDTO) {

        List<ContactPlan> contactPlans = batchContactPlanSaveDTO.getContactList().stream()
                .map(contactDTO -> {
                    ContactPlan contactPlan = getContactPlanInstance(batchContactPlanSaveDTO);
                    contactPlan.addContactInfo(contactDTO);
                    return contactPlan;
                }).collect(Collectors.toList());

        return contactPlans;
    }

    /**
     * 批量操作联络对象，生成联络对象需要更新的数据对象
     * @param batchContactPlanDTO
     * @return
     */
    public static ContactPlan getUpdateContactPlan(BatchContactPlanDTO batchContactPlanDTO) {
        ContactPlan contactPlan = new ContactPlan();
        contactPlan.setPlanStatus(batchContactPlanDTO.getPlanStatus());
        contactPlan.setPlanTime(batchContactPlanDTO.getPlanTime());
        contactPlan.setContactType(batchContactPlanDTO.getContactType());
        contactPlan.setContactObjective(batchContactPlanDTO.getContactObjective());
        contactPlan.setRemark(batchContactPlanDTO.getRemark());

        return contactPlan;
    }

    /**
     * 为联络对象，添加联系信息
     * @param contactDTO
     * @return
     */
    private ContactPlan addContactInfo(ContactDTO contactDTO) {
        this.setContactResourceId(contactDTO.getId());
        this.setCustomerName(contactDTO.getCustomerName());
        this.setPhone(contactDTO.getPhone());

        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
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

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
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

    public Long getContactResourceId() {
        return contactResourceId;
    }

    public void setContactResourceId(Long contactResourceId) {
        this.contactResourceId = contactResourceId;
    }

    public Long getSalesLeadId() {
        return salesLeadId;
    }

    public void setSalesLeadId(Long salesLeadId) {
        this.salesLeadId = salesLeadId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}