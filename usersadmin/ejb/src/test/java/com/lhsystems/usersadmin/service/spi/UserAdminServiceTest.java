package com.lhsystems.usersadmin.service.spi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyLong;
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
import com.lhsystems.usersadmin.domain.Role;
import com.lhsystems.usersadmin.domain.User;
import com.lhsystems.usersadmin.service.UserAlreadyExistsException;
import com.lhsystems.usersadmin.service.UserNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class UserAdminServiceTest
{

	@InjectMocks
	private UserAdminServiceBean serviceBean;

	@Mock
	private UserDao userDao;

	private User user;
	
	private User admin;

	@Before
	public void setup()
	{
		user = new User();
		user.setRole(Role.USER);
		
		admin = new User();
		admin.setRole(Role.ADMIN);
	}

	@Test
	public void testFindAllUsers()
	{
		when(userDao.findAll()).thenReturn(Arrays.asList(user, admin));
		List<User> users = serviceBean.listAllUsers();
		assertEquals(1, users.size());
		assertTrue(users.get(0).getRole() == Role.USER);
	}

	@Test
	public void testCreateUser() throws UserAlreadyExistsException
	{
		user.setUsername("username");
		serviceBean.createUser(user);
		verify(userDao, times(1)).findByUsername("username");
		verify(userDao, times(1)).create(any(User.class));
	}
	
	@Test(expected=UserAlreadyExistsException.class)
	public void testCreateExistingUser() throws UserAlreadyExistsException
	{
		when(userDao.findByUsername(anyString())).thenReturn(user);
		serviceBean.createUser(user);
	}
	
	@Test
	public void testUpdateUsers() throws UserNotFoundException
	{
		serviceBean.updateUser(user);
		verify(userDao, times(1)).update(any(User.class));
	}
	
	@Test
	public void testResetPassword()
	{
		when(userDao.find(anyLong())).thenReturn(user);
		serviceBean.resetPasswort(user.getId(), "newPassword");
		assertEquals("newPassword", user.getPassword());
	}
	
}
