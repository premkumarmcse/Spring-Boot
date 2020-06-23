package com.demo.models;

public class AuthenticationRequest {
	private String usrNm;
	private String pwd;

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

	public AuthenticationRequest() {

	}

	public AuthenticationRequest(String usrNm, String pwd) {
		this.setUsrNm(usrNm);
		this.setPwd(pwd);
	}
}
