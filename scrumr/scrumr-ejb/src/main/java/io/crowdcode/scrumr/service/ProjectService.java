package io.crowdcode.scrumr.service;

import io.crowdcode.scrumr.exception.UnknownSprintIdException;
import io.crowdcode.scrumr.model.Project;
import io.crowdcode.scrumr.model.Sprint;

import java.util.List;


public interface ProjectService {

	public Sprint getSprintById(String sprintId) throws UnknownSprintIdException;
	
	public List<Project> getProjectsByEmail(String email);

	public Project getProject(String projectId);

}