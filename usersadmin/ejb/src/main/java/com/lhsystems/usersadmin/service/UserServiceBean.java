package com.lhsystems.usersadmin.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.lhsystems.usersadmin.doa.UserDao;
import com.lhsystems.usersadmin.domain.Role;
import com.lhsystems.usersadmin.domain.User;
import com.lhsystems.usersadmin.dto.UserDto;

@Stateless
@Local(UserService.class)
public class UserServiceBean implements UserService {

	@EJB
	private UserDao userDao;
	
	@Override
	public void addUser(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setRole(Role.valueOf(userDto.getRole().toUpperCase()));
		
		userDao.createUser(user);
	}

	@Override
	public List<UserDto> findByRole(String role) {
		List<UserDto> dtos = new ArrayList<>();
		return dtos;
	}

	@Override
	public List<UserDto> findAll() {
		List<UserDto> dtos = new ArrayList<>();
		
		for (User user : userDao.findAll())
		{
			UserDto dto = new UserDto()//
				.withEmail(user.getEmail())//
				.withRole(user.getRole().toString())//
				.withUsername(user.getUsername());
			dtos.add(dto);
		}
		
		return dtos;
	}

}
