package com.yihuisoft.authoritybiz.dto.role;

import java.util.List;
/**
 * 角色菜单的分配DTO
 * @author mengfanbang
 * @date 2019/8/17
 * @version V4.0.2
 */
public class RoleMenuFuncDTO {
    /**用户id*/
    private Long userId;
    /**角色id*/
    private Long roleId;
    /**模块ids*/
    private List<Long> selectedModule;
    /**菜单id*/
    private List<Long> selectedMenu;
    /**功能id*/
    private List<Long> selectedFunc;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getSelectedModule() {
        return selectedModule;
    }

    public void setSelectedModule(List<Long> selectedModule) {
        this.selectedModule = selectedModule;
    }

    public List<Long> getSelectedMenu() {
        return selectedMenu;
    }

    public void setSelectedMenu(List<Long> selectedMenu) {
        this.selectedMenu = selectedMenu;
    }

    public List<Long> getSelectedFunc() {
        return selectedFunc;
    }

    public void setSelectedFunc(List<Long> selectedFunc) {
        this.selectedFunc = selectedFunc;
    }
}
