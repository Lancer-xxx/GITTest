package com.yihuisoft.risktipbiz.entity;

import com.yihuisoft.common.base.SnowFlakeIdGen;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author: heyaning
 * @date: 2019/8/20 9:06
 * @version: 4.0.3
 **/
public class RiskTip {
    @Id
    @Column(name = "ID")
    @KeySql(genId = SnowFlakeIdGen.class)
    private Long id;

    /**
     * 风险话术名称
     */
    private String riskTipName;

    /**
     * 风险话术描述
     */
    private String riskTipDescribe;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建人id
     */
    private String createdId;

    /**
     * 更新人id
     */
    private String updateId;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 风险话术详情
     */
    private String riskTipDetails;

    /**
     * 风险话术详情变量html
     */
    private String variableHtml;

    public String getVariableHtml() {
        return variableHtml;
    }

    public void setVariableHtml(String variableHtml) {
        this.variableHtml = variableHtml;
    }

    public String getRiskTipDetails() {
        return riskTipDetails;
    }

    public void setRiskTipDetails(String riskTipDetails) {
        this.riskTipDetails = riskTipDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRiskTipName() {
        return riskTipName;
    }

    public void setRiskTipName(String riskTipName) {
        this.riskTipName = riskTipName;
    }

    public String getRiskTipDescribe() {
        return riskTipDescribe;
    }

    public void setRiskTipDescribe(String riskTipDescribe) {
        this.riskTipDescribe = riskTipDescribe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedId() {
        return createdId;
    }

    public void setCreatedId(String createdId) {
        this.createdId = createdId;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
