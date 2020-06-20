package com.demo.Dto;

import com.demo.entity.Role;
import com.demo.entity.RoleResource;

public class RoleResourceDto {
	private long id;
//	private String roleName;
	private String resourceName;
	private boolean active;
	Role role;

	public RoleResourceDto() {

	}

	public RoleResourceDto(RoleResource roleResource) {
		this.id = roleResource.getId();
//		this.roleName = roleResource.getRoleName();
		this.resourceName = roleResource.getResourceName();
		this.active = roleResource.isActive();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*
	 * public String getRoleName() { return roleName; }
	 * 
	 * public void setRoleName(String roleName) { this.roleName = roleName; }
	 */

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RoleResourceDto [id=" + id + ", resourceName=" + resourceName + ", active=" + active + ", role=" + role
				+ "]";
	}
}
