package io.crowdcode.scrumr.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;
import io.crowdcode.scrumr.dao.ProjectDao;
import io.crowdcode.scrumr.model.Project;
import io.crowdcode.scrumr.model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProjectServiceTest
{

	@InjectMocks
//	private ProjectServiceBean projectService;
	private ProjectService projectService = new ProjectServiceBean();
	
	@Mock
	private ProjectDao projectDao;
	
	
	@Test
	public void test_find_projects_never_return_a_null() throws Exception
	{
		// arrange
		when(projectDao.findAllProjects()).thenReturn(Collections.<Project>emptyList());
		// act
		List<Project> projects = projectService.getProjectsByEmail("junit@test.io");
		// assert
		assertThat(projects, both(empty()).and(notNullValue()));
//		assertThat(projects, both(notNullValue()).and(empty()));
	}
	
	@Test
	public void test_find_projects_with_project_owner_by_email() throws Exception
	{
		// arrange
		Project projectOne = new Project().withProductOwner(aUser("in@test.io"));
		Project projectTwo = new Project().withProductOwner(aUser("out@test.io"));
		
		when(projectDao.findAllProjects()).thenReturn(Arrays.asList(projectOne, projectTwo));
		
		// act
		List<Project> projects = projectService.getProjectsByEmail("in@test.io");
		
		// assert
		assertThat(projects, both(not(hasItem(projectTwo))).and(hasItem(projectOne)));
	}

	@Test
	public void test_find_projects_with_scrum_master_by_email() throws Exception
	{
		// arrange
		Project projectOne = new Project().withScrumMaster(aUser("in@test.io"));
		Project projectTwo = new Project().withScrumMaster(aUser("out@test.io"));
		when(projectDao.findAllProjects()).thenReturn(Arrays.asList(projectOne, projectTwo));
		
		// act
		List<Project> projects = projectService.getProjectsByEmail("in@test.io");
		
		// assert
		assertThat(projects, both(not(hasItem(projectTwo))).and(hasItem(projectOne)));
	}
	
	@Test
	public void test_find_projects_with_developers_by_email() throws Exception
	{
		// arrange
		Project projectOne = new Project().withDevelopers(aUser("in@test.io"));
		Project projectTwo = new Project().withDevelopers(aUser("out@test.io"));
		when(projectDao.findAllProjects()).thenReturn(Arrays.asList(projectOne, projectTwo));
		
		// act
		List<Project> projects = projectService.getProjectsByEmail("in@test.io");
		
		// assert
		assertThat(projects, both(not(hasItem(projectTwo))).and(hasItem(projectOne)));
	}

	
	@Test
	public void test_find_projects_with_empty_project() throws Exception
	{
		// arrange
		when(projectDao.findAllProjects()).thenReturn(Arrays.asList(new Project()));
		
		// act
		List<Project> projects = projectService.getProjectsByEmail("in@test.io");
		
		// assert
		assertThat(projects, both(empty()).and(notNullValue()));
	}
	
	@Test
	public void test_find_projects_with_null_project() throws Exception
	{
		// arrange
		when(projectDao.findAllProjects()).thenReturn(Arrays.asList((Project)null));
		
		// act
		List<Project> projects = projectService.getProjectsByEmail("in@test.io");
		
		// assert
		assertThat(projects, both(empty()).and(notNullValue()));
	}
	
	@Test
	public void test_find_all_projects_with_multirole_users() throws Exception
	{
		// arrange
		Project project = new Project()
			.withDevelopers(aUser("in@test.io"))
			.withProductOwner(aUser("in@test.io"));
		
		when(projectDao.findAllProjects()).thenReturn(Arrays.asList(project));
		
		// act
		List<Project> projects = projectService.getProjectsByEmail("in@test.io");
		
		// assert
		assertThat(projects, hasSize(1));
	}
	
	public User aUser(final String email)
	{
		return new User().withEmail(email);
	}
}




