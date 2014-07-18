package io.crowdcode.scrumr.dao;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import io.crowdcode.scrumr.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoBeanIT
{
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("scrumr-unit-test");

	@Spy
	private EntityManager em = emf.createEntityManager();
	
	@InjectMocks
	private UserDaoBean userDao;

	@Test
	public void testPersistUser()
	{
		userDao.persist(new User());
		verify(em,times(1)).persist(any(User.class));
	}

}
