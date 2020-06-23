package com.demo.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class RoleTest {

	Role role = new Role();

	@Test
	public void testRoleInstanceInitialized() {
		assertNotNull(role);
	}

	@Test
	public void testRoleFieldsNotEmpty() {
		role.setId(1);
		role.setRoleNm("ADMIN");

		assertNotEquals("", role.getId());
		assertNotEquals("", role.getRoleNm());
	}

	@Test
	public void testRoleFieldsNotNull() {
		role.setId(1);
		role.setRoleNm("ADMIN");

		assertNotNull(role.getId());
		assertNotNull(role.getRoleNm());
	}
}
