package io.crowdcode.scrumr.exception;


public class ProjectNameAlreadyExistException extends ApplicationException
{

	private static final long serialVersionUID = 1L;
	
	public ProjectNameAlreadyExistException(String name) {
		super("Projectname "+name+" is exists already.");
	}

}
