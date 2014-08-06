package io.crowdcode.scrumr.controller;

import io.crowdcode.scrumr.converters.ProjectDtoConverter;
import io.crowdcode.scrumr.dto.ProjectDto;
import io.crowdcode.scrumr.exception.UserNotFoundException;
import io.crowdcode.scrumr.service.ProjectManagementServiceBean;

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
	private ProjectManagementServiceBean projectService;
	
	@Inject
	private ProjectDtoConverter converter;
	
	@Override
	public void createProject(ProjectDto project) throws UserNotFoundException
	{
		projectService.createProject(project.getName(), 
				project.getDescription(), 
				project.getProductOwnerMail(), 
				project.getScrumMasterMail(), 
				project.getDeveloperMails());
	}

	@Override
	public void updateProject(ProjectDto currentProject)
	{
		// FIXME implement update method.		
	}

	@Override
	public List<ProjectDto> getProjects()
	{
		return converter.convert(projectService.findAllProjects());
	}

}
