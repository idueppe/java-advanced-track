package io.crowdcode.scrumr.exception;

public class UnknownSprintIdException extends ApplicationException
{
	private static final long serialVersionUID = 1L;

	public UnknownSprintIdException(String message)
	{
		super(message);
	}
}
