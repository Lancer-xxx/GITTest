package com.yihuisoft.authoritybiz.dto.menu;
import java.io.Serializable;

/**
 * 菜单信息DTO
 * @author laijd
 * @date 2019/7/1
 * @version V4.0.0
 */
public class MenuDTO implements Serializable {
    /**菜单ID*/
    private Long id;
    /**更新人Id*/
    private Long updateUserid;
    /**类型*/
    private String menuType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Long updateUserid) {
        this.updateUserid = updateUserid;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }
}
