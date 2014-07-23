package io.crowdcode.scrumr.web;

import io.crowdcode.scrumr.model.Project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ProjectAction implements Serializable
{

	private static final long serialVersionUID = 1L;

	private List<Project> projects = new ArrayList<>();

	public void add(String name)
	{
		projects.add(new Project().withName(name));
	}

	public int getProjects()
	{
		return projects.size();
	}

}
