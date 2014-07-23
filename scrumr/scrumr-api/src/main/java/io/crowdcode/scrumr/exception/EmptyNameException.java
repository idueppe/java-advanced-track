package io.crowdcode.scrumr.exception;


public class EmptyNameException extends ApplicationException
{

	private static final long serialVersionUID = 1L;
	
	public EmptyNameException(String name) {
		super("Name must not be empty or blank [name="+name+"].");
	}

}
