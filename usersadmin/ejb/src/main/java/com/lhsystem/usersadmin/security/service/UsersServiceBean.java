package com.lhsystem.usersadmin.security.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.lhsystem.usersadmin.security.dao.UserDao;
import com.lhsystem.usersadmin.security.dto.UserDto;

@Stateless
public class UsersServiceBean implements UsersService {

	@EJB
	private UserDao userDao;
	
	@Override
	public List<UserDto> listUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
	}
	
	
}
