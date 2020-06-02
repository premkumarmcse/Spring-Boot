package com.communique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "max_email_limit")
	private long maxEmailLimit;
	
	@Column(name = "current_email_limit")
	private long currentLimit;
	
	
	
	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public long getMaxEmailLimit() {
		return maxEmailLimit;
	}



	public void setMaxEmailLimit(long maxEmailLimit) {
		this.maxEmailLimit = maxEmailLimit;
	}



	public long getCurrentLimit() {
		return currentLimit;
	}



	public void setCurrentLimit(long currentLimit) {
		this.currentLimit = currentLimit;
	}



	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", username=" + username + ", emailId=" + emailId + ", role=" + role
				+ ", maxEmailLimit=" + maxEmailLimit + ", currentLimit=" + currentLimit + "]";
	}
}
