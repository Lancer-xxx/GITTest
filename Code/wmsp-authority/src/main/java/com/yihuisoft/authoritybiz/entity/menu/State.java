package com.yihuisoft.authoritybiz.entity.menu;

/**
 * 菜单状态
 * @author zhaodc
 * @version 4.0.0
 * @date 2019/07/19 13:11
 * @author laijd
 */
public class State {
    /**选中状态*/
    private Boolean checked;
    /**是否处于disable状态*/
    private Boolean disabled;
    /**是否可以展开*/
    private Boolean expanded;
    /**是否可以被选择*/
    private Boolean selected;

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
