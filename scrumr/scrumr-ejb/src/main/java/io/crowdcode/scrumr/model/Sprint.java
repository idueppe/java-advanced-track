package io.crowdcode.scrumr.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_spring")
public class Sprint extends AbstractEntity
{

	@ManyToOne
	private Project project;
	
	private String name;
	private Integer capacity;
	
	private Date startDate;
	private Date endDate;
	
	@OneToMany
	private List<BacklogItem> backlogItems = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Task> tasks = new ArrayList<>();
	
	
	public void addTask(Task task) {
		tasks.add(task);
	}

	public Project getProject()
	{
		return project;
	}

	public void setProject(Project project)
	{
		this.project = project;
	}
	
	public Sprint withProject(Project project)
	{
		setProject(project);
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
	
	public Sprint withName(String name)
	{
		setName(name);
		return this;
	}

	public Integer getCapacity()
	{
		return capacity;
	}

	public void setCapacity(Integer capacity)
	{
		this.capacity = capacity;
	}
	
	public Sprint withCapacity(Integer capacity)
	{
		setCapacity(capacity);
		return this;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}
	
	public Sprint withStartDate(Date startDate)
	{
		setStartDate(startDate);
		return this;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}
	
	public Sprint withEndDate(Date endDate)
	{
		setEndDate(endDate);
		return this;
	}

	public List<BacklogItem> getBacklogItems()
	{
		return backlogItems;
	}

	public void setBacklogItems(List<BacklogItem> backlogItems)
	{
		this.backlogItems = backlogItems;
	}
	
	public Sprint withBacklogItems(BacklogItem... items)
	{
		backlogItems.addAll(Arrays.asList(items));
		return this;
	}

	public List<Task> getTasks()
	{
		return tasks;
	}

	public void setTasks(List<Task> tasks)
	{
		this.tasks = tasks;
	}
	
	public Sprint withTasks(Task... tasks)
	{
		this.tasks.addAll(Arrays.asList(tasks));
		return this;
	}
	
}
