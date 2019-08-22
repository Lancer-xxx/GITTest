package com.yihuisoft.authoritybiz.dto.user;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
  * 传输数据权限查询用户的参数
  * @author topz
  * @date 2019/8/17 18:32
  * @version V4.0.0
  **/
public class DataAuthUserDTO {

    /** 用户id */
    private Long id;

    /**机构代码*/
    private Long orgnId;

    /**机构序列号*/
    private String orgnInheritSign;

    /** 当前用户数据权限 */
    private String currentDataAuth;

    /** 用户姓名 */
    private String userName;

    /** 机构编码 */
    private String orgnCode;

    /** 工号 */
    private String workNo;

    /** 角色编码 */
    private String roleCode;

    /** 角色id */
    private Long roleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgnId() {
        return orgnId;
    }

    public void setOrgnId(Long orgnId) {
        this.orgnId = orgnId;
    }

    public String getCurrentDataAuth() {
        return currentDataAuth;
    }

    public void setCurrentDataAuth(String currentDataAuth) {
        this.currentDataAuth = currentDataAuth;
    }

    public String getOrgnInheritSign() {
        return orgnInheritSign;
    }

    public void setOrgnInheritSign(String orgnInheritSign) {
        this.orgnInheritSign = orgnInheritSign;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
