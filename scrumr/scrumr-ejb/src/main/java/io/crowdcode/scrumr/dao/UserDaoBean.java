package io.crowdcode.scrumr.dao;

import io.crowdcode.scrumr.model.User;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		try
		{
			TypedQuery<User> query = em.createNamedQuery(User.FIND_BY_EMAIL, User.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		} catch (NoResultException nre)
		{
			return null;
		}
	}

	@Override
	public List<User> findAdmins()
	{
		TypedQuery<User> query = em.createNamedQuery(User.FIND_ADMINS, User.class);
		return query.getResultList();
	}

	@Override
	public void remove(User user)
	{
		em.remove(user);
	}

	@Override
	public List<User> findAllUsers()
	{
		TypedQuery<User> query = em.createNamedQuery(User.FIND_ALL, User.class);
		return query.getResultList();
	}

}
