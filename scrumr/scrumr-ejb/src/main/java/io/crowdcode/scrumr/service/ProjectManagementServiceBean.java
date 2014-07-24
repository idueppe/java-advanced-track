package io.crowdcode.scrumr.service;

import io.crowdcode.scrumr.dao.ProjectDao;
import io.crowdcode.scrumr.dao.UserDao;
import io.crowdcode.scrumr.exception.UserNotFoundException;
import io.crowdcode.scrumr.model.Project;
import io.crowdcode.scrumr.model.User;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Stateless
public class ProjectManagementServiceBean
{

	@Inject
	private ProjectDao projectDao;
	
	@Inject
	private UserDao userDao;
	
	public List<Project> findAllProjects()
	{
		return projectDao.findAllProjects();
	}

	public String createProject(String name, String description, String productOwnerEmail, String scrumMasterEmail,
			List<String> developerEmails) throws UserNotFoundException
	{
		Project project = new Project().withName(name).withDescription(description);
		
		project.setProductOwner(userByEmail(productOwnerEmail));
		project.setScrumMaster(userByEmail(scrumMasterEmail));
		
		for (String developerEmail : developerEmails) {
			project.getDevelopers().add(userByEmail(developerEmail));
		}
		
		projectDao.persist(project);
		
		return project.getId();
	}

	private User userByEmail(String email) throws UserNotFoundException
	{
		User user = userDao.findUserByEmail(email);
		if (user == null)
			throw new UserNotFoundException(email);
		return user;
	}

}
