package io.crowdcode.scrumr.service;

import io.crowdcode.scrumr.dao.ProjectDaoBean;
import io.crowdcode.scrumr.model.Project;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;


@Stateless
@Local(ProjectService.class)
@Remote(ProjectServiceRemote.class)
public class ProjectServiceBean implements ProjectServiceRemote{

	@Inject
	private ProjectDaoBean projectDao;
	
	@Override
	public Long createProjectWithId(String title) {
		Project project = new Project().withTitle(title);
		projectDao.persistProject(project);
		return project.getId();
	}

}
