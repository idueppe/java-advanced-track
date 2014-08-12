package io.crowdcode.scrumr.dao;

import io.crowdcode.scrumr.model.Project;

import java.util.List;
import java.util.UUID;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named
@Stateless
@Local(ProjectDao.class)
public class ProjectDaoBean implements ProjectDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Project> findAllProjects()
	{
		TypedQuery<Project> query = em.createNamedQuery(Project.FIND_ALL, Project.class);
		return query.getResultList();
	}

	@Override
	public void persist(Project project)
	{
		project.setId(UUID.randomUUID().toString());
		em.persist(project);
	}

	@Override
	public Project getProject(String projectId)
	{
		return em.find(Project.class, projectId );
	}

}
