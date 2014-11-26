package io.crowdcode.scrumr.controller;

import io.crowdcode.scrumr.converters.UserDtoConverter;
import io.crowdcode.scrumr.dto.UserDto;
import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.LastAdministorException;
import io.crowdcode.scrumr.exception.PasswordToShortException;
import io.crowdcode.scrumr.exception.UserNotFoundException;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.crowdcode.scrumr.controller.UserController#getRegisterUser(io.crowdcode
	 * .scrumr.dto.UserDto)
	 */
	@Override
	public String registerUser(UserDto userDto) throws InvalidEmailException, EmailAlreadyExistException, EmptyNameException, PasswordToShortException
	{
		// FIXME idueppe - use entity instead of separated parameters
		//		User user = new User()
		//			.withEmail(userDto.getEmail())
		//			.withFullname(userDto.getFullname());
		
		final String id = userManagementService.registerUser(userDto.getEmail(), userDto.getFullname(), userDto.getPassword(), userDto.isAdmin());
		userDto.setId(id);
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.crowdcode.scrumr.controller.UserController#getUsers()
	 */
	@Override
	public List<UserDto> getUsers()
	{
		return userDtoConverter.convert(userManagementService.getUserList());
	}

	@Override
	public void updateUser(UserDto user) throws UserNotFoundException, LastAdministorException
	{
		userManagementService.updateUser(user.getEmail(), user.getFullname(), user.getPassword(), user.getEmail(), user.isAdmin());
	}

	@Override
	public UserDto getUser(String userId)
	{
		return userDtoConverter.convert(userManagementService.getUser(userId));
	}

}
