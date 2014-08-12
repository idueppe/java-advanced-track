package io.crowdcode.scrumr.dao;

import io.crowdcode.scrumr.model.Project;

import java.util.List;

public interface ProjectDao
{

	public List<Project> findAllProjects();

	public void persist(Project project);

	public Project getProject(String projectId);

}
