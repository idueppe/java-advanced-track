package com.lhsystem.usersadmin.security.service;

import java.util.List;

import com.lhsystem.usersadmin.security.domain.User;

public interface UsersService {

	public abstract List<User> listAllUsers();

	public abstract void addUser(String username, String password);

}