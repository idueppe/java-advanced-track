package io.crowdcode.scrumr.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Identifiable
{
	@Id
	private String id;
	private String email;
	private String password;
	private String fullname;
	private boolean admin;

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public User withEmail(String email)
	{
		setEmail(email);
		return this;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public User withPassword(String password)
	{
		setPassword(password);
		return this;
	}

	public String getFullname()
	{
		return fullname;
	}

	public void setFullname(String fullname)
	{
		this.fullname = fullname;
	}

	public User withFullname(String fullname)
	{
		setFullname(fullname);
		return this;
	}
	
	public boolean isAdmin()
	{
		return admin;
	}

	public void setAdmin(boolean admin)
	{
		this.admin = admin;
	}
	
	public User withAdmin(boolean isAdmin)
	{
		setAdmin(isAdmin);
		return this;
	}
	
}
