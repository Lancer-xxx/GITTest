package com.yihuisoft.authoritybiz.dto.user;

/**
 * 用户信息校验DTO
 * @author huangxj
 * @version V4.0.0
 * @date 2019/6/28 11:16
 */
public class UserCheckDTO {

    /**人员id*/
    private Long id;
    /**人员工号*/
    private String workNo;
    /**手机号*/
    private String phone;
    /**证件号码*/
    private String idNo;

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
