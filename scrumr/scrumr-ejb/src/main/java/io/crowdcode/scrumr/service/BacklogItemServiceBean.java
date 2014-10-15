package io.crowdcode.scrumr.service;

import io.crowdcode.scrumr.dao.ProjectDao;
import io.crowdcode.scrumr.model.BacklogItem;
import io.crowdcode.scrumr.model.Project;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Stateless
public class BacklogItemServiceBean
{
	@Inject
	private ProjectDao projectDao; 

	public List<BacklogItem> getBacklogItems(String projectId) throws UnknownProjectException
	{
		return loadOrThrow(projectId).getBacklogItems();
	}

	public void addBacklogItem(String projectId, String name, String description, Integer estimation, Integer priority) throws UnknownProjectException
	{
		loadOrThrow(projectId)
			.withBacklogItems(
				new BacklogItem()
					.withName(name)
					.withDescription(description)
					.withEstimation(estimation)
					.withPriority(priority));
	}

	private Project loadOrThrow(String projectId) throws UnknownProjectException
	{
		Project project = projectDao.getProject(projectId);
		if (project == null) 
		{
			throw new UnknownProjectException(projectId);
		}
		return project;
	}
}

