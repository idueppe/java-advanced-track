package com.lhsystems.usersadmin.doa;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.lhsystems.usersadmin.domain.Role;
import com.lhsystems.usersadmin.domain.User;

@Stateless
@Local(UserDao.class)
public class UserDaoBean implements UserDao {

	@PersistenceContext()
	private EntityManager em;
	
	@Override
	public void createUser(User user) {
		em.persist(user);
	}

	@Override
	public List<User> findAll() {
		String qlString = "SELECT u FROM User u";
		TypedQuery<User> query = em.createQuery(qlString, User.class);
		return query.getResultList();
	}

	@Override
	public List<User> findAllByRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

}
