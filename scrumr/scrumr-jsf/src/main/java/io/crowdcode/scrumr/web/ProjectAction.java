package io.crowdcode.scrumr.web;

import io.crowdcode.scrumr.controller.ProjectController;
import io.crowdcode.scrumr.dto.ProjectDto;
import io.crowdcode.scrumr.exception.UserNotFoundException;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ProjectAction implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Inject
	private ProjectController projectController;

	private ProjectDto currentProject = new ProjectDto();
		
	boolean editing; 
	
	public String add() {
		try
		{
			projectController.createProject(currentProject);
		} catch (UserNotFoundException e)
		{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		reset();
		return "";
	}

	public String cancel() {
		reset();
		System.out.println("cancel edit");
		return "";
	}
	
	public String update() {
		projectController.updateProject(currentProject);
		reset();
		return "";
	}

	private void reset()
	{
		currentProject = new ProjectDto();
		editing = false;
	}
	
	
	public String edit(ProjectDto selected) {
		currentProject = selected;
		editing = true;
		return "";
	}

	public ProjectDto getCurrentProject()
	{
		return currentProject;
	}

	public void setCurrentProject(ProjectDto currentProject)
	{
		this.currentProject = currentProject;
	}

	public List<ProjectDto> getProjects()
	{
		return projectController.getProjects();
	}

	public boolean isEditing()
	{
		return editing;
	}
	
	
	
	
}
