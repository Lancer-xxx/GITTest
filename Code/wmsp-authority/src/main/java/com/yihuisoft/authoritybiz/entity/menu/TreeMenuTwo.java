package com.yihuisoft.authoritybiz.entity.menu;


import com.yihuisoft.authoritybiz.entity.features.RoleFeatures;

import java.util.List;

/**
 * 菜单树
 * @author zhaodc
 * @version 4.0.0
 * @date 2019/07/19 13:11
 * @author laijd
 */
public class TreeMenuTwo {
    /**菜单ID*/
    private Long id;
    /**菜单名称*/
    private String title;
    /**0:系统  1:菜单 2:功能*/
    private String type;
    /**子菜单*/
    private List<TreeMenuTwo> children;

    private List<RoleMenu> roleMenuList;

    private List<RoleFeatures> roleFeaturesList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TreeMenuTwo> getChildren() {
        return children;
    }

    public void setChildren(List<TreeMenuTwo> children) {
        this.children = children;
    }

    public List<RoleMenu> getRoleMenuList() {
        return roleMenuList;
    }

    public void setRoleMenuList(List<RoleMenu> roleMenuList) {
        this.roleMenuList = roleMenuList;
    }

    public List<RoleFeatures> getRoleFeaturesList() {
        return roleFeaturesList;
    }

    public void setRoleFeaturesList(List<RoleFeatures> roleFeaturesList) {
        this.roleFeaturesList = roleFeaturesList;
    }
}