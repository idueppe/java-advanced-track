package io.crowdcode.scrumr.service;

import io.crowdcode.scrumr.exception.ApplicationException;

public class EmailAlreadyExistException extends ApplicationException
{

	private static final long serialVersionUID = 1L;
	
	public EmailAlreadyExistException(String email)
	{
		super("Email "+email+" already registered.");
	}
	

}
