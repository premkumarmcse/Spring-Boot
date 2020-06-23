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
	private String roleNm;
	
	@OneToMany(mappedBy = "role", cascade = { CascadeType.ALL }, orphanRemoval = true)
	List<RoleResource> usrRole = new ArrayList<RoleResource>();

	public Role() {

	}

	public Role(RoleDto roleDto) {
		this.id = roleDto.getId();
		this.roleNm = roleDto.getRoleNm();
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
