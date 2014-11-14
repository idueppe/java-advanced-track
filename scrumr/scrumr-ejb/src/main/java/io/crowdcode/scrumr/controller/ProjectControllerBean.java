package io.crowdcode.scrumr.controller;

import io.crowdcode.scrumr.converters.ProjectDtoConverter;
import io.crowdcode.scrumr.dto.ProjectDto;
import io.crowdcode.scrumr.exception.UserNotFoundException;
import io.crowdcode.scrumr.service.ProjectManagementService;
import io.crowdcode.scrumr.service.ProjectService;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Stateless
@Local(ProjectController.class)
public class ProjectControllerBean implements ProjectController
{

	@Inject
	private ProjectManagementService projectManagementService;
	
	@Inject
	private ProjectService projectService;
	
	@Inject
	private ProjectDtoConverter converter;
	
	@Override
	public String createProject(ProjectDto project) throws UserNotFoundException
	{
		return projectManagementService.createProject(project.getName(), 
				project.getDescription(), 
				project.getProductOwnerMail(), 
				project.getScrumMasterMail(), 
				project.getDeveloperMails());
	}

	@Override
	public void updateProject(ProjectDto currentProject)
	{
	}

	@Override
	public List<ProjectDto> getProjects()
	{
		return converter.convert(projectManagementService.findAllProjects());
	}

	public List<ProjectDto> findProjectsByEmail(String email)
	{
		return converter.convert(projectService.getProjectsByEmail(email));
	}

}
