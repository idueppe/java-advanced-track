package io.crowdcode.scrumr.exception;

public class ProjectNotFoundException extends ApplicationException
{

	private static final long serialVersionUID = 1L;

	public ProjectNotFoundException()
	{
	}

	public ProjectNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProjectNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ProjectNotFoundException(String message)
	{
		super(message);
	}

	public ProjectNotFoundException(Throwable cause)
	{
		super(cause);
	}

}
