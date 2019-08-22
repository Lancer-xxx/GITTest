/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.yihuisoft.authoritybiz.entity.token;


import com.yihuisoft.authoritybiz.entity.menu.Menu;
import com.yihuisoft.authoritybiz.entity.menu.RoleMenuDO;
import com.yihuisoft.authoritybiz.entity.organization.Organization;
import com.yihuisoft.authoritybiz.entity.role.Role;
import com.yihuisoft.authoritybiz.entity.user.User;

import java.io.Serializable;
import java.util.List;

/**
 * 终端实体类
 * @author zhangsh
 * @date 2019/7/29 16:35
 * @version V4.0.1
 **/
public class LoginUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userId;
	private String token;
	private String isManage="0";
	private Organization organization;
	private User user;

	private Role role;
	private List<RoleMenuDO> menuList;

	private List<Menu> list;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIsManage() {
		return isManage;
	}

	public void setIsManage(String isManage) {
		this.isManage = isManage;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<RoleMenuDO> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<RoleMenuDO> menuList) {
		this.menuList = menuList;
	}

	public List<Menu> getList() {
		return list;
	}

	public void setList(List<Menu> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "LoginUser{" +
				"userId='" + userId + '\'' +
				", token='" + token + '\'' +
				", isManage='" + isManage + '\'' +
				", organization=" + organization +
				", user=" + user +
				", role=" + role +
				", menuList=" + menuList +
				", list=" + list +
				'}';
	}
}
