package com.yihuisoft.authoritybiz.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 用户插入DTO
 * @author huangxj
 * @version V4.0.0
 * @date 2019/6/28 11:03
 */
public class UserInsertDTO {

    /**人员姓名*/
    @NotBlank(message = "用户姓名不能为空！")
    private String userName;
    /**人员工号*/
    @NotBlank(message = "用户工号不能为空！")
    private String workNo;
    /**机构代码*/
    @NotBlank(message = "所属机构编码不能为空！")
    private String orgnCode;
    /**角色Id*/
    @NotNull(message = "所属角色id不能为空！")
    private Long roleId;
    /**笔记邮箱*/
    private String notesMail;
    /**证件号码*/
    @NotBlank(message = "用户证件号不能为空！")
    private String idNo;
    /**性别*/
    private String gender;
    /**教育程度*/
    private String education;
    /**手机号*/
    @NotBlank(message = "手机号不能为空！")
    private String phone;
    /**qq号*/
    private String qq;
    /**微信号*/
    private String wechat;
    /**用户密码*/
    private String userpwd;
    /**生日(YYYY-MM-DD)*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    /**状态*/
    @NotBlank(message = "人员状态不能为空！")
    private String status;
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
    /**创建人工号*/
    @NotNull(message = "创建人工号不能为空！")
    private Long createUserid;
    /** 职位 */
    private String position;
    /** 婚姻状态:1-已婚,0-未婚 */
    private String maritalStatus;
    /** 角色code */
    @NotBlank(message = "角色编码不能为空！")
    private String roleCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getNotesMail() {
        return notesMail;
    }

    public void setNotesMail(String notesMail) {
        this.notesMail = notesMail;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Long getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Long createUserid) {
        this.createUserid = createUserid;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserInsertDTO{" +
                "userName='" + userName + '\'' +
                ", workNo='" + workNo + '\'' +
                ", orgnCode='" + orgnCode + '\'' +
                ", roleId=" + roleId +
                ", notesMail='" + notesMail + '\'' +
                ", idNo='" + idNo + '\'' +
                ", gender='" + gender + '\'' +
                ", education='" + education + '\'' +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", birthday=" + birthday +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mail='" + mail + '\'' +
                ", workphone='" + workphone + '\'' +
                ", fax='" + fax + '\'' +
                ", createUserid=" + createUserid +
                ", position='" + position + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", roleCode='" + roleCode + '\'' +
                '}';
    }
}
