package com.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.demo.Dto.RoleDto;
import com.sun.istack.NotNull;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String roleName;
	
	@OneToMany(mappedBy = "role", cascade = { CascadeType.ALL }, orphanRemoval = true)
	List<RoleResource> userRole = new ArrayList<RoleResource>();

	public Role() {

	}

	public Role(RoleDto roleDto) {
		this.id = roleDto.getId();
		this.roleName = roleDto.getRoleName();
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
