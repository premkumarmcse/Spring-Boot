package com.demo.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

public class UserTest {

	User user = new User();

	@Test
	public void testUserInstanceInitialized() {
		assertNotNull(user);
	}

	@Test
	public void testUserFieldsNotEmpty() {
		user.setId(1);
		user.setUsername("pkm");
		user.setPassword("pkm01");
		user.setFirstName("Prem");
		user.setLastName(null);
		user.setEmail(null);

		assertNotEquals("", user.getId());
		assertNotEquals("", user.getUsername());
		assertNotEquals("", user.getPassword());
		assertNotEquals("", user.getFirstName());
		assertNotEquals("", user.getLastName());
		assertNotEquals("", user.getEmail());
	}

	@Test
	public void testUserFieldsNotNull() {
		user.setId(1);
		user.setUsername("pkm");
		user.setPassword("pkm01");
		user.setFirstName("Prem");
		user.setLastName("M");
		user.setEmail("abc@gmail.com");

		assertNotNull(user.getId());
		assertNotNull(user.getUsername());
		assertNotNull(user.getPassword());
		assertNotNull(user.getFirstName());
		assertNotNull(user.getLastName());
		assertNotNull(user.getEmail());
	}

}
