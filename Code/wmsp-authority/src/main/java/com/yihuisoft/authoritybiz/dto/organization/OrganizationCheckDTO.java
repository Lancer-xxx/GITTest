package com.yihuisoft.authoritybiz.dto.organization;

import java.io.Serializable;

/**
 * 机构校验DTO
 * @author laijd
 * @date 2019/7/29
 * @version 4.0.1
 */
public class OrganizationCheckDTO implements Serializable {
    /**机构编码：根据机构编码检查机构是否可用*/
    private String orgnCode;
    /**行设号：查询行设号是否正确,原有的organizationMapper.selBankNo。终端管理调用*/
    private String bankNo;

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode;
    }

    @Override
    public String toString() {
        return "OrganizationCheckDTO{" +
                "orgnCode='" + orgnCode + '\'' +
                ", bankNo='" + bankNo + '\'' +
                '}';
    }
}
