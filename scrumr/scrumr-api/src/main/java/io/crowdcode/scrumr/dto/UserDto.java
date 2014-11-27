package io.crowdcode.scrumr.dto;

import java.io.Serializable;

public class UserDto implements Serializable
{

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String email;
	private String password;
	private String fullname;
	private boolean admin;

	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public void setLogStatement(String logStmt)
	{
		System.out.println(">>>>>>>>>>>>>>>>>>>>"+logStmt);
	}
	
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public UserDto withEmail(String email)
	{
		setEmail(email);
		return this;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public UserDto withPassword(String password)
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

	public UserDto withFullname(String fullname)
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
	
	public UserDto withAdmin(boolean isAdmin)
	{
		setAdmin(isAdmin);
		return this;
	}

	@Override
	public String toString()
	{
		return "UserDto [id=" + id + ", email=" + email + ", password=" + password + ", fullname=" + fullname + ", admin=" + admin + "]";
	}

}
