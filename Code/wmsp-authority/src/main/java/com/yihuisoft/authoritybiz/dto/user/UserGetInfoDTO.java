package com.yihuisoft.authoritybiz.dto.user;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 查询用户信息及角色信息DTO
 * @author huangxj
 * @version V4.0.0
 * @date 2019/6/28 11:56
 */
public class UserGetInfoDTO {

    /**登录账号*/
    @NotBlank(message = "用户编码不能为空！")
    private String userCode;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
