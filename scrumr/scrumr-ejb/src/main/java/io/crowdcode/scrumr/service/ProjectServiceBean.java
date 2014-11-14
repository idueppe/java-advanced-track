package io.crowdcode.scrumr.service;

import io.crowdcode.scrumr.dao.ProjectDao;
import io.crowdcode.scrumr.model.Project;
import io.crowdcode.scrumr.model.Sprint;
import io.crowdcode.scrumr.model.User;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import org.apache.commons.lang3.StringUtils;


@Stateless
@Local(ProjectService.class)
public class ProjectServiceBean implements ProjectService{

	@EJB
	private ProjectDao projectDao;
	
	@Override
	public Sprint getSprintById(String sprintId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getProjectsByEmail(String email)
	{
		List<Project> projects = new ArrayList<>();
		for (Project project : projectDao.findAllProjects())
		{
			if (isProductOwnerOfProject(project, email) || isScrumMaster(email, project) || isDeveloper(project, email))
			{
				projects.add(project);
			}

		}
		return projects;
	}

	public boolean isDeveloper(Project project, String email)
	{
		// FIXME make pretty
		if (project == null)
			return false;
		
		boolean found = false;
		for (User developer : project.getDevelopers()) {
			if (StringUtils.equalsIgnoreCase(developer.getEmail(), email))
			{
				found = true;
				break;
			}
		}
		return found;
	}

	public boolean isScrumMaster(String email, Project project)
	{
		return project != null && project.getScrumMaster() != null && StringUtils.equalsIgnoreCase(project.getScrumMaster().getEmail(), email);
	}

	public boolean isProductOwnerOfProject(Project project, String email)
	{
		return project != null && project.getProductOwner() != null && StringUtils.equalsIgnoreCase(project.getProductOwner().getEmail(), email);
	}

	@Override
	public Project getProject(String projectId)
	{
		return projectDao.getProject(projectId);
	}

}
