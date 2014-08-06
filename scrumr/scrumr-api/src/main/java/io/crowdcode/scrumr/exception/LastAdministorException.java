package io.crowdcode.scrumr.exception;


public class LastAdministorException extends ApplicationException
{

	private static final long serialVersionUID = 1L;

	public LastAdministorException(String email)
	{
		super("User with email "+email+" is the last admin and must not removed");
	}

}
