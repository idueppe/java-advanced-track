package io.crowdcode.scrumr.service;

import io.crowdcode.scrumr.dao.UserDao;
import io.crowdcode.scrumr.exception.InvalidUsernameException;
import io.crowdcode.scrumr.model.User;

import java.util.UUID;

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

	public String registerUser(String username, String email) throws InvalidUsernameException
	{
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(username))
			throw new InvalidUsernameException(username);

		User user = new User();
		userDao.persist(user);
		
		return user.getId();//UUID.randomUUID().toString();
	}

}
