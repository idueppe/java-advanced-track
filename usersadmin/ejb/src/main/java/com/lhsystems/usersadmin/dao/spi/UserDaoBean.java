package com.lhsystems.usersadmin.dao.spi;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.lhsystems.usersadmin.dao.UserDao;
import com.lhsystems.usersadmin.domain.User;

@Stateless
@Local(UserDao.class)
public class UserDaoBean implements UserDao
{

	@PersistenceContext(unitName="usersadmin")
	private EntityManager em;

	@Override
	public void create(User user)
	{
		em.persist(user);
	}

	@Override
	public User find(Long userId)
	{
		return em.find(User.class, userId);
	}

	@Override
	public User findByUsername(String username)
	{
		try {
			TypedQuery<User> query = em.createNamedQuery(User.FIND_BY_USERNAME, User.class);
			query.setParameter("username", username);
			return query.getSingleResult();
		} catch (NoResultException  e)
		{
			return null;
		}
	}

	@Override
	public User update(User user)
	{
		return em.merge(user);
	}

	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery(User.FIND_ALL, User.class);
		return query.getResultList();
	}

}
