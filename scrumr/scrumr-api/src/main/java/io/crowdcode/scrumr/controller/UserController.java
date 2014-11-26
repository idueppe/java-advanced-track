package io.crowdcode.scrumr.controller;

import io.crowdcode.scrumr.dto.UserDto;
import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.LastAdministorException;
import io.crowdcode.scrumr.exception.PasswordToShortException;
import io.crowdcode.scrumr.exception.UserNotFoundException;

import java.util.List;

public interface UserController
{

	public String registerUser(UserDto userDto) throws InvalidEmailException, EmailAlreadyExistException, EmptyNameException, PasswordToShortException;

	public List<UserDto> getUsers();

	public void updateUser(UserDto newUser) throws UserNotFoundException, LastAdministorException;

	public UserDto getUser(String userId);

}