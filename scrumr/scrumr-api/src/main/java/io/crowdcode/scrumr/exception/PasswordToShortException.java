package io.crowdcode.scrumr.exception;


public class PasswordToShortException extends ApplicationException
{

	private static final long serialVersionUID = 1L;
	
	public PasswordToShortException(String password, int minLength)
	{
		super("Password "+password+" must be at least "+minLength+" characters long.");
	}

}
