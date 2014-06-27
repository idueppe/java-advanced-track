package com.lhsystem.usersadmin.security.service;

import java.util.List;

import com.lhsystem.usersadmin.security.dto.UserDto;

public interface UsersService {

	public List<UserDto> listUsers();
	
	public void createUser(UserDto userDto);

}