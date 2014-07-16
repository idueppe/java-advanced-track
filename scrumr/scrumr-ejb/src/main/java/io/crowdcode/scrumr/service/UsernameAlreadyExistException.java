package io.crowdcode.scrumr.service;

import io.crowdcode.scrumr.exception.ApplicationException;

public class UsernameAlreadyExistException extends ApplicationException
{

	private static final long serialVersionUID = 1L;
	
	public UsernameAlreadyExistException(String username) {
		super("Username "+username+" is already used.");
	}

}
