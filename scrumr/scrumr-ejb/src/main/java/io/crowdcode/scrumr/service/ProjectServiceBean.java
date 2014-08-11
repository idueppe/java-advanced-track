package io.crowdcode.scrumr.service;

import io.crowdcode.scrumr.model.Sprint;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;


@Stateless
@Local(ProjectService.class)
@Remote(ProjectServiceRemote.class)
public class ProjectServiceBean implements ProjectServiceRemote{

	public Sprint getSprintById(String sprintId)
	{
		// TODO Auto-generated method stub
		return null;
	}


}
