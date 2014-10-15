package io.crowdcode.scrumr.dto;

public class TaskDto
{
	private String id;

	private String name;
	private String description;
	private String backlogItemId;
	private Integer estimation;
	private Integer remaining;
	private String state;
	private String assignedToEmail;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public TaskDto withId(String id)
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

	public TaskDto withName(String name)
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

	public TaskDto withDescription(String description)
	{
		setDescription(description);
		return this;
	}

	public String getBacklogItemId()
	{
		return backlogItemId;
	}

	public void setBacklogItemId(String backlogItemId)
	{
		this.backlogItemId = backlogItemId;
	}
	
	public TaskDto withBacklogItemId(String backlogItemId)
	{
		setBacklogItemId(backlogItemId);
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
	
	public TaskDto withEstimation(Integer estimation)
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
	
	public TaskDto withRemaining(Integer remaining)
	{
		setRemaining(remaining);
		return this;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}
	
	public TaskDto withState(String state)
	{
		setState(state);
		return this;
	}

	public String getAssignedToEmail()
	{
		return assignedToEmail;
	}

	public void setAssignedToEmail(String assignedToEmail)
	{
		this.assignedToEmail = assignedToEmail;
	}

	public TaskDto withAssignedToEmail(String assigendToEmail)
	{
		setAssignedToEmail(assigendToEmail);
		return this;
	}

}
