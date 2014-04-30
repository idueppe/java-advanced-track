package com.lhsystems.usersadmin.security.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.lhsystem.usersadmin.security.domain.Address;
import com.lhsystem.usersadmin.security.domain.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimpleJPATest {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-usersadmin");
	
	private static Long userId;

	private EntityManager em;
	
	@Before
	public void setUp()
	{
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}
	
	@After
	public void tearDown()
	{
		if (em.getTransaction().isActive())
			em.getTransaction().commit();
		em.close();
	}
	@Test
	public void test_1_CreateUserAndPersist() {
		
		User user = new User();
		user.setUsername("idueppe");
		user.setPassword("123");
		
		em.persist(user);
		user.setEmail("ingo.dueppe@dueppe.com");
		
		assertNotNull(user.getId());
		userId = user.getId();
		
		// ---
		em.getTransaction().commit();

		user.setFullname("Ingo Düppe");
		em.getTransaction().begin();
		em.getTransaction().commit();
	}
	
	
	@Test
	public void test_2_FindUser() throws Exception {
		User user = em.find(User.class, userId);
		assertNotNull(user);
		assertEquals("idueppe", user.getUsername());
		
		user.setPassword("new password");
	}
	
	@Test
	public void test_3_AddAddressUser() throws Exception {
		User user = em.find(User.class, userId);
		Address address = new Address();
		address.setZip("48161");
		user.setAddress(address);
//		em.persist(address);
	}
	
	@Test
	public void test_4_Query() throws Exception {
		String qlString = "SELECT u FROM User u WHERE u.username = :username";
		TypedQuery<User> query = em.createQuery(qlString,User.class);
		query.setParameter("username","idueppe");
		List<User> users = query.getResultList();
		assertFalse(users.isEmpty());
	}
	
	@Test
	public void test_5_QueryForZip() throws Exception {
		String qlString = "SELECT u FROM User u WHERE u.address.zip = :zip";
		TypedQuery<User> query = em.createQuery(qlString,User.class);
		query.setParameter("zip","48161");
		List<User> users = query.getResultList();
		assertFalse(users.isEmpty());
	}
	
	@Test
	public void test_9_Delete() throws Exception {
//		User user = em.find(User.class, userId);
		User user = em.getReference(User.class, userId);
//		em.remove(user.getAddress());
		em.remove(user);
		assertNull(em.find(User.class, userId));
	}
	
}
