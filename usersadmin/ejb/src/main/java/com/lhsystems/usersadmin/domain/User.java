package com.lhsystems.usersadmin.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "tbl_user")
@NamedQueries({ 
		@NamedQuery(name = User.FIND_BY_USERNAME, query = "SELECT u FROM User u WHERE u.username = :username"),
		@NamedQuery(name = User.FIND_BY_GROUPNAME, query = "SELECT u FROM Group g JOIN g.users u WHERE u.email like :emailpattern"),
		@NamedQuery(name = User.FIND_ALL, query = "SELECT u FROM User u")})

public class User
{

	public static final String FIND_BY_USERNAME = "User.findByUsername";
	public static final String FIND_BY_GROUPNAME = "User.findByGroupname";
	public static final String FIND_ALL = "User.findAll";

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String username;

	private String password;
	@Column(unique = true)
	private String email;

//	@Enumerated(EnumType.STRING)
//	@Convert(converter=RoleAttributeConverter.class)
	private Role role = Role.USER;

	@Column(nullable = false)
	private boolean active;

	@Temporal(TemporalType.DATE)
	private Date lastPasswordChanged;

	@Temporal(TemporalType.DATE)
	private Date lastLogin;

	@Version
	private Long version;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
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

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPassword()
	{
		return password;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getEmail()
	{
		return email;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

	public Role getRole()
	{
		return role;
	}

	public boolean isActive()
	{
		return active;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}

	public Date getLastPasswordChanged()
	{
		return lastPasswordChanged;
	}

	public void setLastPasswordChanged(Date lastPasswordChanged)
	{
		this.lastPasswordChanged = lastPasswordChanged;
	}

	public Date getLastLogin()
	{
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin)
	{
		this.lastLogin = lastLogin;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

}