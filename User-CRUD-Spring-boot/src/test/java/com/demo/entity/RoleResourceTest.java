package com.demo.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class RoleResourceTest {

	RoleResource roleRsrc = new RoleResource();

	@Test
	public void testRoleResourceInstanceInitialized() {
		assertNotNull(roleRsrc);
	}

	@Test
	public void testResourceFieldsNotEmpty() {
		roleRsrc.setId(1);
		roleRsrc.setRsrcNm("getUser");
		roleRsrc.setActv(true);

		assertNotEquals("", roleRsrc.getId());
		assertNotEquals("", roleRsrc.getRsrcNm());
		assertNotEquals("", roleRsrc.isActv());
	}

	@Test
	public void testResourceFieldsNotNull() {
		roleRsrc.setId(1);
		roleRsrc.setRsrcNm("getUser");
		roleRsrc.setActv(true);

		assertNotNull(roleRsrc.getId());
		assertNotNull(roleRsrc.getRsrcNm());
		assertNotNull(roleRsrc.isActv());
	}

}
