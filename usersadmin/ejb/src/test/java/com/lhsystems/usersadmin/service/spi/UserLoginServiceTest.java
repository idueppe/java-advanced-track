package com.lhsystems.usersadmin.service.spi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.lhsystems.usersadmin.dao.UserDao;
import com.lhsystems.usersadmin.domain.User;

@RunWith(MockitoJUnitRunner.class)
public class UserLoginServiceTest
{

	@InjectMocks
	private UserLoginServiceBean serviceBean;

	@Mock
	private UserDao userDao;

	private User user;

	@Before
	public void setup()
	{
		user = new User();
		user.setUsername("username");
		user.setPassword("password");
		when(userDao.findByUsername(anyString())).thenReturn(user);
	}

	@Test
	public void testAuthenticate_with_invalid_data()
	{
		assertFalse(serviceBean.authenticate("username", "invalid"));
	}

	@Test
	public void testAuthenticate_with_valid_data()
	{
		assertTrue(serviceBean.authenticate("username", "password"));
	}

}
