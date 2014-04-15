package com.lhsystems.usersadmin.dao.spi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.lhsystems.usersadmin.domain.User;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoBeanTest
{

	private static final String JUNIT_USERNAME = "JUNIT_USERNAME";

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-usersadmin");

	@Spy
	private EntityManager em = emf.createEntityManager();

	@InjectMocks
	private UserDaoBean dao;

	@After
	public void tearDown()
	{
		if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		
		if (em.isOpen())
			em.close();
	}
	
	@AfterClass
	public static void tearDownClass()
	{
		emf.close();
	}

	@Test
	public void test_1_createUser()
	{
		em.getTransaction().begin();
		User user = new User();
		user.setUsername(JUNIT_USERNAME);
		user.setPassword("secret_password");
		dao.create(user);
		assertNotNull(user.getId());
		em.getTransaction().commit();
	}

	@Test
	public void test_2_findByUsername()
	{
		User user = dao.findByUsername(JUNIT_USERNAME);
		assertEquals(JUNIT_USERNAME, user.getUsername());
	}

	@Test
	public void test_3_updateUser()
	{
		User user = dao.findByUsername(JUNIT_USERNAME);
		em.detach(user);
		// detached object
		user.setUsername(user.getUsername() + " UPDATE");
		em.getTransaction().begin();
		user = dao.update(user);
		em.getTransaction().commit();
	}
	
	@Test
	public void test_4_findAll()
	{
		List<User> users = dao.findAll();
		assertFalse(users.isEmpty());
	}

}
