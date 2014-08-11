package io.crowdcode.scrumr.exception;

public class InvalidBacklogItemException extends ApplicationException
{

	private static final long serialVersionUID = 1L;

	public InvalidBacklogItemException(String backlogItemId)
	{
		super("Could not find the backlog item with id "+backlogItemId+" in Project.");
	}

}
