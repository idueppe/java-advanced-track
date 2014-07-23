package io.crowdcode.scrumr.model;

import java.util.ArrayList;
import java.util.List;

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
	
	@ManyToOne
	private User productOwner;
	
	@ManyToOne
	private User scrumMaster;
	
	@OneToMany
	private List<User> developers = new ArrayList<>();
	
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

	
	
}