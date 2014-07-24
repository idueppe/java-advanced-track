package io.crowdcode.scrumr.controller;

import io.crowdcode.scrumr.dto.UserDto;

import java.util.List;

public interface UserController
{

	public String getRegisterUser(UserDto userDto);

	public List<UserDto> getUsers();

}