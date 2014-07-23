package io.crowdcode.scrumr.exception;

public class UserNotFoundException extends ApplicationException
{

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String email)
	{
		super("User with email " + email + " not exist.");
	}

}
