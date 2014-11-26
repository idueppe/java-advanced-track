package io.crowdcode.scrumr.service;

import io.crowdcode.scrumr.exception.InvalidUserRoleException;
import io.crowdcode.scrumr.exception.ProjectNotFoundException;
import io.crowdcode.scrumr.exception.UserNotFoundException;
import io.crowdcode.scrumr.model.Project;

import java.util.List;

public interface ProjectManagementService
{

	public List<Project> findAllProjects();

	public String createProject(String name, 
			String description, 
			String productOwnerEmail, 
			String scrumMasterEmail,
			List<String> developerEmails) throws UserNotFoundException;
	
	public Project updateProject(
			String projectId,
			String name,
			String description,
			String productOwnerEmail,
			String scrumMasterEmail,
			List<String> developerEmails) throws UserNotFoundException, InvalidUserRoleException, ProjectNotFoundException;

}