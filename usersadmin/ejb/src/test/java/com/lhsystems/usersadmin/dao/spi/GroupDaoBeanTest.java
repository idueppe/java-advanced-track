package com.lhsystems.usersadmin.dao.spi;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.lhsystems.usersadmin.domain.Group;
import com.lhsystems.usersadmin.domain.User;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GroupDaoBeanTest
{

	private static final String JUNIT_USERNAME = "JUNIT_USERNAME";

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-usersadmin");

	@Spy
	private EntityManager em = emf.createEntityManager();

	@InjectMocks
	private UserDaoBean dao;
	

	@AfterClass
	public static void tearDownClass()
	{
		emf.close();
	}

	@Test
	public void test_1_createGroup()
	{
		em.getTransaction().begin();
		User user = new User();
		user.setUsername(JUNIT_USERNAME);
		user.setPassword("secret_password");
		dao.create(user);
		assertNotNull(user.getId());
		
		Group group = new Group();
		group.getUsers().add(user);
		em.persist(group);
		
		em.getTransaction().commit();
		
		em.clear();
		
		EntityGraph<?> groupWithUsersGrapth = em.getEntityGraph("groupWithUsers");
		Map<String, Object> properties = new HashMap<String, Object>();
//		properties.put("javax.persistence.fetchgraph", groupWithUsersGrapth);
		properties.put("javax.persistence.loadgraph", groupWithUsersGrapth);
		Group loadGroup = em.find(Group.class, group.getId(), properties);
//		Group loadGroup = em.find(Group.class, group.getId(), groupWithUsersGrapth);
		
		em.close();
		User foundUser = loadGroup.getUsers().iterator().next();
		System.out.println(foundUser);
		
	}

}
