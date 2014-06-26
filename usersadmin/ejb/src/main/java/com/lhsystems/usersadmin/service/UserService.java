package com.lhsystems.usersadmin.service;

import java.util.List;

import com.lhsystems.usersadmin.dto.UserDto;

public interface UserService {
	
	public void addUser(UserDto userDto);
	
	public List<UserDto> findByRole(String rolle);
	
	public List<UserDto> findAll();

}
