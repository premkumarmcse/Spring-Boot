package com.demo.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

public class UserTest {

	User usr = new User();

	@Test
	public void testUserInstanceInitialized() {
		assertNotNull(usr);
	}

	@Test
	public void testUserFieldsNotEmpty() {
		usr.setId(1);
		usr.setUsrNm("pkm");
		usr.setPwd("pkm01");
		usr.setFrstNm("Prem");
		usr.setLstNm(null);
		usr.setEmail(null);

		assertNotEquals("", usr.getId());
		assertNotEquals("", usr.getUsrNm());
		assertNotEquals("", usr.getPwd());
		assertNotEquals("", usr.getFrstNm());
		assertNotEquals("", usr.getLstNm());
		assertNotEquals("", usr.getEmail());
	}

	@Test
	public void testUserFieldsNotNull() {
		usr.setId(1);
		usr.setUsrNm("pkm");
		usr.setPwd("pkm01");
		usr.setFrstNm("Prem");
		usr.setLstNm("M");
		usr.setEmail("abc@gmail.com");

		assertNotNull(usr.getId());
		assertNotNull(usr.getUsrNm());
		assertNotNull(usr.getPwd());
		assertNotNull(usr.getFrstNm());
		assertNotNull(usr.getLstNm());
		assertNotNull(usr.getEmail());
	}

}
