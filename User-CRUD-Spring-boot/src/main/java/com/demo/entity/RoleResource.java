package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.demo.Dto.RoleResourceDto;
import com.sun.istack.NotNull;

@Entity
@Table(name = "role_resource", uniqueConstraints = {
		@UniqueConstraint(name = "UK_ROLEID_RESOURCEID", columnNames = { "roleName", "resourceName" }) })
public class RoleResource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String resourceName;
	private boolean active;

	@ManyToOne
	@JoinColumn(name = "roleName", referencedColumnName = "roleName", foreignKey = @ForeignKey(name = "FK_ROLE_NAME"))
	Role role;

	public RoleResource() {

	}

	public RoleResource(RoleResourceDto roleResourceDto) {
		this.id = roleResourceDto.getId();
		this.resourceName = roleResourceDto.getResourceName();
		this.active = roleResourceDto.isActive();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
		return "RoleResource [id=" + id + ", resourceName=" + resourceName + ", active=" + active + ", role=" + role
				+ "]";
	}

}
