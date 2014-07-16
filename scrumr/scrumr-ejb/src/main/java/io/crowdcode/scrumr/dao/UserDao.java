package io.crowdcode.scrumr.dao;

import io.crowdcode.scrumr.model.User;

import java.util.List;


public interface UserDao
{
	public void persist(User user);

	/**
	 * 
	 * @param username of user
	 * @return null if not existing or the user entity
	 */
	public User findUserByUsername(String username);

	/**
	 * @param email
	 * @return null if not existing or the user entity
	 */
	public User findUserByEmail(String email);

	public List<User> findAll();

}
