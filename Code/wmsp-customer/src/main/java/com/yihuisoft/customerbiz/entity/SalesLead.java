package com.yihuisoft.customerbiz.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yihuisoft.common.base.SnowFlakeIdGen;
import com.yihuisoft.customerbiz.constant.SalesLeadErrorMessage;
import org.hibernate.validator.constraints.Length;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 销售线索实体
 * @author dim
 * @version V4.0.0
 * @date 2019/7/24
 */
@Table(name = "T_CUST_SALES_LEAD")
public class SalesLead implements Serializable {
    @Id
    @Column(name = "ID")
    @KeySql(genId = SnowFlakeIdGen.class)
    private Long id;

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
     * 国籍编号
     */
    private String nationCode;

    /**
     * 国籍
     */
    private String nation;

    /**
     * 生日信息
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;

    /**
     * 民族编号
     */
    private String peopleCode;

    /**
     * 名族名称
     */
    private String people;

    /**
     * 居住地省级编码
     */
    private String addressProvinceCode;

    /**
     * 居住地省名称
     */
    private String addressProvince;

    /**
     * 居住地市级编码
     */
    private String addressCityCode;

    /**
     * 居住地市名称
     */
    private String addressCity;

    /**
     * 居住地区级编码
     */
    private String addressDistrictCode;

    /**
     * 居住地区名称
     */
    private String addressDistrict;

    /**
     * 居住地
     */
    private String address;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 户籍地省级编码
     */
    private String residenceProvinceCode;

    /**
     * 户籍地省名称
     */
    private String residenceProvince;

    /**
     * 户籍地城市编码
     */
    private String residenceCityCode;

    /**
     * 户籍地城市名称
     */
    private String residenceCity;

    /**
     * 户籍地区编码
     */
    private String residenceDistrictCode;

    /**
     * 户籍地区名称
     */
    private String residenceDistrict;

    /**
     * 户籍地址
     */
    private String residenceAddress;

    /**
     * 教育信息
     */
    private String education;

    /**
     * 婚姻状态
     */
    private String marriage;

    /**
     * 生育状态
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
     * 客户经理姓名
     */
    private String customerManager;

    /**
     * 客户经理工号
     */
    private String customerManagerWorkNo;

    /**
     * 所属机构名称
     */
    private String ownerOrganizationName;

    /**
     * 所属机构编码
     */
    private String ownerOrganizationCode;

    /**
     * 创建人id
     */
    private String creatorUserId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private String updateUserId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    @Length(min = 0,max = 200, message = SalesLeadErrorMessage.ERROR_SAVING_TOO_LONG_REMARK)
    private String remark;

    private String assignStatus;

    private String saleStatus;

    private String linkedCustomerNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(String creatorUserId) {
        this.creatorUserId = creatorUserId;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    public String getPeopleCode() {
        return peopleCode;
    }

    public void setPeopleCode(String peopleCode) {
        this.peopleCode = peopleCode;
    }

    public String getAddressProvinceCode() {
        return addressProvinceCode;
    }

    public void setAddressProvinceCode(String addressProvinceCode) {
        this.addressProvinceCode = addressProvinceCode;
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    public String getAddressCityCode() {
        return addressCityCode;
    }

    public void setAddressCityCode(String addressCityCode) {
        this.addressCityCode = addressCityCode;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressDistrictCode() {
        return addressDistrictCode;
    }

    public void setAddressDistrictCode(String addressDistrictCode) {
        this.addressDistrictCode = addressDistrictCode;
    }

    public String getAddressDistrict() {
        return addressDistrict;
    }

    public void setAddressDistrict(String addressDistrict) {
        this.addressDistrict = addressDistrict;
    }

    public String getResidenceProvinceCode() {
        return residenceProvinceCode;
    }

    public void setResidenceProvinceCode(String residenceProvinceCode) {
        this.residenceProvinceCode = residenceProvinceCode;
    }

    public String getResidenceProvince() {
        return residenceProvince;
    }

    public void setResidenceProvince(String residenceProvince) {
        this.residenceProvince = residenceProvince;
    }

    public String getResidenceCityCode() {
        return residenceCityCode;
    }

    public void setResidenceCityCode(String residenceCityCode) {
        this.residenceCityCode = residenceCityCode;
    }

    public String getResidenceCity() {
        return residenceCity;
    }

    public void setResidenceCity(String residenceCity) {
        this.residenceCity = residenceCity;
    }

    public String getResidenceDistrictCode() {
        return residenceDistrictCode;
    }

    public void setResidenceDistrictCode(String residenceDistrictCode) {
        this.residenceDistrictCode = residenceDistrictCode;
    }

    public String getResidenceDistrict() {
        return residenceDistrict;
    }

    public void setResidenceDistrict(String residenceDistrict) {
        this.residenceDistrict = residenceDistrict;
    }
}
