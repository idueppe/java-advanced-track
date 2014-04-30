package com.lhsystems.usersadmin.security.domain;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.lhsystem.usersadmin.security.domain.User;

public class UserTest {

	@Test
	public void testInitialization() throws Exception {
		User user = new User();
		assertNotNull(user.getLastPasswordChanged());
	}
	
	@Test
	public void testSet() throws Exception {
		User user = new User();
		assertNull(user.getPassword());
		user.setPassword("password1");
		assertEquals("password1", user.getPassword());
	}
	
	@Test
	public void testCheckLastPasswordChanged() throws Exception {
		User user = new User();
		Date lastPasswordChanged = user.getLastPasswordChanged();
		
		user.setPassword("password1");
		assertFalse(lastPasswordChanged == user.getLastPasswordChanged());
		assertEquals("password1", user.getPassword());
	}

}
