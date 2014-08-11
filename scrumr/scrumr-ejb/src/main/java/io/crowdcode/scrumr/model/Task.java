package io.crowdcode.scrumr.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_task")
public class Task extends AbstractEntity 
{

	private String name;
	private String description;
	private Integer estimation;
	private Integer remaining;
	
	@Enumerated(EnumType.STRING)
	private TaskState state;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public Task withName(String name)
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
	
	public Task withDescription(String description)
	{
		setDescription(description);
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
	
	public Task withEstimation(Integer estimation)
	{
		setEstimation(estimation);
		return this;
	}

	public Integer getRemaining()
	{
		return remaining;
	}

	public void setRemaining(Integer remaining)
	{
		this.remaining = remaining;
	}
	
	public Task withRemaining(Integer remaining)
	{
		setRemaining(remaining);
		return this;
	}

	public TaskState getState()
	{
		return state;
	}

	public void setState(TaskState state)
	{
		this.state = state;
	}

	public Task withState(TaskState state)
	{
		setState(state);
		return this;
	}

}
