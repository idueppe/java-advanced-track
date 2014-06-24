package com.lhsystems.usersadmin.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "tbl_group")
@NamedEntityGraphs(value=
	@NamedEntityGraph(
			name="groupWithUsers",
			includeAllAttributes=true,
			attributeNodes={@NamedAttributeNode("users")}
			))
public class Group
{

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany()
	private List<User> users = new LinkedList<>();

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

	public List<User> getUsers()
	{
		return users;
	}

	public void setUsers(List<User> users)
	{
		this.users = users;
	}

}