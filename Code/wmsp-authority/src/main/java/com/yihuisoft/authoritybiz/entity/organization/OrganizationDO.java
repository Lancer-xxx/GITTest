package com.yihuisoft.authoritybiz.entity.organization;

import java.io.Serializable;

/**
* 根据机构ID数组，查询出对应机构信息DO
* @author laijd
* @date 2019-08-15 10:20
* @version V4.0.2
*/
public class OrganizationDO implements Serializable {
    /**机构ID*/
    private Long id;
    /**机构编码*/
    private String orgnCode;
    /**上级机构编号*/
    private String parentOrgnCode;
    /**机构名称*/
    private String orgnName;
    /**机构简称*/
    /**@Excel(name = "机构简称")*/
    private String orgnShortName;
    /**机构类型*/
    private String orgnType;
    /**机构层级*/
    private String orgnLevel;
    /**机构状态*/
    private String orgnStatus;
    /**行号*/
    private String bankNo;
    /**网点标识*/
    private String orgnWdsign;
    /**营业性机构标识（0-非营业性 1-营业性 ）*/
    private String prdSaleFlag;
    /**法人机构标识*/
    private String dlfrFlag;
    /**机构序列标识 */
    private String orgnInheritSign;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode;
    }

    public String getParentOrgnCode() {
        return parentOrgnCode;
    }

    public void setParentOrgnCode(String parentOrgnCode) {
        this.parentOrgnCode = parentOrgnCode;
    }

    public String getOrgnName() {
        return orgnName;
    }

    public void setOrgnName(String orgnName) {
        this.orgnName = orgnName;
    }

    public String getOrgnShortName() {
        return orgnShortName;
    }

    public void setOrgnShortName(String orgnShortName) {
        this.orgnShortName = orgnShortName;
    }

    public String getOrgnType() {
        return orgnType;
    }

    public void setOrgnType(String orgnType) {
        this.orgnType = orgnType;
    }

    public String getOrgnLevel() {
        return orgnLevel;
    }

    public void setOrgnLevel(String orgnLevel) {
        this.orgnLevel = orgnLevel;
    }

    public String getOrgnStatus() {
        return orgnStatus;
    }

    public void setOrgnStatus(String orgnStatus) {
        this.orgnStatus = orgnStatus;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getOrgnWdsign() {
        return orgnWdsign;
    }

    public void setOrgnWdsign(String orgnWdsign) {
        this.orgnWdsign = orgnWdsign;
    }

    public String getPrdSaleFlag() {
        return prdSaleFlag;
    }

    public void setPrdSaleFlag(String prdSaleFlag) {
        this.prdSaleFlag = prdSaleFlag;
    }

    public String getDlfrFlag() {
        return dlfrFlag;
    }

    public void setDlfrFlag(String dlfrFlag) {
        this.dlfrFlag = dlfrFlag;
    }

    public String getOrgnInheritSign() {
        return orgnInheritSign;
    }

    public void setOrgnInheritSign(String orgnInheritSign) {
        this.orgnInheritSign = orgnInheritSign;
    }

    @Override
    public String toString() {
        return "OrganizationDO{" +
                "id=" + id +
                ", orgnCode='" + orgnCode + '\'' +
                ", parentOrgnCode='" + parentOrgnCode + '\'' +
                ", orgnName='" + orgnName + '\'' +
                ", orgnShortName='" + orgnShortName + '\'' +
                ", orgnType='" + orgnType + '\'' +
                ", orgnLevel='" + orgnLevel + '\'' +
                ", orgnStatus='" + orgnStatus + '\'' +
                ", bankNo='" + bankNo + '\'' +
                ", orgnWdsign='" + orgnWdsign + '\'' +
                ", prdSaleFlag='" + prdSaleFlag + '\'' +
                ", dlfrFlag='" + dlfrFlag + '\'' +
                ", orgnInheritSign='" + orgnInheritSign + '\'' +
                '}';
    }
}