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

import com.demo.Dto.UserDto;
import com.sun.istack.NotNull;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String usrNm;
	@NotNull
	private String pwd;
	@NotNull
	private String frstNm;
	private String lstNm;
	private String email;

	@OneToMany(mappedBy = "usr", cascade = { CascadeType.ALL }, orphanRemoval = true)
	List<UserRole> usrRole = new ArrayList<UserRole>();

	public User() {

	}

	public User(UserDto userDto) {
		this.id = userDto.getId();
		this.usrNm = userDto.getUsrNm();
		this.pwd = userDto.getPwd();
		this.frstNm = userDto.getFrstNm();
		this.lstNm = userDto.getLstNm();
		this.email = userDto.getEmail();
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

	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
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

	public List<UserRole> getUsrRole() {
		return usrRole;
	}

	public void setUsrRole(List<UserRole> usrRole) {
		this.usrRole = usrRole;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", usrNm=" + usrNm + ", pwd=" + pwd + ", frstNm=" + frstNm + ", lstNm=" + lstNm
				+ ", email=" + email + "]";
	}

}
