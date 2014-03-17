package com.lhsystems.usersadmin.service.spi;

import com.lhsystems.usersadmin.doa.UserDao;
import com.lhsystems.usersadmin.domain.User;
import com.lhsystems.usersadmin.service.UserLoginService;

public class UserLoginServiceBean implements UserLoginService
{

	private UserDao userDao;

	@Override
	public boolean authenticate(String username, String password)
	{
		User user = userDao.findByUsername(username);
		return user.getPassword().equals(password);
	}

	@Override
	public boolean isPasswordValid(String username)
	{
		// TODO fixme
		return false;
	}

}
