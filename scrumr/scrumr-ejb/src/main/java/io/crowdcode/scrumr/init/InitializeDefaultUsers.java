package io.crowdcode.scrumr.init;

import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.PasswordToShortException;
import io.crowdcode.scrumr.exception.SystemException;
import io.crowdcode.scrumr.service.UserManagementService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class InitializeDefaultUsers
{

	@Inject
	private UserManagementService userService;

	@PostConstruct
	public void initialize()
	{
		try
		{
			userService.registerUser("ingo.dueppe@crowdcode.de", "Ingo Düppe", "masterkey", true);
			userService.registerUser("marcus.noerder-tuitje@crowdcode.de", "Marcus Nörder-Tuitje", "masterkey", true);
		} catch (InvalidEmailException | EmailAlreadyExistException | EmptyNameException | PasswordToShortException e)
		{
			throw new SystemException("Cannot initialize default users.", e);
		}

	}

}
