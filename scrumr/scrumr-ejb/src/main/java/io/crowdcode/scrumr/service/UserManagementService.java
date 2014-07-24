package io.crowdcode.scrumr.service;

import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.LastAdministorException;
import io.crowdcode.scrumr.exception.PasswordToShortException;
import io.crowdcode.scrumr.exception.UserNotFoundException;
import io.crowdcode.scrumr.model.User;

import java.util.List;

public interface UserManagementService
{

	public String registerUser(String email, String name, String password, boolean isAdmin) //
			throws InvalidEmailException, EmailAlreadyExistException, EmptyNameException, PasswordToShortException;

	public void removeUser(String email) throws LastAdministorException, UserNotFoundException;

	public void updateUser(String email, String name, String password, String newEmail, boolean isAdmin) //
			throws UserNotFoundException, LastAdministorException;

	public List<User> getUserList();

}