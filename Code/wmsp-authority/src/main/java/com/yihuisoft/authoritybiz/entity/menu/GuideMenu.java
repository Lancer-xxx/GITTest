package com.yihuisoft.authoritybiz.entity.menu;

import java.util.List;

/**
 * 导航栏菜单
 * @author zhaodc
 * @version 4.0.0
 * @date 2019/07/19 13:11
 * @author laijd
 */
public class GuideMenu {
    /**菜单ID*/
    private Long id;
    /**菜单名称*/
    private String title;
    /**菜单状态*/
    private State state;
    /**子菜单*/
    private List<Menu> menu;

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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }
}
