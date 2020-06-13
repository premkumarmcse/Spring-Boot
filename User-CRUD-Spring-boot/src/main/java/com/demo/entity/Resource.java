package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.demo.Dto.ResourceDto;

@Entity
public class Resource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String action;
	private String url;

	public Resource() {

	}

	public Resource(ResourceDto resourceDto) {
		this.id = resourceDto.getId();
		this.action = resourceDto.getAction();
		this.url = resourceDto.getUrl();
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
		return "Resource [id=" + id + ", action=" + action + ", url=" + url + "]";
	}

}
