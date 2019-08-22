package com.yihuisoft.authoritybiz.dto.features;

import java.io.Serializable;

/**
 * 功能管理-列表查询DTO
 * @author laijd
 * @date 2019/07/04
 * @version V4.0.0
 * */
public class FeaturesListDTO implements Serializable {
    /**父级id*/
    private Long parentId;
    /**状态*/
    private String status;
    /**功能名称*/
    private String menuName;
    /**功能URL*/
    private String menuUrl;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
