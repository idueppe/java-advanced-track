package com.lhsystem.usersadmin.security.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name="tbl_user")
public class User {
	
	@Id
	@GeneratedValue()
	private Long id;
	
	@Version
	private Long version;

	@Column(name="uname", nullable=false, unique=true)
	private String username;
	@Column(nullable=false)
	private String password;
	private String fullname;
	private String email;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Address address;

	private boolean active;

	@Temporal(TemporalType.DATE)
	private Date lastPasswordChanged;
	
	@Temporal(TemporalType.DATE)
	private Date lastLogin;

	@Enumerated(EnumType.STRING)
	private Role role;
	
	public User() {
		role = Role.USER;
		lastPasswordChanged = new Date();
		lastLogin = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (StringUtils.isNotBlank(password)
				&& !StringUtils.equals(this.password, password))
		{
			lastPasswordChanged = new Date();
			this.password = password;
		}
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getLastPasswordChanged() {
		return lastPasswordChanged;
	}

	public void setLastPasswordChanged(Date lastPasswordChanged) {
		this.lastPasswordChanged = lastPasswordChanged;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", version=" + version + ", username="
				+ username + ", password=" + password + ", fullname="
				+ fullname + ", email=" + email + ", address=" + address
				+ ", active=" + active + ", lastPasswordChanged="
				+ lastPasswordChanged + ", lastLogin=" + lastLogin + ", role="
				+ role + "]";
	}

}
