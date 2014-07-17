package io.crowdcode.scrumr.exception;


public class InvalidEmailException extends ApplicationException
{

	private static final long serialVersionUID = 1L;

	public InvalidEmailException(String email)
	{
		super("Email " + email + " is not valid!");
	}

}
