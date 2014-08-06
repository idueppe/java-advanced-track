package com.lhsystem.usersadmin.security.dto;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;

@Named()
@RequestScoped
public class UserDto {

	private String username;
	private String email;
	private String roleName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public UserDto withEmail(String email) {
		setEmail(email);
		return this;
	}

	public UserDto withRoleName(String roleName)
	{
		setRoleName(roleName);
		return this;
	}
	
	public UserDto withUsername(String username)
	{
		setUsername(username);
		return this;
	}
	
}
