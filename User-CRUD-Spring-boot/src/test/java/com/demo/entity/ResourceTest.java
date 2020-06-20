package com.demo.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class ResourceTest {

	Resource resource = new Resource();

	@Test
	public void testResourceInstanceInitialized() {
		assertNotNull(resource);
	}

	@Test
	public void testResourceFieldsNotEmpty() {
		resource.setId(1);
		resource.setResourceName("getUser");
		resource.setAction("GET");
		resource.setUrl("/users/");

		assertNotEquals("", resource.getId());
		assertNotEquals("", resource.getResourceName());
		assertNotEquals("", resource.getAction());
		assertNotEquals("", resource.getUrl());
	}

	@Test
	public void testResourceFieldsNotNull() {
		resource.setId(1);
		resource.setResourceName("");
		resource.setAction("");
		resource.setUrl("");

		assertNotNull(resource.getId());
		assertNotNull(resource.getResourceName());
		assertNotNull(resource.getAction());
		assertNotNull(resource.getUrl());
	}

}
