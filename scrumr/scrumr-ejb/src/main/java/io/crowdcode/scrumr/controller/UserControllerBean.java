package io.crowdcode.scrumr.controller;

import io.crowdcode.scrumr.converters.UserDtoConverter;
import io.crowdcode.scrumr.dto.UserDto;
import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.PasswordToShortException;
import io.crowdcode.scrumr.service.UserManagementService;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Stateless
@Local(UserController.class)
public class UserControllerBean implements UserController
{

	@Inject
	private UserManagementService userManagementService;
	
	@Inject
	private UserDtoConverter userDtoConverter;

	/* (non-Javadoc)
	 * @see io.crowdcode.scrumr.controller.UserController#getRegisterUser(io.crowdcode.scrumr.dto.UserDto)
	 */
	@Override
	public String getRegisterUser(UserDto userDto)
	{
		try
		{
			return userManagementService.registerUser(userDto.getEmail(), userDto.getFullname(), userDto.getPassword(), userDto.isAdmin());
		} catch (InvalidEmailException | EmailAlreadyExistException | EmptyNameException | PasswordToShortException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see io.crowdcode.scrumr.controller.UserController#getUsers()
	 */
	@Override
	public List<UserDto> getUsers()
	{
		return userDtoConverter.convert(userManagementService.getUserList());
	}

}
