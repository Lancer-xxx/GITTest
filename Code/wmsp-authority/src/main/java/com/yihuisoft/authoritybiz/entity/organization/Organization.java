package com.yihuisoft.authoritybiz.entity.organization;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yihuisoft.common.util.excel.Excel;

import java.io.Serializable;
import java.util.Date;

/***
 * 机构信息表实体
 * @author zhaodc
 * @version 4.0.0
 * @date 2019/07/19 13:11
 * @author laijd
 */
public class Organization implements Serializable {
    /**机构ID*/
    private Long id;
    /**机构编码*/
    @Excel(name = "机构代码")
    private String orgnCode;
    /**上级机构编号*/
    @Excel(name = "上级机构")
    private String parentOrgnCode;
    /**机构名称*/
    @Excel(name = "机构名称")
    private String orgnName;
    /**机构简称*/
    /**@Excel(name = "机构简称")*/
    private String orgnShortName;
    /**机构类型*/
    private String orgnType;
    /**机构层级*/
    @Excel(name = "机构层级")
    private String orgnLevel;
    /**机构状态*/
    private String orgnStatus;
    /**区域类型*/
    private String zoneType;
    /**管理级别*/
    private String adminLevel;
    /**功能类型*/
    private String funcType;
    /**行号*/
    private String bankNo;
    /**网点标识*/
    private String orgnWdsign;
    /**创建人ID*/
    private Long createUserid;
    /**创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    /**更新人ID*/
    private Long updateUserid;
    /**更新时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    /**营业性机构标识（0-非营业性 1-营业性 ）*/
    private String prdSaleFlag;
    /**法人机构标识*/
    private String dlfrFlag;
    /**机构序列标识 */
    private String orgnInheritSign;

    public String getOrgnInheritSign() {
        return orgnInheritSign;
    }

    public void setOrgnInheritSign(String orgnInheritSign) {
        this.orgnInheritSign = orgnInheritSign;
    }

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
        this.orgnCode = orgnCode == null ? null : orgnCode.trim();
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
        this.orgnName = orgnName == null ? null : orgnName.trim();
    }

    public String getOrgnShortName() {
        return orgnShortName;
    }

    public void setOrgnShortName(String orgnShortName) {
        this.orgnShortName = orgnShortName == null ? null : orgnShortName.trim();
    }

    public String getOrgnType() {
        return orgnType;
    }

    public void setOrgnType(String orgnType) {
        this.orgnType = orgnType == null ? null : orgnType.trim();
    }

    public String getOrgnLevel() {
        return orgnLevel;
    }

    public void setOrgnLevel(String orgnLevel) {
        this.orgnLevel = orgnLevel == null ? null : orgnLevel.trim();
    }

    public String getOrgnStatus() {
        return orgnStatus;
    }

    public void setOrgnStatus(String orgnStatus) {
        this.orgnStatus = orgnStatus == null ? null : orgnStatus.trim();
    }

    public String getZoneType() {
        return zoneType;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType == null ? null : zoneType.trim();
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel == null ? null : adminLevel.trim();
    }

    public String getFuncType() {
        return funcType;
    }

    public void setFuncType(String funcType) {
        this.funcType = funcType == null ? null : funcType.trim();
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    public String getOrgnWdsign() {
        return orgnWdsign;
    }

    public void setOrgnWdsign(String orgnWdsign) {
        this.orgnWdsign = orgnWdsign == null ? null : orgnWdsign.trim();
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


    public String getDlfrFlag() {
        return dlfrFlag;
    }

    public void setDlfrFlag(String dlfrFlag) {
        this.dlfrFlag = dlfrFlag;
    }

    public String getPrdSaleFlag() {
        return prdSaleFlag;
    }

    public void setPrdSaleFlag(String prdSaleFlag) {
        this.prdSaleFlag = prdSaleFlag;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", orgnCode='" + orgnCode + '\'' +
                ", parentOrgnCode='" + parentOrgnCode + '\'' +
                ", orgnName='" + orgnName + '\'' +
                ", orgnShortName='" + orgnShortName + '\'' +
                ", orgnType='" + orgnType + '\'' +
                ", orgnLevel='" + orgnLevel + '\'' +
                ", orgnStatus='" + orgnStatus + '\'' +
                ", zoneType='" + zoneType + '\'' +
                ", adminLevel='" + adminLevel + '\'' +
                ", funcType='" + funcType + '\'' +
                ", bankNo='" + bankNo + '\'' +
                ", orgnWdsign='" + orgnWdsign + '\'' +
                ", createUserid=" + createUserid +
                ", createTime=" + createTime +
                ", updateUserid=" + updateUserid +
                ", updateTime=" + updateTime +
                ", prdSaleFlag='" + prdSaleFlag + '\'' +
                ", dlfrFlag='" + dlfrFlag + '\'' +
                ", orgnInheritSign='" + orgnInheritSign + '\'' +
                '}';
    }
}