package com.yihuisoft.authoritybiz.dto.role;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 角色根据key查询实体
 * @author topz
 * @date 2019/6/28 13:24
 * @version V4.0.0
 **/
public class RoleSelectedKeyDTO implements Serializable {

    /**角色ID*/
    @NotNull(message="角色id不能为空")
    private Long id;

    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RoleSelectedKeyDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
