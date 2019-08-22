package com.yihuisoft.authoritybiz.entity.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yihuisoft.common.util.app.JsonLongSerializer;
import com.yihuisoft.common.util.excel.Excel;
import java.util.Date;

/**
 * 用户信息
 * @author huangxj
 * @version V4.0.0
 * @date 2019/6/28 11:56
 */
public class User {

    /**登录账号*/
    private String userCode;
    /**角色Id*/
    private Long roleId;
    /**性别*/
    private String gender;

    @JsonSerialize(using = JsonLongSerializer.class )
    @Excel(name = "人员ID")
    private Long id;

    @Excel(name = "人员工号")
    private String workNo;

    @Excel(name = "人员姓名")
    private String userName;

    @Excel(name = "证件号码")
    private String idNo;

    @Excel(name = "手机号")
    private String phone;

    @Excel(name = "人员角色")
    private String roleName;

    @Excel(name = "人员状态")
    private String status;

    @Excel(name = "机构编号")
    private String orgnCode;

    @Excel(name = "机构名称")
    private String orgnName;

    @Excel(name = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @Excel(name = "创建人ID")
    private Long createUserid;

    @Excel(name = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    @Excel(name = "更新用户ID")
    private Long updateUserid;

    /** 角色代码 */
    private String roleCode;

    /**生日(YYYY-MM-DD)*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    /**教育程度*/
    private String education;
    /** 婚姻状态:1-已婚,0-未婚 */
    private String maritalStatus;
    /** 职位 */
    private String position;
    /**地址*/
    private String address;
    /**移动电话*/
    private String mobile;
    /**邮箱*/
    private String mail;
    /**工作电话*/
    private String workphone;
    /**传真*/
    private String fax;
    /**qq号*/
    private String qq;
    /**微信号*/
    private String wechat;
    /**用户密码*/
    private String userpwd;

    /**机构ID*/
    private Long orgnId;
    /**ID类型*/
    private String idType;
    /**描述*/
    private String descb;
    /**总工作年龄*/
    private String totalWorkYear;
    /**当前工作年龄*/
    private String currentWorkYear;
    /**当前开始时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date currentBeginDate;
    /**工作年龄*/
    private String workYear;
    /**更新密码时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date upPasswordTime;



    /**数据权限*/
    private String dataAuth;
    /**机构等级*/
    private String orgnLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWorkphone() {
        return workphone;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Long createUserid) {
        this.createUserid = createUserid;
    }

    public String getOrgnName() {
        return orgnName;
    }

    public void setOrgnName(String orgnName) {
        this.orgnName = orgnName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getOrgnId() {
        return orgnId;
    }

    public void setOrgnId(Long orgnId) {
        this.orgnId = orgnId;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getDescb() {
        return descb;
    }

    public void setDescb(String descb) {
        this.descb = descb;
    }

    public String getTotalWorkYear() {
        return totalWorkYear;
    }

    public void setTotalWorkYear(String totalWorkYear) {
        this.totalWorkYear = totalWorkYear;
    }

    public String getCurrentWorkYear() {
        return currentWorkYear;
    }

    public void setCurrentWorkYear(String currentWorkYear) {
        this.currentWorkYear = currentWorkYear;
    }

    public Date getCurrentBeginDate() {
        return currentBeginDate;
    }

    public void setCurrentBeginDate(Date currentBeginDate) {
        this.currentBeginDate = currentBeginDate;
    }

    public String getWorkYear() {
        return workYear;
    }

    public void setWorkYear(String workYear) {
        this.workYear = workYear;
    }

    public Date getUpPasswordTime() {
        return upPasswordTime;
    }

    public void setUpPasswordTime(Date upPasswordTime) {
        this.upPasswordTime = upPasswordTime;
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

    public String getDataAuth() {
        return dataAuth;
    }

    public void setDataAuth(String dataAuth) {
        this.dataAuth = dataAuth;
    }

    public String getOrgnLevel() {
        return orgnLevel;
    }

    public void setOrgnLevel(String orgnLevel) {
        this.orgnLevel = orgnLevel;
    }
}