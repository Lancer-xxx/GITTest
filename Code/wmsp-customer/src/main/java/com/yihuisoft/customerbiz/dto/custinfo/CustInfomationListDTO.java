package com.yihuisoft.customerbiz.dto.custinfo;

import javax.validation.constraints.NotNull;

/**
  * 客户信息分页传参实体类
  * @author topz
  * @date 2019/8/8 14:43
  * @version V4.0.0
  **/
public class CustInfomationListDTO {

    /** 客户cis */
    private String cis;

    /** 客户姓名 */
    private String custName;

    /** 手机号 */
    private String mobileNumber;

    /** 身份证号 */
    private String certificateNumber;

    /** 管护经理名 */
    private String managerName;

    /** 是否有未执行电访计划 ：1-无 0-有*/
    private String ifPlanNonExecution;

    /** 年龄查询起点 */
    private String ageStart;

    /** 年龄查询终止 */
    private String ageEnd;

    /** 最后一次电访时间查询起点 */
    private String lastCallTimeStart;

    /** 最后一次电访时间查询终止 */
    private String lastCallTimeEnd;

    /** 所属机构 */
    private String ownedOrgnCode;

    /** 最后一次电访时间排序标识 ：1-正序 0-逆序*/
    private String lastCallTimeOrder;

    /** 最新电访时间排序标识：1-正序 0-逆序 */
    private String latestCallTimeOrder;

    /** 年龄排序标识：1-正序 0-逆序 */
    private String ageOrder;

    @NotNull(message = "当前登陆角色id不能为空！")
    private Long roleId;

    @NotNull(message = "当前登陆用户id不能为空！")
    private Long userId;

    @NotNull(message = "当前登陆用户所在机构id不能为空！")
    private Long loginOrgnId;

    @NotNull(message = "机构序列号不能为空！")
    private String orgnInheritSign;


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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getIfPlanNonExecution() {
        return ifPlanNonExecution;
    }

    public void setIfPlanNonExecution(String ifPlanNonExecution) {
        this.ifPlanNonExecution = ifPlanNonExecution;
    }

    public String getAgeStart() {
        return ageStart;
    }

    public void setAgeStart(String ageStart) {
        this.ageStart = ageStart;
    }

    public String getAgeEnd() {
        return ageEnd;
    }

    public void setAgeEnd(String ageEnd) {
        this.ageEnd = ageEnd;
    }

    public String getOwnedOrgnCode() {
        return ownedOrgnCode;
    }

    public void setOwnedOrgnCode(String ownedOrgnCode) {
        this.ownedOrgnCode = ownedOrgnCode;
    }

    public String getLastCallTimeOrder() {
        return lastCallTimeOrder;
    }

    public void setLastCallTimeOrder(String lastCallTimeOrder) {
        this.lastCallTimeOrder = lastCallTimeOrder;
    }

    public String getLatestCallTimeOrder() {
        return latestCallTimeOrder;
    }

    public void setLatestCallTimeOrder(String latestCallTimeOrder) {
        this.latestCallTimeOrder = latestCallTimeOrder;
    }


    public String getAgeOrder() {
        return ageOrder;
    }

    public void setAgeOrder(String ageOrder) {
        this.ageOrder = ageOrder;
    }

    public String getLastCallTimeStart() {
        return lastCallTimeStart;
    }

    public void setLastCallTimeStart(String lastCallTimeStart) {
        this.lastCallTimeStart = lastCallTimeStart;
    }

    public String getLastCallTimeEnd() {
        return lastCallTimeEnd;
    }

    public void setLastCallTimeEnd(String lastCallTimeEnd) {
        this.lastCallTimeEnd = lastCallTimeEnd;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLoginOrgnId() {
        return loginOrgnId;
    }

    public void setLoginOrgnId(Long loginOrgnId) {
        this.loginOrgnId = loginOrgnId;
    }

    public String getOrgnInheritSign() {
        return orgnInheritSign;
    }

    public void setOrgnInheritSign(String orgnInheritSign) {
        this.orgnInheritSign = orgnInheritSign;
    }
}
