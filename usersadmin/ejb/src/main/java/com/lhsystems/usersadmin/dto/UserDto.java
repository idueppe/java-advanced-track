package com.lhsystems.usersadmin.dto;

public class UserDto {

	private String username;
	private String email;
	private String role;

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

	public String getRole() {
		return role;
	}
	
	public void setRole(String role)
	{
		this.role = role;
	}

	public UserDto withUsername(String role) {
		this.role = role;
		return this;
	}

	public UserDto withEmail(String email) {
		this.email = email;
		return this;
	}

	public UserDto withRole(String role) {
		this.role = role;
		return this;
	}


}
