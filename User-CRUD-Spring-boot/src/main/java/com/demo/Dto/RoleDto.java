package com.demo.Dto;

import com.demo.entity.Role;

public class RoleDto {
	private long id;
	private String roleNm;

	public RoleDto() {

	}

	public RoleDto(Role role) {
		this.id = role.getId();
		this.roleNm = role.getRoleNm();
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
		return "Role [id=" + id + ", roleNm=" + roleNm + "]";
	}

}
