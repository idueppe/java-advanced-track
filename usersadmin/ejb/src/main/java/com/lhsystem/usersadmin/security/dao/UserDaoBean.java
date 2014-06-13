package com.lhsystem.usersadmin.security.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.lhsystem.usersadmin.security.domain.User;

@Stateless
@Local(UserDao.class)
public class UserDaoBean implements UserDao {
	
	@PersistenceContext()
	private EntityManager em;
	
	@Override
	public List<User> findAll()
	{
		String qlString = "SELECT u FROM User u";
		TypedQuery<User> query = em.createQuery(qlString,User.class);
		return query.getResultList();
	}

	@Override
	public void createUser(User user) {
		em.persist(user);
	}
}
