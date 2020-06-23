package com.demo.Dto;

import com.demo.entity.Role;
import com.demo.entity.RoleResource;

public class RoleResourceDto {
	private long id;
	private String rsrcNm;
	private boolean actv;
	Role role;

	public RoleResourceDto() {

	}

	public RoleResourceDto(RoleResource roleRsrc) {
		this.id = roleRsrc.getId();
		this.rsrcNm = roleRsrc.getRsrcNm();
		this.actv = roleRsrc.isActv();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRsrcNm() {
		return rsrcNm;
	}

	public void setRsrcNm(String rsrcNm) {
		this.rsrcNm = rsrcNm;
	}

	public boolean isActv() {
		return actv;
	}

	public void setActv(boolean actv) {
		this.actv = actv;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RoleResourceDto [id=" + id + ", rsrcNm=" + rsrcNm + ", actv=" + actv + ", role=" + role
				+ "]";
	}
}
