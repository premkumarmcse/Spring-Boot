package com.demo.Dto;

import com.demo.entity.Resource;

public class ResourceDto {

	private long id;
	private String rsrcNm;
	private String actn;
	private String url;

	public ResourceDto() {

	}

	public ResourceDto(Resource rsrc) {
		this.id = rsrc.getId();
		this.actn = rsrc.getActn();
		this.url = rsrc.getUrl();
		this.rsrcNm = rsrc.getRsrcNm();
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
		return "Resource [id=" + id + ", rsrcNm=" + rsrcNm + ", action=" + actn + ", url=" + url + "]";
	}

}
