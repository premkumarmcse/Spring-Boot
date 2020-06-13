package com.demo.Dto;

import com.demo.entity.UserRole;

public class UserRoleDto {
	private long id;
	private long userId;
	private long roleId;
	public UserRoleDto() {

	}

	public UserRoleDto(UserRole userRole) {
		this.id = userRole.getId();
		this.userId = userRole.getUserId();
		this.roleId = userRole.getRoleId();
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", userId=" + userId + ", roleId=" + roleId + "]";
	}
}
