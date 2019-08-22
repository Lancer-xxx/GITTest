package com.yihuisoft.authoritybiz.dto.organization;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 机构信息输入DTO
 * @author laijd
 * @date 2019/7/4
 * @version V4.0.0
 */
public class OrganizationDTO implements Serializable {
    /**机构编码*/
    @NotNull(message = "机构编码不能为空！")
    private String orgnCode;

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode;
    }

    @Override
    public String toString() {
        return "OrganizationDTO{" +
                "orgnCode='" + orgnCode + '\'' +
                '}';
    }
}
