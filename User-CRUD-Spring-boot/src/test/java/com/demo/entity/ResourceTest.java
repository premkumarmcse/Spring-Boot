package com.demo.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class ResourceTest {

	Resource rsrc = new Resource();

	@Test
	public void testResourceInstanceInitialized() {
		assertNotNull(rsrc);
	}

	@Test
	public void testResourceFieldsNotEmpty() {
		rsrc.setId(1);
		rsrc.setRsrcNm("getUser");
		rsrc.setActn("GET");
		rsrc.setUrl("/users/");

		assertNotEquals("", rsrc.getId());
		assertNotEquals("", rsrc.getRsrcNm());
		assertNotEquals("", rsrc.getActn());
		assertNotEquals("", rsrc.getUrl());
	}

	@Test
	public void testResourceFieldsNotNull() {
		rsrc.setId(1);
		rsrc.setRsrcNm("");
		rsrc.setActn("");
		rsrc.setUrl("");

		assertNotNull(rsrc.getId());
		assertNotNull(rsrc.getRsrcNm());
		assertNotNull(rsrc.getActn());
		assertNotNull(rsrc.getUrl());
	}

}
