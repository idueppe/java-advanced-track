package io.crowdcode.scrumr.dto;

import java.util.ArrayList;
import java.util.List;

public class ProjectDto
{
	
	private String id;

	private String name;
	
	private String description;
	
	private UserDto productOwner;
	
	private UserDto scrumMaster;

	private List<UserDto> developers = new ArrayList<>();
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProjectDto withName(String name) {
		setName(name);
		return this;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public ProjectDto withDescription(String description)
	{
		setDescription(description);
		return this;
	}

	public UserDto getProductOwner()
	{
		return productOwner;
	}

	public void setProductOwner(UserDto productOwner)
	{
		this.productOwner = productOwner;
	}
	
	public ProjectDto withProductOwner(UserDto productOwner)
	{
		setProductOwner(productOwner);
		return this;
	}

	public UserDto getScrumMaster()
	{
		return scrumMaster;
	}

	public void setScrumMaster(UserDto scrumMaster)
	{
		this.scrumMaster = scrumMaster;
	}
	
	public ProjectDto withScrumMaster(UserDto scrumMaster)
	{
		setScrumMaster(scrumMaster);
		return this;
	}

	public List<UserDto> getDevelopers()
	{
		return developers;
	}

	public void setDevelopers(List<UserDto> developers)
	{
		this.developers = developers;
	}
	
	public ProjectDto addDeveloper(UserDto developer) 
	{
		getDevelopers().add(developer);
		return this;
	}

	@Override
	public String toString()
	{
		return "Project [name=" + name + ", description=" + description + ", productOwner=" + productOwner + ", scrumMaster=" + scrumMaster
				+ ", developers=" + developers + "]";
	}

	
}
