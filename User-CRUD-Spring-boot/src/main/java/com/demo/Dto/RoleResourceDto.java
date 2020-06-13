package com.demo.Dto;

import com.demo.entity.RoleResource;

public class RoleResourceDto {
	private long id;
	private long roleId;
	private long resourceId;
	private boolean active;	

	public RoleResourceDto() {

	}

	public RoleResourceDto(RoleResource roleResource) {
		this.id = roleResource.getId();
		this.roleId = roleResource.getRoleId();
		this.resourceId = roleResource.getResourceId();
		this.active = roleResource.isActive();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getResourceId() {
		return resourceId;
	}

	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean grant) {
		this.active = grant;
	}

	@Override
	public String toString() {
		return "RoleResource [id=" + id + ", roleId=" + roleId + ", resourceId=" + resourceId + ", active=" + active
				+ "]";
	}
}
