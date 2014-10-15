package io.crowdcode.scrumr.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name=Project.FIND_ALL, query="SELECT p FROM Project p")
})
public class Project extends AbstractEntity {
	
	public static final String FIND_ALL = "Project.findAll";

	@Column(unique=true)
	private String name;
	
	private String description;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private User productOwner;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private User scrumMaster;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<User> developers = new ArrayList<>();

	@OneToMany(mappedBy="project", cascade=CascadeType.ALL)
	private List<BacklogItem> backlogItems = new ArrayList<>();
	
	@OneToMany(mappedBy="project", cascade=CascadeType.ALL)
	private List<Sprint> sprints = new ArrayList<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project withName(String name) {
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
	
	public Project withDescription(String description)
	{
		setDescription(description);
		return this;
	}

	public User getProductOwner()
	{
		return productOwner;
	}

	public void setProductOwner(User productOwner)
	{
		this.productOwner = productOwner;
	}
	
	public Project withProductOwner(User productOwner)
	{
		setProductOwner(productOwner);
		return this;
	}

	public User getScrumMaster()
	{
		return scrumMaster;
	}

	public void setScrumMaster(User scrumMaster)
	{
		this.scrumMaster = scrumMaster;
	}
	
	public Project withScrumMaster(User scrumMaster)
	{
		setScrumMaster(scrumMaster);
		return this;
	}

	public List<User> getDevelopers()
	{
		return developers;
	}

	public void setDevelopers(List<User> developers)
	{
		this.developers = developers;
	}
	
	public Project withDevelopers(User... users)
	{
		developers.addAll(Arrays.asList(users));
		return this;
	}
	
	public Project addDeveloper(User developer) 
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

	public List<BacklogItem> getBacklogItems()
	{
		return backlogItems;
	}

	public void setBacklogItems(List<BacklogItem> backlogItems)
	{
		this.backlogItems = backlogItems;
	}
	
	public Project withBacklogItems(BacklogItem... items)
	{
		backlogItems.addAll(Arrays.asList(items));
		return this;
	}

	public List<Sprint> getSprints()
	{
		return sprints;
	}

	public void setSprints(List<Sprint> sprints)
	{
		this.sprints = sprints;
	}

	public Project withSprint(Sprint... items)
	{
		sprints.addAll(Arrays.asList(items));
		return this;
	}
	
}