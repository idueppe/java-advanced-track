package io.crowdcode.scrumr.service;

import io.crowdcode.scrumr.exception.ApplicationException;

public class UnknownProjectException extends ApplicationException
{

	private static final long serialVersionUID = 1L;

	public UnknownProjectException(String projectId)
	{
		super("Could not find project with id: "+projectId);
	}


}
