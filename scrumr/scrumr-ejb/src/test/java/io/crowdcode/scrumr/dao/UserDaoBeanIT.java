package io.crowdcode.scrumr.dao;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import io.crowdcode.scrumr.model.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoBeanIT
{
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("scrumr-unit-test");

	@Spy
	private EntityManager em = emf.createEntityManager();
	
	@InjectMocks
	private UserDaoBean userDao;
	
	private String email = "junit@junit.org";
	
	@Before
	public void setUp() {
		em.getTransaction().begin();
	}
	
	@After
	public void tearDown() {
		if (em.getTransaction().isActive())
			em.getTransaction().commit();
	}

	@Test
	public void test_1_PersistUser()
	{
		userDao.persist(new User().withEmail(email));
		verify(em,times(1)).persist(any(User.class));
	}
	
	@Test
	public void test_2_FindAdmins() throws Exception
	{
		// arrage
		final User admin = new User().withEmail("admin@unit.org").withAdmin(true);
		userDao.persist(admin);
		final User user = new User().withEmail("user@unit.org").withAdmin(false);
		userDao.persist(user);
		// act
		List<User> admins = userDao.findAdmins();
		// assert
		
		assertThat(admins, allOf(hasItem(admin),not(hasItem(user))));
	}
	
	@Test
	public void test_3_FindAll() throws Exception
	{
		List<User> users = userDao.findAllUsers();
		assertThat(users, is(notNullValue()));
	} 
	
	@Test
	public void test_4_FindByUnknownEmail() throws Exception
	{
		User user = userDao.findUserByEmail("unknown_email");
		assertThat(user, is(nullValue()));
	}
	
	@Test
	public void test_5_RemoveUser() throws Exception
	{
		User user = userDao.findUserByEmail(email);
		userDao.remove(user);
		verify(em, times(1)).remove(user);
	}
	

}
