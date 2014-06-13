package com.lhsystem.usersadmin.security.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.lhsystem.usersadmin.security.dao.UserDao;
import com.lhsystem.usersadmin.security.domain.User;

@Stateless
public class UsersServiceBean implements UsersService {

	@EJB
	private UserDao userDao;
	
	@Override
	public List<User> listAllUsers()
	{
//		return new UserDaoBean().findAll(); <-- doesn't work!!!!
		return userDao.findAll();
	}

	// Transaktion begin
	
	@Override
	public void addUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userDao.createUser(user);
	}
	
	// Transaction commit
	
}
