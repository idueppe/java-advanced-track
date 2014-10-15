package io.crowdcode.scrumr.service;

import io.crowdcode.scrumr.dao.ProjectDao;
import io.crowdcode.scrumr.dao.UserDao;
import io.crowdcode.scrumr.exception.InvalidUserRoleException;
import io.crowdcode.scrumr.exception.ProjectNotFoundException;
import io.crowdcode.scrumr.exception.UserNotFoundException;
import io.crowdcode.scrumr.model.Project;
import io.crowdcode.scrumr.model.User;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

@Named
@Stateless
public class ProjectManagementServiceBean implements ProjectManagementService
{

	@Inject
	private ProjectDao projectDao;

	@Inject
	private UserDao userDao;

	@Override
	public List<Project> findAllProjects()
	{
		return projectDao.findAllProjects();
	}

	@Override
	public String createProject(String name, String description, String productOwnerEmail, String scrumMasterEmail,
			List<String> developerEmails) throws UserNotFoundException
	{
		Project project = new Project().withName(name).withDescription(description);

		project.setProductOwner(userByEmail(productOwnerEmail));
		project.setScrumMaster(userByEmail(scrumMasterEmail));

		addDevelopersToProject(developerEmails, project);

		projectDao.persist(project);

		return project.getId();
	}

	public void addDevelopersToProject(List<String> developerEmails, Project project) throws UserNotFoundException
	{
		for (String developerEmail : developerEmails)
		{
			project.getDevelopers().add(userByEmail(developerEmail));
		}
	}

	private User userByEmail(String email) throws UserNotFoundException
	{
		// FIXME
		if (StringUtils.isBlank(email))
			return null;

		User user = userDao.findUserByEmail(email);
		if (user == null)
		{
			throw new UserNotFoundException(email);
		}
		return user;
	}

	@Override
	public Project updateProject(String projectId, String name, String description, String productOwnerEmail, String scrumMasterEmail,
			List<String> developerEmails) throws UserNotFoundException, InvalidUserRoleException, ProjectNotFoundException
	{
		Project project = projectDao.getProject(projectId);
		if (project == null)
		{
			throw new ProjectNotFoundException("Project " + projectId + " with not found.");
		}
		
		project.setName(name);
		project.setDescription(description);
		project.setProductOwner(userByEmail(productOwnerEmail));
		project.setScrumMaster(userByEmail(scrumMasterEmail));
		project.getDevelopers().clear();
		addDevelopersToProject(developerEmails, project);
		
		return project;
	}
}
