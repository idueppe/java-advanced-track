package com.lhsystems.usersadmin.faces;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lhsystem.usersadmin.security.domain.User;
import com.lhsystem.usersadmin.security.dto.UserDto;
import com.lhsystem.usersadmin.security.service.UsersService;

@Named
@RequestScoped
public class UsersAction {

	@Inject
	private UserDto userDto;
	
	@Inject
	private UsersService usersService;
	
	public String createUser()
	{
		usersService.createUser(userDto);
		
		return "done";
	}
	
	public List<UserDto> getUsers()
	{
		return usersService.listUsers();
	}

}
