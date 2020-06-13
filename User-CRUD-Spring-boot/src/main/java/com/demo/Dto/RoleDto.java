package com.demo.Dto;

import com.demo.entity.Role;

public class RoleDto {
	private long id;
	private String roleName;

	public RoleDto() {

	}

	public RoleDto(Role role) {
		this.id = role.getId();
		this.roleName = role.getRoleName();
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
		return "Role [id=" + id + ", roleName=" + roleName + "]";
	}

}
