package com.demo.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class UserRoleTest {

	UserRole usrRole = new UserRole();

	@Test
	public void testUserRoleInstanceInitialized() {
		assertNotNull(usrRole);
	}

	@Test
	public void testUserRoleFieldsNotEmpty() {
		usrRole.setId(1);
		usrRole.setRoleNm("TEST");

		assertNotEquals("", usrRole.getId());
		assertNotEquals("", usrRole.getRoleNm());
	}

	@Test
	public void testUserRoleFieldsNotNull() {
		usrRole.setId(1);
		usrRole.setRoleNm("TEST");

		assertNotNull(usrRole.getId());
		assertNotNull(usrRole.getRoleNm());
	}

}
