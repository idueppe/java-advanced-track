package com.lhsystems.usersadmin.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.lhsystems.usersadmin.domain.Address;
import com.lhsystems.usersadmin.domain.Role;
import com.lhsystems.usersadmin.domain.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimpleUserTest {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-usersadmin");

	@Test
	public void test_1_CreateAndPersistUser() {
	
		
		EntityManager em = emf.createEntityManager();
		
		//em.getTransaction().begin();
		
		User user = new User();
		user.setActive(true);
		user.setEmail("Ingo Düppe");
		user.setRole(Role.ADMIN);
		user.setPassword("masterkey");

		em.getTransaction().begin();
		
		em.persist(user);
		assertNotNull(user.getId());
		
		user.setLastLogin(new Date());
		user.setUsername("idueppe");

		em.getTransaction().commit();
		
		user.setLastPasswordChanged(new Date());
		
		em.close();
		
	}
	
	@Test
	public void test_2_findUser() 
	{
		EntityManager em = emf.createEntityManager();
		User user = em.find(User.class, Long.valueOf(1L));
		assertNotNull(user);
		assertEquals("idueppe", user.getUsername());
	}
	
	@Test
	public void test_3_updateUser() 
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, Long.valueOf(1L));
		Address address = new Address();
		address.setZip("48161");
		em.persist(address); // besser wäre cascading definieren
		user.setAddress(address);
		em.getTransaction().commit();
	}
	
	
	@Test
	public void test_4_query()
	{
		EntityManager em = emf.createEntityManager();
		String qlString = "SELECT u FROM User u WHERE u.address.zip = :zip";
		TypedQuery<User> query = em.createQuery(qlString, User.class);
		query.setParameter("zip","48161");
		List<User> usersInMS = query.getResultList();
		assertFalse(usersInMS.isEmpty());
 	}

}
