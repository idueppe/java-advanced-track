package io.crowdcode.scrumr.rest.resources;

import io.crowdcode.scrumr.controller.ProjectController;
import io.crowdcode.scrumr.dto.ProjectDto;
import io.crowdcode.scrumr.dto.ProjectReferenceDto;
import io.crowdcode.scrumr.exception.UserNotFoundException;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Named
@Stateless
@Path("/project")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectResource
{

	@Context
	private UriInfo uriInfo;

	@Inject
	private ProjectController projectController;

	@GET
	public Response getProjects()
	{
		List<ProjectDto> projects = projectController.getProjects();
		List<ProjectReferenceDto> result = new ArrayList<>();
		
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path("/{projectId}");
		
		for (ProjectDto project : projects)
		{
			result.add(new ProjectReferenceDto(
					project.getId(),
					project.getName(),
					uriBuilder.build(project.getId())
					));
		}
		
		
		return Response.ok().entity(result).build();
	}
	
	@POST
	public Response createProject(ProjectDto projectDto) throws UserNotFoundException 
	{
		String projectId = projectController.createProject(projectDto);
		URI location = uriInfo.getAbsolutePathBuilder().path(projectId).build();
		return Response.created(location).build();
	}
	
	@PUT
	@Path("/{projectId}")
	public Response updateProject(@PathParam("projectId") String projectId, ProjectDto projectDto)
	{
		projectDto.setId(projectId);
		projectController.updateProject(projectDto);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{projectId}")
	public Response getProject(@PathParam("projectId") String projectId) {
		return Response.ok().entity(projectController.getProject(projectId)).build();
	}

}
