package com.yihuisoft.authoritybiz.dto.features;

import java.io.Serializable;

/**
 * 功能管理-保存功能DTO
 * @author laijd
 * @date 2019/07/04
 * @version V4.0.0
 * */
public class FeaturesSaveDTO implements Serializable {

    /**功能名称*/
    private String menuName;
    /**功能描述*/
    private String menuDesc;
    /**父菜单/父功能id*/
    private Long parentId;
    //功能类型
    private String menuType;
    /**更新人id*/
    private Long createUserid;
    // 功能URL
    private String menuUrl;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public Long getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Long createUserid) {
        this.createUserid = createUserid;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
