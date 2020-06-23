package com.demo.Dto;

import java.util.Optional;

import com.demo.entity.User;

public class UserDto {
	private long id;
	private String usrNm;
	private String pwd;
	private String frstNm;
	private String lstNm;
	private String email;
	private String role;

	public UserDto() {

	}

	public UserDto(User user) {
		this.id = user.getId();
		this.usrNm = user.getUsrNm();
		this.pwd = user.getPwd();
		this.frstNm = user.getFrstNm();
		this.lstNm = user.getLstNm();
		this.email = user.getEmail();
	}

	public UserDto(Optional<UserDto> user) {
		this.id = user.get().getId();
		this.usrNm = user.get().getUsrNm();
		this.pwd = user.get().getPwd();
		this.frstNm = user.get().getFrstNm();
		this.lstNm = user.get().getLstNm();
		this.email = user.get().getEmail();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsrNm() {
		return usrNm;
	}

	public void setUsrNm(String username) {
		this.usrNm = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getFrstNm() {
		return frstNm;
	}

	public void setFrstNm(String frstNm) {
		this.frstNm = frstNm;
	}

	public String getLstNm() {
		return lstNm;
	}

	public void setLstNm(String lstNm) {
		this.lstNm = lstNm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", usrNm=" + usrNm + ", pwd=" + pwd + ", frstNm=" + frstNm + ", lstNm=" + lstNm
				+ ", email=" + email + "]";
	}
}
