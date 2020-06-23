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
	private String rsrcNm;
	@NotNull
	private String actn;
	@NotNull
	private String url;

	public Resource() {

	}

	public Resource(ResourceDto rsrcDto) {
		this.id = rsrcDto.getId();
		this.rsrcNm = rsrcDto.getRsrcNm();
		this.actn = rsrcDto.getActn();
		this.url = rsrcDto.getUrl();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRsrcNm() {
		return rsrcNm;
	}

	public void setRsrcNm(String rsrcNm) {
		this.rsrcNm = rsrcNm;
	}

	public String getActn() {
		return actn;
	}

	public void setActn(String actn) {
		this.actn = actn;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", rsrcNm=" + rsrcNm + ", actn=" + actn + ", url=" + url + "]";
	}

}
