package com.yihuisoft.authoritybiz.entity.organization;


import java.util.List;

/**
 * 机构树
 * @author zhaodc
 * @version 4.0.0
 * @date 2019/07/19 13:11
 * @author laijd
 */
public class OrganizationTree {

    /**机构编码*/
    private String id;
    /**机构名称||机构编码*/
    private String title;
    /**该机构的子机构列表*/
    private List<OrganizationTree> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<OrganizationTree> getChildren() {
        return children;
    }

    public void setChildren(List<OrganizationTree> children) {
        this.children = children;
    }
}
