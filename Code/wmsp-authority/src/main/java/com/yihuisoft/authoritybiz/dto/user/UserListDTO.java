package com.yihuisoft.authoritybiz.dto.user;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户信息列表查询
 * @author huangxj
 * @version V4.0.0
 * @date 2019/6/28 11:09
 */
public class UserListDTO {

    /**机构代码*/
    private String orgnCode;

    /**人员姓名*/
    private String userName;

    /**人员工号*/
    private String workNo;

    /** 角色id */
    private Long roleId;

    /** 人员状态 */
    private String status;

    /** 更新时间排序：1顺序 0 倒序*/
    private String updateTimeOrder;

    /** 创建时间排序：1顺序 0 倒序*/
    private String createTimeOrder;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateTimeOrder() {
        return updateTimeOrder;
    }

    public void setUpdateTimeOrder(String updateTimeOrder) {
        this.updateTimeOrder = updateTimeOrder;
    }

    public String getCreateTimeOrder() {
        return createTimeOrder;
    }

    public void setCreateTimeOrder(String createTimeOrder) {
        this.createTimeOrder = createTimeOrder;
    }

    @Override
    public String toString() {
        return "UserListDTO{" +
                "orgnCode='" + orgnCode + '\'' +
                ", userName='" + userName + '\'' +
                ", workNo='" + workNo + '\'' +
                ", roleId=" + roleId +
                ", status='" + status + '\'' +
                '}';
    }
}
