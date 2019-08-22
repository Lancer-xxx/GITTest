package com.yihuisoft.customerbiz.entity.custinfo;

import com.yihuisoft.customerbiz.dto.contactplan.ContactPlanAggregationDTO;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户基础信息实体
 * @author topz
 * @date 2019/8/8 13:28
 * @version V4.0.0
 **/
@Table(name = "T_CUST_INFO")
public class CustBaseInfomation {
    @Id
    /** 客户id */
    private Long id;
    /** 客户cis */
    private String cis;
    /** 客户姓名 */
    private String custName;
    /** 客户性别 */
    private String gender;
    /** 年龄 */
    private String age;
    /** 电话号码 */
    private String mobileNumber;
    /** 证件类型  */
    private String cardType;
    /** 证件号码  */
    private String certificateNumber;
    /** 职业  */
    private String position;
    /** 客户等级  */
    private String customerLevel;
    /** CRM管户经理工号(user_workno)  */
    private String crmMangagerCode;
    /** CRM管户网点机构号(user_orgnCode) */
    private String crmOrgnCode;
    /** 最后电访时间  */
    private Date lastCallTime;
    /** 最新计划电访时间  */
    private Date latestCallTime;
    /** 是否有未执行电访计划（1-是 0-否） */
    private String ifPlanNonExecution;
    /** 生日  */
    private String birthday;
    /** 资产总额  */
    private BigDecimal assetSize;
    /** 负债总额  */
    private BigDecimal debtSize;
    /** 年日均资产  */
    private BigDecimal annualAverageAssets;
    /** 个人年收入  */
    private BigDecimal annualIncome;
    /** 首次开户网点机构号  */
    private String openingInstitutionCode;
    /** 首次开户网点名称  */
    private String openingInstitutionName;
    /** 开户卡号  */
    private String openingCard;
    /** 最早开户时间  */
    private Date openingTime;
    /** 更新用户id  */
    private Long updateUserid;
    /** 更新时间  */
    private Date updateTime;
    /** 数据同步更新时间  */
    private Date crmUpdateTime;
    /** 创建人id  */
    private Long createUserid;
    /** 创建时间  */
    private Date createTime;

    /**
     * 通过联络信息 获取客户信息
     * @param contactPlanAggregationDTO
     * @return
     */
    public static CustBaseInfomation getCustBaseInfo4ContactPlan(ContactPlanAggregationDTO contactPlanAggregationDTO){
        CustBaseInfomation custBaseInfomation = new CustBaseInfomation();
        custBaseInfomation.setId(contactPlanAggregationDTO.getContactResourceId());
        custBaseInfomation.setLastCallTime(contactPlanAggregationDTO.getContactTime());
        custBaseInfomation.setLatestCallTime(contactPlanAggregationDTO.getPlanTime());
        custBaseInfomation.setIfPlanNonExecution(contactPlanAggregationDTO.getIfPlanNonExecution());

        return custBaseInfomation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCis() {
        return cis;
    }

    public void setCis(String cis) {
        this.cis = cis;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel;
    }

    public String getCrmMangagerCode() {
        return crmMangagerCode;
    }

    public void setCrmMangagerCode(String crmMangagerCode) {
        this.crmMangagerCode = crmMangagerCode;
    }

    public String getCrmOrgnCode() {
        return crmOrgnCode;
    }

    public void setCrmOrgnCode(String crmOrgnCode) {
        this.crmOrgnCode = crmOrgnCode;
    }

    public Date getLastCallTime() {
        return lastCallTime;
    }

    public void setLastCallTime(Date lastCallTime) {
        this.lastCallTime = lastCallTime;
    }

    public Date getLatestCallTime() {
        return latestCallTime;
    }

    public void setLatestCallTime(Date latestCallTime) {
        this.latestCallTime = latestCallTime;
    }

    public String getIfPlanNonExecution() {
        return ifPlanNonExecution;
    }

    public void setIfPlanNonExecution(String ifPlanNonExecution) {
        this.ifPlanNonExecution = ifPlanNonExecution;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getAssetSize() {
        return assetSize;
    }

    public void setAssetSize(BigDecimal assetSize) {
        this.assetSize = assetSize;
    }

    public BigDecimal getDebtSize() {
        return debtSize;
    }

    public void setDebtSize(BigDecimal debtSize) {
        this.debtSize = debtSize;
    }

    public BigDecimal getAnnualAverageAssets() {
        return annualAverageAssets;
    }

    public void setAnnualAverageAssets(BigDecimal annualAverageAssets) {
        this.annualAverageAssets = annualAverageAssets;
    }

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(BigDecimal annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getOpeningInstitutionCode() {
        return openingInstitutionCode;
    }

    public void setOpeningInstitutionCode(String openingInstitutionCode) {
        this.openingInstitutionCode = openingInstitutionCode;
    }

    public String getOpeningInstitutionName() {
        return openingInstitutionName;
    }

    public void setOpeningInstitutionName(String openingInstitutionName) {
        this.openingInstitutionName = openingInstitutionName;
    }

    public String getOpeningCard() {
        return openingCard;
    }

    public void setOpeningCard(String openingCard) {
        this.openingCard = openingCard;
    }

    public Date getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Date openingTime) {
        this.openingTime = openingTime;
    }

    public Long getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Long updateUserid) {
        this.updateUserid = updateUserid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCrmUpdateTime() {
        return crmUpdateTime;
    }

    public void setCrmUpdateTime(Date crmUpdateTime) {
        this.crmUpdateTime = crmUpdateTime;
    }

    public Long getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Long createUserid) {
        this.createUserid = createUserid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}