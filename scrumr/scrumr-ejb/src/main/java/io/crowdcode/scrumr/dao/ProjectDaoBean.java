package io.crowdcode.scrumr.dao;

import io.crowdcode.scrumr.model.Project;
import io.crowdcode.scrumr.service.ProjectService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
@Stateless
@Local(ProjectService.class)
public class ProjectDaoBean {

	@PersistenceContext
	private EntityManager em;
	
	public Long persistProject(Project project)
	{
		em.persist(project);
		return project.getId();
	}
	
}
