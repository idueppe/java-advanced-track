package com.lhsystems.usersadmin.service;

public interface UserLoginService
{

	public boolean authenticate(String username, String password);

	public boolean isPasswordValid(String username);

}
