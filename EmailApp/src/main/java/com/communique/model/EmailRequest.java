package com.communique.model;

public class EmailRequest {

	private String username;
	private String fromAddress;
	private String toAddress;
	private String subject;
	private String content;
	public EmailRequest() {
		
	}
	public EmailRequest(String username, String fromAddress, String toAddress, String subject, String content) {
		super();
		this.username = username;
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.subject = subject;
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "EmailRequest [username=" + username + ", fromAddress=" + fromAddress + ", toAddress=" + toAddress
				+ ", subject=" + subject + ", content=" + content + "]";
	}
}
