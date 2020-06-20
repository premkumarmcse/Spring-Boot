package com.demo.Dto;

import com.demo.entity.User;
import com.demo.entity.UserRole;

public class UserRoleDto {
	private long id;
	private String roleName;
	User user;

	public UserRoleDto() {

	}

	public UserRoleDto(UserRole userRole) {
		this.id = userRole.getId();
		this.roleName = userRole.getRoleName();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", roleName=" + roleName + ", user=" + user + "]";
	}
}
