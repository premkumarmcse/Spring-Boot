package com.communique.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmailLimits {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String userName;
	private long maxEmailLimit;
	private long remainingEmailLimit;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getMaxEmailLimit() {
		return maxEmailLimit;
	}
	public void setMaxEmailLimit(long maxEmailLimit) {
		this.maxEmailLimit = maxEmailLimit;
	}
	public long getRemainingEmailLimit() {
		return remainingEmailLimit;
	}
	public void setRemainingEmailLimit(long remainingEmailLimit) {
		this.remainingEmailLimit = remainingEmailLimit;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "EmailLimits [id=" + id + ", userName=" + userName + ", maxEmailLimit=" + maxEmailLimit
				+ ", remainingEmailLimit=" + remainingEmailLimit + "]";
	}
}
