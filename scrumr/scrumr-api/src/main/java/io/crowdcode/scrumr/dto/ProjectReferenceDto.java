package io.crowdcode.scrumr.dto;

import java.net.URI;

public class ProjectReferenceDto
{

	private String projectId;
	private String name;
	private URI link;
	
	public ProjectReferenceDto() {}
	
	public ProjectReferenceDto(String projectId, String name, URI link)
	{
		this.projectId = projectId;
		this.name = name;
		this.link = link;
	}

	public String getProjectId()
	{
		return projectId;
	}
	
	public void setProjectId(String projectId)
	{
		this.projectId = projectId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public URI getLink()
	{
		return link;
	}

	public void setLink(URI link)
	{
		this.link = link;
	}

}
