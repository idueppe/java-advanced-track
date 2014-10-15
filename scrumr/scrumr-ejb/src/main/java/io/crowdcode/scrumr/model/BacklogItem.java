package io.crowdcode.scrumr.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_backlogitem")
public class BacklogItem extends AbstractEntity
{
	
	@ManyToOne
	private Project project;
	
	private String name;
	private String description;
	private Integer priority;
	private Integer estimation;
	
	
	public BacklogItem withId(String id)
	{
		setId(id);
		return this;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public BacklogItem withName(String name)
	{
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
	
	public BacklogItem withDescription(String description)
	{
		setDescription(description);
		return this;
	}
	
	public Integer getPriority()
	{
		return priority;
	}
	
	public void setPriority(Integer priority)
	{
		this.priority = priority;
	}
	
	public BacklogItem withPriority(Integer priority)
	{
		setPriority(priority);
		return this;
	}
	
	public Integer getEstimation()
	{
		return estimation;
	}
	
	public void setEstimation(Integer estimation)
	{
		this.estimation = estimation;
	}
	
	public BacklogItem withEstimation(Integer estimation)
	{
		setEstimation(estimation);
		return this;
	}

	public Project getProject()
	{
		return project;
	}

	public void setProject(Project project)
	{
		this.project = project;
	}
	
}
