package io.crowdcode.scrumr.dao;

import io.crowdcode.scrumr.model.Project;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class ProjectDaoBean implements ProjectDao {

	@Override
	public List<Project> findAllProjects()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persist(Project project)
	{
		// TODO Auto-generated method stub
		
	}

}
