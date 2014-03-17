package com.lhsystems.usersadmin.doa.spi;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.lhsystems.usersadmin.doa.UserDao;
import com.lhsystems.usersadmin.domain.User;

@Stateless
@Local(UserDao.class)
public class UserDaoBean implements UserDao
{

	@PersistenceContext
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
		TypedQuery<User> query = em.createNamedQuery(User.FIND_BY_USERNAME, User.class);
		query.setParameter("username", username);
		return query.getSingleResult();
	}

	@Override
	public User update(User user)
	{
		return em.merge(user);
	}

}
