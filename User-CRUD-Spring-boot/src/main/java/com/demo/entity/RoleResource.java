package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.demo.Dto.RoleResourceDto;

@Entity
public class RoleResource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long roleId;
	private long resourceId;
	private boolean active;

	public RoleResource() {

	}

	public RoleResource(RoleResourceDto roleResourceDto) {
		this.id = roleResourceDto.getId();
		this.roleId = roleResourceDto.getRoleId();
		this.resourceId = roleResourceDto.getResourceId();
		this.active = roleResourceDto.isActive();
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
