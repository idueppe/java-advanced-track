package com.lhsystem.usersadmin.security.dao;

import java.util.List;

import com.lhsystem.usersadmin.security.domain.User;

public interface UserDao {

	public abstract List<User> findAll();

	public abstract void createUser(User user);

}