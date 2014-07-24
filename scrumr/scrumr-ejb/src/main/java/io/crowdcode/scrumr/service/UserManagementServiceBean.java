package io.crowdcode.scrumr.service;

import io.crowdcode.scrumr.dao.UserDao;
import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.LastAdministorException;
import io.crowdcode.scrumr.exception.PasswordToShortException;
import io.crowdcode.scrumr.exception.UserNotFoundException;
import io.crowdcode.scrumr.model.User;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

@Stateless
@Local(UserManagementService.class)
public class UserManagementServiceBean implements UserManagementService
{
	private static final int MIN_PASSWORD_LENGTH = 5;

	@EJB
	private UserDao userDao;
	
	/* (non-Javadoc)
	 * @see io.crowdcode.scrumr.service.UserManagementService#registerUser(java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public String registerUser(String email, String name, String password, boolean isAdmin) throws InvalidEmailException,
			EmailAlreadyExistException, EmptyNameException, PasswordToShortException
	{
		if (!EmailValidator.getInstance().isValid(email)) { 
			throw new InvalidEmailException(email);
		}
		if (userDao.findUserByEmail(email) != null)
		{
			throw new EmailAlreadyExistException(email);
		}
		if (StringUtils.isBlank(name))
		{
			throw new EmptyNameException(name);
		}
		if (StringUtils.length(password) < MIN_PASSWORD_LENGTH)
		{
			throw new PasswordToShortException(password, MIN_PASSWORD_LENGTH);
		}
		User user = new User()
		   .withEmail(email)
		   .withFullname(name)
		   .withPassword(password)
		   .withAdmin(isAdmin);
		userDao.persist(user);
		return user.getId();
	}

	/* (non-Javadoc)
	 * @see io.crowdcode.scrumr.service.UserManagementService#removeUser(java.lang.String)
	 */
	@Override
	public void removeUser(String email) throws LastAdministorException, UserNotFoundException
	{
		User user = userDao.findUserByEmail(email);
		if (user == null)
		{
			throw new UserNotFoundException(email);
		}
		if (isLastAdmin(user))
		{
			throw new LastAdministorException(email);
		}
		userDao.remove(user);
	}

	/* (non-Javadoc)
	 * @see io.crowdcode.scrumr.service.UserManagementService#updateUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public void updateUser(String email, String name, String password, String newEmail, boolean isAdmin) throws UserNotFoundException, LastAdministorException
	{
		User user = userDao.findUserByEmail(email);
		if (user == null)
		{
			throw new UserNotFoundException(email);
		}
		
		if (!isAdmin && isLastAdmin(user)) {
			throw new LastAdministorException(user.getEmail());
		};
	}

	private boolean isLastAdmin(User user)
	{
		return user.isAdmin() && userDao.findAdmins().size() == 1;
	}

	/* (non-Javadoc)
	 * @see io.crowdcode.scrumr.service.UserManagementService#getUserList()
	 */
	@Override
	public List<User> getUserList()
	{
		return userDao.findAllUsers();
	}

}
