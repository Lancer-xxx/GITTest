package com.yihuisoft.customerbiz.entity.custinfo;

/**
  * 客户信息实体（前端返回实体）
  * @author topz
  * @date 2019/8/8 13:28
  * @version V4.0.0
  **/
public class CustInfomation extends CustBaseInfomation{

    /** 用户id（即记录理财经理id，为扩展使用） */
    private Long userId;

    /** 管护人工号（通常是指理财经理） */
    private String managerCode;

    /** 管护人姓名（通常是指理财经理） */
    private String managerName;

    /** 归属机构编码（可能是网点和营业性支行） */
    private String ownedOrgnCode;

    /** 上级机构编码(为支行预留字段) */
    private String supOrgnCode;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(String managerCode) {
        this.managerCode = managerCode;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getOwnedOrgnCode() {
        return ownedOrgnCode;
    }

    public void setOwnedOrgnCode(String ownedOrgnCode) {
        this.ownedOrgnCode = ownedOrgnCode;
    }

    public String getSupOrgnCode() {
        return supOrgnCode;
    }

    public void setSupOrgnCode(String supOrgnCode) {
        this.supOrgnCode = supOrgnCode;
    }
}
