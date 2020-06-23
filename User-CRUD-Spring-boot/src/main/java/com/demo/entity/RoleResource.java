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
		@UniqueConstraint(name = "UK_ROLEID_RESOURCEID", columnNames = { "roleNm", "rsrcNm" }) })
public class RoleResource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String rsrcNm;
	private boolean actv;

	@ManyToOne
	@JoinColumn(name = "roleNm", referencedColumnName = "roleNm", foreignKey = @ForeignKey(name = "FK_ROLE_NAME"))
	Role role;

	public RoleResource() {

	}

	public RoleResource(RoleResourceDto roleRsrcDto) {
		this.id = roleRsrcDto.getId();
		this.rsrcNm = roleRsrcDto.getRsrcNm();
		this.actv = roleRsrcDto.isActv();
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
		return "RoleResource [id=" + id + ", rsrcNm=" + rsrcNm + ", actv=" + actv + ", role=" + role
				+ "]";
	}

}
