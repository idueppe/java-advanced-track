package com.lhsystems.usersadmin.service.spi;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import com.lhsystems.usersadmin.doa.UserDao;
import com.lhsystems.usersadmin.domain.Role;
import com.lhsystems.usersadmin.domain.User;
import com.lhsystems.usersadmin.service.UserAdminService;

@Named
@Stateless
@Local(UserAdminService.class)
public class UserAdminServiceBean implements UserAdminService {

	@Inject
	// CDI Annotation
	// @EJB // EJB Annotation
	private UserDao userDao;

	@Override
	public List<User> listAllUsers() {

		List<User> users = userDao.findAll();
		List<User> result = new LinkedList<>();
		for (User user : users)
			if (user.getRole() == Role.USER)
				result.add(user);
		return result;
	}

	@Override
	public void createUser(User user) throws UserAlreadyExistsException {
		User found = userDao.findByUsername(user.getUsername());
		if (found != null)
			throw new UserAlreadyExistsException("User " + user.getUsername()
					+ " already exists");
		userDao.create(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	public void resetPasswort(Long id, String newPassword) {
		User user = userDao.find(id);
		if (user != null) {
			user.setPassword(newPassword);
			userDao.update(user);
		}
	}

}
