package com.demo.Dto;

import com.demo.entity.User;
import com.demo.entity.UserRole;

public class UserRoleDto {
	private long id;
	private String roleNm;
	User usr;

	public UserRoleDto() {

	}

	public UserRoleDto(UserRole userRole) {
		this.id = userRole.getId();
		this.roleNm = userRole.getRoleNm();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleNm() {
		return roleNm;
	}

	public void setRoleNm(String roleNm) {
		this.roleNm = roleNm;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", roleNm=" + roleNm + ", user=" + usr + "]";
	}
}
