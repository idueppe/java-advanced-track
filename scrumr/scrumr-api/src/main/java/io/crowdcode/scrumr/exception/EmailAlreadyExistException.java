package io.crowdcode.scrumr.exception;


public class EmailAlreadyExistException extends ApplicationException
{

	private static final long serialVersionUID = 1L;
	
	public EmailAlreadyExistException(String email)
	{
		super("Email "+email+" already registered.");
	}
	

}
