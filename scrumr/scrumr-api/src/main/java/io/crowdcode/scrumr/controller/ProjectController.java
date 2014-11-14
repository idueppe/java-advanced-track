package io.crowdcode.scrumr.controller;

import java.util.List;

import io.crowdcode.scrumr.dto.ProjectDto;
import io.crowdcode.scrumr.exception.UserNotFoundException;

public interface ProjectController
{

	public String createProject(ProjectDto currentProject) throws UserNotFoundException;

	public void updateProject(ProjectDto currentProject);

	public List<ProjectDto> getProjects();

	public ProjectDto getProject(String projectId);

}
