package com.demo.Dto;

import com.demo.entity.Resource;

public class ResourceDto {

	private long id;
	private String action;
	private String url;

	public ResourceDto() {

	}

	public ResourceDto(Resource resource) {
		this.id = resource.getId();
		this.action = resource.getAction();
		this.url = resource.getUrl();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ResourceDto [id=" + id + ", action=" + action + ", url=" + url + "]";
	}

}
