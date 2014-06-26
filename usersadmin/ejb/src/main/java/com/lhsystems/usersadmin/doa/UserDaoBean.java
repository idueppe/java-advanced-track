package com.lhsystems.usersadmin.doa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lhsystems.usersadmin.domain.Role;
import com.lhsystems.usersadmin.domain.User;

public class UserDaoBean implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllByRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

}
