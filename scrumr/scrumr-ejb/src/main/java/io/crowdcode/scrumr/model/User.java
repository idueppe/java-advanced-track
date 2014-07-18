package io.crowdcode.scrumr.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tbl_user")
@NamedQueries({
	@NamedQuery(name=User.FIND_BY_EMAIL, query="SELECT u FROM User u WHERE u.email = :email"),
	@NamedQuery(name=User.FIND_ADMINS, query="SELECT u FROM User u WHERE u.admin = true"),
	@NamedQuery(name=User.FIND_ALL, query="SELECT u FROM User u")
	
})
public class User extends AbstractEntity implements Identifiable
{
	public static final String FIND_BY_EMAIL = "User.findByEmail";
	public static final String FIND_ADMINS = "User.findAdmins";
	public static final String FIND_ALL = "User.findAll";
	
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
