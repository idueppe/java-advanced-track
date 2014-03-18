package com.lhsystems.usersadmin.service.spi;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import com.lhsystems.usersadmin.doa.UserDao;
import com.lhsystems.usersadmin.domain.User;
import com.lhsystems.usersadmin.service.UserAdminService;

@Named
@Stateless
@Local(UserAdminService.class)
public class UserAdminServiceBean implements UserAdminService {

	@Inject
	private UserDao userDao;
	
	@Override
	public List<User> listAllUsers() {
		return userDao.findAll();
	}

	@Override
	public void createUser(User user) {
		userDao.create(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

}
