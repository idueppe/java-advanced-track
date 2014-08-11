package io.crowdcode.scrumr.exception;

public class DescriptionToShortException extends ApplicationException
{
	private static final long serialVersionUID = 1L;

	public DescriptionToShortException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public DescriptionToShortException(String message)
	{
		super(message);
	}


}
