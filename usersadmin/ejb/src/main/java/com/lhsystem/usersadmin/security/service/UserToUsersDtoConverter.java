package com.lhsystem.usersadmin.security.service;

import javax.ejb.Stateless;

import com.lhsystem.usersadmin.security.converter.AbstractDefaultConverter;
import com.lhsystem.usersadmin.security.domain.User;
import com.lhsystem.usersadmin.security.dto.UserDto;

@Stateless
public class UserToUsersDtoConverter extends AbstractDefaultConverter<User, UserDto> {

	@Override
	protected UserDto newTargetInstance() {
		return new UserDto();
	}

	@Override
	protected void copyProperties(User source, UserDto target) {
		target
			.withEmail(source.getEmail())
			.withRoleName(source.getRole().toString())
			.withUsername(source.getUsername());
	}

}
