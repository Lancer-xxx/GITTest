package com.yihuisoft.authoritybiz.dto.menu;

import java.io.Serializable;

/**
 * 菜单信息MenuListDTO
 * @author zhangsh
 * @date 2019/7/26
 * @version V4.0.0
 */
public class MenuListDTO implements Serializable {

    /**菜单ID*/
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MenuListDTO{" +
                "id=" + id +
                '}';
    }
}
