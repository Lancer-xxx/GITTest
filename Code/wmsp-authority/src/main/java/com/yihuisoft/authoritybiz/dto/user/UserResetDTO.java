package com.yihuisoft.authoritybiz.dto.user;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 用户密码重置DTO
 * @author huangxj
 * @version V4.0.0
 * @date 2019/6/28 11:21
 */
public class UserResetDTO {

    @NotNull(message = "用户id不能为空！")
    /**用户ID*/
    private Long id;
    /**用户密码*/
    @NotEmpty(message = "用户密码不能为空！")
    private String userpwd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
}
