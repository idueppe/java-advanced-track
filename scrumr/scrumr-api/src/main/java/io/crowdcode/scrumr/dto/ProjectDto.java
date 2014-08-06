package io.crowdcode.scrumr.dto;

import java.util.ArrayList;
import java.util.List;

public class ProjectDto
{

	private String id;

	private String name;

	private String description;

	private String productOwnerMail;

	private String scrumMasterMail;

	private List<String> developerMails = new ArrayList<>();

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getProductOwnerMail()
	{
		return productOwnerMail;
	}

	public void setProductOwnerMail(String productOwner)
	{
		this.productOwnerMail = productOwner;
	}

	public String getScrumMasterMail()
	{
		return scrumMasterMail;
	}

	public void setScrumMasterMail(String scrumMaster)
	{
		this.scrumMasterMail = scrumMaster;
	}

	public List<String> getDeveloperMails()
	{
		return developerMails;
	}

	public void setDeveloperMails(List<String> developerMails)
	{
		this.developerMails = developerMails;
	}

}
