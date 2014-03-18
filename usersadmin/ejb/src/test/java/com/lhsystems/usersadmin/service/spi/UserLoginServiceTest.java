package com.lhsystems.usersadmin.service.spi;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.lhsystems.usersadmin.doa.UserDao;
import com.lhsystems.usersadmin.domain.User;

@RunWith(MockitoJUnitRunner.class)
public class UserLoginServiceTest
{

	@InjectMocks
	private UserAdminServiceBean serviceBean;

	@Mock
	private UserDao userDao;

	private User user;

	@Before
	public void setup()
	{
		user = new User();
		user.setUsername("username");
		user.setPassword("password");
		when(userDao.findAll()).thenReturn(Arrays.asList(user));
	}

	@Test
	public void testFindAll()
	{
		List<User> users = serviceBean.listAllUsers();
		assertFalse(users.isEmpty());
	}
	
	@Test
	public void testCreateUsers()
	{
		serviceBean.createUser(new User());
		verify(userDao, times(1)).create(any(User.class));
	}

	
	@Test
	public void testUpdateUsers()
	{
		serviceBean.updateUser(new User());
		verify(userDao, times(1)).update(any(User.class));
	}
}
