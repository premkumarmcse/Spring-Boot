package com.demo.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class RoleResourceTest {

	RoleResource roleResource = new RoleResource();

	@Test
	public void testRoleResourceInstanceInitialized() {
		assertNotNull(roleResource);
	}

	@Test
	public void testResourceFieldsNotEmpty() {
		roleResource.setId(1);
//		roleResource.setRoleName("ADNIN");
		roleResource.setResourceName("getUser");
		roleResource.setActive(true);

		assertNotEquals("", roleResource.getId());
//		assertNotEquals("", roleResource.getRoleName());
		assertNotEquals("", roleResource.getResourceName());
		assertNotEquals("", roleResource.isActive());
	}

	@Test
	public void testResourceFieldsNotNull() {
		roleResource.setId(1);
//		roleResource.setRoleName("ADNIN");
		roleResource.setResourceName("getUser");
		roleResource.setActive(true);

		assertNotNull(roleResource.getId());
//		assertNotNull(roleResource.getRoleName());
		assertNotNull(roleResource.getResourceName());
		assertNotNull(roleResource.isActive());
	}

}
