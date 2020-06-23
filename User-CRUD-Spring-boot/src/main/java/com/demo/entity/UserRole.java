package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.demo.Dto.UserRoleDto;
import com.sun.istack.NotNull;

@Entity
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String roleNm;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_USER_ID"))
	User usr;

	public UserRole() {

	}

	public UserRole(UserRoleDto usrRoleDto) {
		this.id = usrRoleDto.getId();
		this.roleNm = usrRoleDto.getRoleNm();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUsr() {
		return usr;
	}

	public void setUsr(User usr) {
		this.usr = usr;
	}

	public String getRoleNm() {
		return roleNm;
	}

	public void setRoleNm(String roleNm) {
		this.roleNm = roleNm;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", roleNm=" + roleNm + ", user=" + usr + "]";
	}
}
