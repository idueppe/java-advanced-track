package io.crowdcode.scrumr.exception;

public class UserNotFoundException extends ApplicationException
{

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(String id) {
		super("User with id "+id+" not exist.");
	}

}
