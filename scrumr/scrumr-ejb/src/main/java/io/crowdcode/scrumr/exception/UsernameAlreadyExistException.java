package io.crowdcode.scrumr.exception;


public class UsernameAlreadyExistException extends ApplicationException
{

	private static final long serialVersionUID = 1L;
	
	public UsernameAlreadyExistException(String username) {
		super("Username "+username+" is already used.");
	}

}
