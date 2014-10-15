package io.crowdcode.scrumr.service;

import static io.crowdcode.scrumr.test.TestUtils.withId;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.crowdcode.scrumr.dao.ProjectDao;
import io.crowdcode.scrumr.dao.UserDao;
import io.crowdcode.scrumr.exception.UserNotFoundException;
import io.crowdcode.scrumr.model.Project;
import io.crowdcode.scrumr.model.User;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProjectManagementServiceTest
{

	@InjectMocks
	private ProjectManagementServiceBean projectManager;

	@Mock
	private ProjectDao projectDao;
	
	@Mock
	private UserDao userDao;
	
	@Captor
	private ArgumentCaptor<Project> projectCaptor;

	@Test
	public void test_if_findAllProjects_is_returning_expected_list()
	{
		final Project project = new Project();
		when(projectDao.findAllProjects()).thenReturn(Arrays.asList(project));

		List<Project> projects = projectManager.findAllProjects();

		assertThat(projects, is(notNullValue()));
		assertThat(projects, hasItem(project));
	}

	@Test
	public void test_updating_a_new_project() throws Exception
	{
		// arrange

		String name = "New JUnit Project";
		String description = "Description of the Project";
		String scrumMasterEmail = "scrummaster@junit.local";
		String productOwnerEmail = "productowner@junit.local";
		String devOneEmail = "devOne@junit.local";
		String devTwoEmail = "devTwo@junit.local";
		
		User productOwner = new User().withEmail(productOwnerEmail);
		User scrumMaster = new User().withEmail(scrumMasterEmail);
		User devOne = new User().withEmail(devOneEmail);
		User devTwo = new User().withEmail(devTwoEmail);
		
		Project project = new Project();
		when(projectDao.getProject("projectId")).thenReturn(project);
		when(userDao.findUserByEmail(productOwnerEmail)).thenReturn(productOwner);
		when(userDao.findUserByEmail(scrumMasterEmail)).thenReturn(scrumMaster);
		when(userDao.findUserByEmail(devOneEmail)).thenReturn(devOne);
		when(userDao.findUserByEmail(devTwoEmail)).thenReturn(devTwo);
		
		// act
		Project returned = projectManager.updateProject("projectId", name, description, productOwnerEmail, scrumMasterEmail, Arrays.asList(devOneEmail, devTwoEmail));
		
		// assert
		verify(projectDao, times(1)).getProject("projectId");
		verify(userDao, times(4)).findUserByEmail(anyString());
		
		assertThat(returned, is(project));
		assertThat(returned.getName(), is(name));
		assertThat(returned.getDescription(), is(description));
		assertThat(returned.getDevelopers(), hasSize(2));
		
	}
	
	@Test
	public void testThat_creating_a_project() throws Exception
	{
		// arrange

		String name = "New JUnit Project";
		String description = "Description of the Project";
		String scrumMasterEmail = "scrummaster@junit.local";
		String productOwnerEmail = "productowner@junit.local";
		String devOneEmail = "devOne@junit.local";
		String devTwoEmail = "devTwo@junit.local";
		
		User productOwner = new User().withEmail(productOwnerEmail);
		User scrumMaster = new User().withEmail(scrumMasterEmail);
		User devOne = new User().withEmail(devOneEmail);
		User devTwo = new User().withEmail(devTwoEmail);
		
		doAnswer(withId("abc123")).when(projectDao).persist(any(Project.class));
		when(userDao.findUserByEmail(productOwnerEmail)).thenReturn(productOwner);
		when(userDao.findUserByEmail(scrumMasterEmail)).thenReturn(scrumMaster);
		when(userDao.findUserByEmail(devOneEmail)).thenReturn(devOne);
		when(userDao.findUserByEmail(devTwoEmail)).thenReturn(devTwo);
		
		// act
		String projectId = projectManager.createProject(name, description, productOwnerEmail, scrumMasterEmail, Arrays.asList(devOneEmail, devTwoEmail));
		
		// assert
		verify(projectDao, times(1)).persist(projectCaptor.capture());
		verify(userDao, times(4)).findUserByEmail(anyString());
		
		assertThat(projectCaptor.getValue().getName(), is(name));
		assertThat(projectCaptor.getValue().getDescription(), is(description));
		assertThat(projectCaptor.getValue().getProductOwner(), is(productOwner));
		assertThat(projectCaptor.getValue().getScrumMaster(), is(scrumMaster));
		assertThat(projectCaptor.getValue().getDevelopers(), hasItem(devOne));

		assertThat(projectId, is("abc123"));
	}
	
	
	@Test(expected=UserNotFoundException.class)
	public void test_exception_on_unknown_product_owner() throws Exception
	{
		projectManager.createProject("name", "description", "productOwnerEmail", "scrumMasterEmail", Arrays.asList("dev"));
	}
	
	
	@Test(expected=UserNotFoundException.class)
	public void test_exception_on_unknown_scrum_master() throws Exception
	{
		when(userDao.findUserByEmail("productOwnerEmail")).thenReturn(new User().withEmail("productOwnerEmail"));
		projectManager.createProject("name", "description", "productOwnerEmail", "scrumMasterEmail", Arrays.asList("dev"));
	}
	
	
	@Test(expected=UserNotFoundException.class)
	public void test_exception_on_unknown_developer() throws Exception
	{
		when(userDao.findUserByEmail("productOwnerEmail")).thenReturn(new User().withEmail("productOwnerEmail"));
		when(userDao.findUserByEmail("scrumMasterEmail")).thenReturn(new User().withEmail("scrumMasterEmail"));
		projectManager.createProject("name", "description", "productOwnerEmail", "scrumMasterEmail", Arrays.asList("dev"));
	}
	

}
