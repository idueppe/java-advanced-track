package io.crowdcode.scrumr.exception;

public class InvalidUserRoleException extends ApplicationException
{

	private static final long serialVersionUID = 1L;

	public InvalidUserRoleException()
	{
		super();
	}

	public InvalidUserRoleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidUserRoleException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public InvalidUserRoleException(String message)
	{
		super(message);
	}

	public InvalidUserRoleException(Throwable cause)
	{
		super(cause);
	}
	
}
