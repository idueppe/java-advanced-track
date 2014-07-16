package io.crowdcode.scrumr.dao;

import io.crowdcode.scrumr.model.User;


public interface UserDao
{
	public void persist(User user);
}
