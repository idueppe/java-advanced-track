package io.crowdcode.scrumr.exception;


public class InvalidUsernameException extends ApplicationException
{

	private static final long serialVersionUID = 1L;
	
	public InvalidUsernameException(String username)
	{
		super("Username "+username+" is not valid. It must be unique and 5 characters long.");
	}

}
