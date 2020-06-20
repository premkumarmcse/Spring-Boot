package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.demo.Dto.ResourceDto;
import com.sun.istack.NotNull;

@Entity
public class Resource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String resourceName;
	@NotNull
	private String action;
	@NotNull
	private String url;

	public Resource() {

	}

	public Resource(ResourceDto resourceDto) {
		this.id = resourceDto.getId();
		this.resourceName = resourceDto.getResourceName();
		this.action = resourceDto.getAction();
		this.url = resourceDto.getUrl();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
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
		return "Resource [id=" + id + ", resourceName=" + resourceName + ", action=" + action + ", url=" + url + "]";
	}

}
