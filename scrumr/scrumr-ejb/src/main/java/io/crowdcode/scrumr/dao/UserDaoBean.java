package io.crowdcode.scrumr.dao;

import io.crowdcode.scrumr.model.User;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDaoBean implements UserDao
{

	@PersistenceContext()
	private EntityManager em;
	
	@Override
	public void persist(User user)
	{
		user.setId(UUID.randomUUID().toString());
		em.persist(user);
	}

	@Override
	public User findUserByEmail(String email)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAdmins()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(User admin)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAllUsers()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
