package com.lhsystems.usersadmin.service;

import java.util.List;

import com.lhsystems.usersadmin.domain.User;

public interface UserAdminService {
	
	public List<User> listAllUsers();
	
	public void createUser(User user) throws UserAlreadyExistsException;
	
	public void updateUser(User user) throws UserNotFoundException;
	
}
