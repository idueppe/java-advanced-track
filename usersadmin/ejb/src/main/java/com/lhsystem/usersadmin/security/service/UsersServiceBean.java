package com.lhsystem.usersadmin.security.service;

import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.lhsystem.usersadmin.security.dao.UserDao;
import com.lhsystem.usersadmin.security.domain.Role;
import com.lhsystem.usersadmin.security.domain.User;
import com.lhsystem.usersadmin.security.dto.UserDto;

@Stateless
public class UsersServiceBean implements UsersService {

	@EJB
	private UserDao userDao;
	
	@EJB
	private UserToUsersDtoConverter userConverter;
	
	@Override
	public List<UserDto> listUsers() {
		return userConverter.convert(userDao.findAll());
	}

	@Override
	public void createUser(UserDto userDto) {
		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setRole(Role.valueOf(userDto.getRoleName().toUpperCase()));
		user.setUsername(userDto.getUsername());
		user.setPassword(UUID.randomUUID().toString());
		
		userDao.createUser(user);
		
		// TODO send user password per mail 
	}
	
	
}
