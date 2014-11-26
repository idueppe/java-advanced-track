package io.crowdcode.scrumr.dao;

import io.crowdcode.scrumr.model.User;

import java.util.List;

public interface UserDao
{

	public void persist(User user);

	/**
	 * @return user instance of null if user not exists
	 */
	public User findUserByEmail(String email);

	public List<User> findAdmins();

	public void remove(User admin);

	public List<User> findAllUsers();

	public User findUser(String userId);

}
