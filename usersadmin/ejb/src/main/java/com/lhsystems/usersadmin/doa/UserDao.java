package com.lhsystems.usersadmin.doa;

import java.util.List;

import com.lhsystems.usersadmin.domain.Role;
import com.lhsystems.usersadmin.domain.User;

public interface UserDao {
	
	public void createUser(User user);
	
	public List<User> findAll();
	
	public List<User> findAllByRole(Role role);

}
