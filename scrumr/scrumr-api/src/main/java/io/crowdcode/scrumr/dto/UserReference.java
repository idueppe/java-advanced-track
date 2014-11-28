package io.crowdcode.scrumr.dto;

public class UserReference
{

	private String email;
	private String userId;
	private String link;
	
	public UserReference() {}
	
	public UserReference(String userId, String email, String link)
	{
		super();
		this.userId = userId;
		this.email = email;
		this.link = link;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

}
