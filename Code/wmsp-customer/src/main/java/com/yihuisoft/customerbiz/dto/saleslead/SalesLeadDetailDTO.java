package com.yihuisoft.customerbiz.dto.saleslead;

import java.io.Serializable;
import java.util.Date;

/**
 * 销售线索的明细 数据传输对象
 * @author dim
 * @version V4.0.0
 * @date 2019/7/24
 */
public class SalesLeadDetailDTO implements Serializable {


    /**
     * id
     */
    private String id;

    /**
     *  姓名
     */
    private String userName;

    /**
     * 证件类型
     */
    private String idType;

    /**
     * 证件号码
     */
    private String idNumber;

    /**
     * 性别
     */
    private String gender;

    /**
     * 民族
     */
    private String nation;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 民族
     */
    private String people;

    /**
     * 居住地址
     */
    private String address;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 居住地址
     */
    private String residenceAddress;

    /**
     * 教育程度
     */
    private String education;

    /**
     * 婚姻状况
     */
    private String marriage;

    /**
     * 子女情况
     */
    private String fertilityStatus;

    /**
     * 职业
     */
    private String profession;

    /**
     * 行业
     */
    private String industry;

    /**
     * 年收入
     */
    private String incomeYearly;

    /**
     * 是否有车
     */
    private String hasCar;

    /**
     * 是否有房
     */
    private String hasHouse;

    /**
     * 客户经理的姓名
     */
    private String customerManager;

    /**
     * 客户经理的工号
     */
    private String customerManagerWorkNo;

    /**
     * 所属机构的名称
     */
    private String ownerOrganizationName;

    /**
     * 所属机构的代码
     */
    private String ownerOrganizationCode;

    /**
     * 创建人id
     */
    private String creatorUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    private String updateUserId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 分配状态
     */
    private String assignStatus;

    /**
     * 销售状态
     */
    private String saleStatus;

    /**
     * 关联客户号
     */
    private String linkedCustomerNo;

    // 所属客户经理id
    private String customerManagerId;
    // 所属机构的id
    private String ownerOrganizationId;

    /**
     * 最后电访时间
     */
    private String lastContactTime;
    /**
     * 最新计划电访时间
     */
    private String planedContactTime;

    public String getLastContactTime() {
        return lastContactTime;
    }

    public void setLastContactTime(String lastContactTime) {
        this.lastContactTime = lastContactTime;
    }

    public String getPlanedContactTime() {
        return planedContactTime;
    }

    public void setPlanedContactTime(String planedContactTime) {
        this.planedContactTime = planedContactTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCustomerManagerId() {
        return customerManagerId;
    }

    public void setCustomerManagerId(String customerManagerId) {
        this.customerManagerId = customerManagerId;
    }

    public String getOwnerOrganizationId() {
        return ownerOrganizationId;
    }

    public void setOwnerOrganizationId(String ownerOrganizationId) {
        this.ownerOrganizationId = ownerOrganizationId;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getFertilityStatus() {
        return fertilityStatus;
    }

    public void setFertilityStatus(String fertilityStatus) {
        this.fertilityStatus = fertilityStatus;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIncomeYearly() {
        return incomeYearly;
    }

    public void setIncomeYearly(String incomeYearly) {
        this.incomeYearly = incomeYearly;
    }

    public String getHasCar() {
        return hasCar;
    }

    public void setHasCar(String hasCar) {
        this.hasCar = hasCar;
    }

    public String getHasHouse() {
        return hasHouse;
    }

    public void setHasHouse(String hasHouse) {
        this.hasHouse = hasHouse;
    }

    public String getCustomerManager() {
        return customerManager;
    }

    public void setCustomerManager(String customerManager) {
        this.customerManager = customerManager;
    }

    public String getCustomerManagerWorkNo() {
        return customerManagerWorkNo;
    }

    public void setCustomerManagerWorkNo(String customerManagerWorkNo) {
        this.customerManagerWorkNo = customerManagerWorkNo;
    }

    public String getOwnerOrganizationName() {
        return ownerOrganizationName;
    }

    public void setOwnerOrganizationName(String ownerOrganizationName) {
        this.ownerOrganizationName = ownerOrganizationName;
    }

    public String getOwnerOrganizationCode() {
        return ownerOrganizationCode;
    }

    public void setOwnerOrganizationCode(String ownerOrganizationCode) {
        this.ownerOrganizationCode = ownerOrganizationCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAssignStatus() {
        return assignStatus;
    }

    public void setAssignStatus(String assignStatus) {
        this.assignStatus = assignStatus;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public String getLinkedCustomerNo() {
        return linkedCustomerNo;
    }

    public void setLinkedCustomerNo(String linkedCustomerNo) {
        this.linkedCustomerNo = linkedCustomerNo;
    }

    public String getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(String creatorUserId) {
        this.creatorUserId = creatorUserId;
    }
}
