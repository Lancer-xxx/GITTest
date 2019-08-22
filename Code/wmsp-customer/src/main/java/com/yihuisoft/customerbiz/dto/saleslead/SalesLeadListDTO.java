package com.yihuisoft.customerbiz.dto.saleslead;

import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.DateUtil;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 销售线索的列表查询对象
 * @author dim
 * @date 2019/7/29
 */
public class SalesLeadListDTO implements Serializable {
    /**
     *  姓名
     */
    private String userName;

    /**
     *  电话
     */
    private String phone;

    /**
     *  线索状态
     */
    private String saleStatus;

    /**
     *  分配状态
     */
    private String assignStatus;

    /**
     *  创建日期开始日期
     */
    private String createTimeStartTime;

    /**
     *  创建日期结束日期
     */
    private String createTimeEndTime;

    /**
     * 所属人id
     */
    private String ownerUserId;

    /**
     * 所属机构id
     */
    private String ownerOrganizationId;

    /**
     * 是否有未执行电访计划
     */
    private String isUnExecutePlan;

    /**
     * 最后电访时间开始值
     */
    private String lastContactStartTime;

    /**
     * 最后电访时间结束值
     */
    private String lastContactEndTime;

    /**
     * 登录人数据权限
     */
    private Integer dataId;

    /**
     *  当前登录机构
     */
    private String orgnCode;

    private String orderType;

    private String orgnInheritSign;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrgnInheritSign() {
        return orgnInheritSign;
    }

    public void setOrgnInheritSign(String orgnInheritSign) {
        this.orgnInheritSign = orgnInheritSign;
    }

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode;
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public String getLastContactStartTime() {
        return lastContactStartTime;
    }

    public void setLastContactStartTime(String lastContactStartTime) {
        this.lastContactStartTime = lastContactStartTime;
    }

    public String getLastContactEndTime() {
        return lastContactEndTime;
    }

    public void setLastContactEndTime(String lastContactEndTime) {
        this.lastContactEndTime = lastContactEndTime;
    }

    public String getIsUnExecutePlan() {
        return isUnExecutePlan;
    }

    public void setIsUnExecutePlan(String isUnExecutePlan) {
        this.isUnExecutePlan = isUnExecutePlan;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public String getAssignStatus() {
        return assignStatus;
    }

    public void setAssignStatus(String assignStatus) {
        this.assignStatus = assignStatus;
    }

    public String getCreateTimeStartTime() {
        return createTimeStartTime;
    }

    public void setCreateTimeStartTime(String createTimeStartTime) {
        this.createTimeStartTime = createTimeStartTime;
    }

    public String getCreateTimeEndTime() {
        return createTimeEndTime;
    }

    public void setCreateTimeEndTime(String createTimeEndTime) {
        this.createTimeEndTime = createTimeEndTime;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getOwnerOrganizationId() {
        return ownerOrganizationId;
    }

    public void setOwnerOrganizationId(String ownerOrganizationId) {
        this.ownerOrganizationId = ownerOrganizationId;
    }

    
}
