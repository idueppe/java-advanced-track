package io.crowdcode.scrumr.dao;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import io.crowdcode.scrumr.model.Project;

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
public class ProjectDaoBeanIT
{
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("scrumr-unit-test");

	@Spy
	private EntityManager em = emf.createEntityManager();
	
	@InjectMocks
	private UserDaoBean userDao;
	
	@InjectMocks
	private ProjectDaoBean projectDao;
	
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
	public void test_1_PersistProject()
	{
		projectDao.persist(new Project().withName("name").withDescription("description"));
		verify(em,times(1)).persist(any(Project.class));
	}
	
	@Test
	public void test_2_FindAllProjects() throws Exception
	{
		List<Project> projects = projectDao.findAllProjects();
		assertThat(projects, is(notNullValue()));
		assertThat(projects.size(), greaterThanOrEqualTo(1));
	}
	
}
