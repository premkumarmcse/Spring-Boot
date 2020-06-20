package com.demo.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class UserRoleTest {

	UserRole userRole = new UserRole();

	@Test
	public void testUserRoleInstanceInitialized() {
		assertNotNull(userRole);
	}

	@Test
	public void testUserRoleFieldsNotEmpty() {
		userRole.setId(1);
//		userRole.setUserId(1);
		userRole.setRoleName("TEST");

		assertNotEquals("", userRole.getId());
//		assertNotEquals("", userRole.getUserId());
		assertNotEquals("", userRole.getRoleName());
	}

	@Test
	public void testUserRoleFieldsNotNull() {
		userRole.setId(1);
//		userRole.setUserId(1);
		userRole.setRoleName("TEST");

		assertNotNull(userRole.getId());
//		assertNotNull(userRole.getUserId());
		assertNotNull(userRole.getRoleName());
	}

}
