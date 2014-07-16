package io.crowdcode.scrumr.model;

public class User implements Identifiable
{
	private String id;
	private String username;
	private String email;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public User withUsername(String username)
	{
		setUsername(username);
		return this;
	}

	public User withEmail(String email)
	{
		setEmail(email);
		return this;
	}
	
}
