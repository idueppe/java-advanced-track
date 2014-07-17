package io.crowdcode.scrumr.service;

import io.crowdcode.scrumr.dao.UserDao;
import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.InvalidUsernameException;
import io.crowdcode.scrumr.exception.UsernameAlreadyExistException;
import io.crowdcode.scrumr.model.User;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

@Named
@Stateless
public class UserServiceBean
{
	@Inject
	private UserDao userDao;

	public String registerUser(String username, String email) throws InvalidUsernameException, 
			UsernameAlreadyExistException,
			EmailAlreadyExistException, InvalidEmailException
	{
		if (StringUtils.isBlank(username))
			throw new InvalidUsernameException(username);
		if (StringUtils.isBlank(email))
			throw new InvalidEmailException(email);

		if (isUsernameAlreadyExisting(username))
			throw new UsernameAlreadyExistException(username);
		if (isEmailAlreadyExisting(email))
			throw new EmailAlreadyExistException(email);

		User user = new User()
			.withUsername(username)
			.withEmail(email);
		
		userDao.persist(user);

		return user.getId();// UUID.randomUUID().toString();
	}

	public boolean isUsernameAlreadyExisting(String username)
	{
		return userDao.findUserByUsername(username) != null;
	}

	public boolean isEmailAlreadyExisting(String email)
	{
		return userDao.findUserByEmail(email) != null;
	}

	public List<String> getUsernames()
	{
		ArrayList<String> usernames = new ArrayList<>();
		
		for(User user : userDao.findAll())
		{
			usernames.add(user.getUsername());
		}
		
		return usernames;
	}

}
