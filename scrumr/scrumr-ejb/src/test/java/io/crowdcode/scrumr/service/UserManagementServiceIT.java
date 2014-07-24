package io.crowdcode.scrumr.service;

import static io.crowdcode.scrumr.test.InjectionUtil.inject;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import io.crowdcode.scrumr.dao.UserDaoBean;
import io.crowdcode.scrumr.model.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserManagementServiceIT
{

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("scrumr-unit-test");

	@Spy
	private EntityManager em = emf.createEntityManager();
	
	@InjectMocks
	private UserDaoBean userDao = new UserDaoBean();
	
	@InjectMocks
	private UserManagementServiceBean userService;
	
	@Before
	public void setUp() {
		inject(userDao).into(userService);
	}
	
	@Test
	public void testFindAllUsers() throws Exception
	{
		userService.registerUser("email@unit.org", "name", "password", true);
		List<User> users = userService.getUserList();
		
		assertThat(users, is(notNullValue()));
	}
	
	
}
