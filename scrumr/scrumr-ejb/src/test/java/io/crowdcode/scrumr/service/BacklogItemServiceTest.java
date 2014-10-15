package io.crowdcode.scrumr.service;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.crowdcode.scrumr.dao.ProjectDao;
import io.crowdcode.scrumr.model.BacklogItem;
import io.crowdcode.scrumr.model.Project;

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
public class BacklogItemServiceTest
{

	@InjectMocks
	private BacklogItemServiceBean service;
	
	@Mock
	private ProjectDao projectDao;
	
	@Captor
	private ArgumentCaptor<BacklogItem> backlogItemCaptor;
	
	@Test(expected=UnknownProjectException.class)
	public void test_with_unknown_project_id() throws Exception
	{
		service.getBacklogItems("unknown_project_id");
	}
	
	@Test
	public void test_with_get_all_backlogitems() throws Exception
	{
		// arrange
		Project project = mock(Project.class);
		when(project.getBacklogItems()).thenReturn(Arrays.asList(new BacklogItem().withName("item1")));
		when(projectDao.getProject(anyString())).thenReturn(project);
		
		// act
		List<BacklogItem> items = service.getBacklogItems("projectId");
		
		// assert
		
		assertThat(items, hasSize(1));
	}
	
	@Test
	public void test_add_new_backlogItem_with_domain_project() throws Exception
	{
		Project project = new Project();
		when(projectDao.getProject(anyString())).thenReturn(project);
		
		service.addBacklogItem("projectId", "name", "description", 0, 1);
		
		assertThat(project.getBacklogItems(), hasSize(1));
		
		assertThat(project.getBacklogItems().get(0).getName(),is("name"));
	}

	@Test
	public void test_add_new_backlogItem_with_spy() throws Exception
	{
		// arrange
		Project project = new Project();
		project = spy(project);
		when(projectDao.getProject(anyString())).thenReturn(project);

		// act
		service.addBacklogItem("projectId", "name", "description", 0, 1);
		
		// assert
		verify(project).withBacklogItems(backlogItemCaptor.capture());
		assertThat(backlogItemCaptor.getValue().getName(), is("name"));
	}
	
	@Test
	public void test_add_new_backlog_item() throws Exception
	{
		// arrange
		Project project = mock(Project.class); 
		when(projectDao.getProject(anyString())).thenReturn(project);
		
		// act
		service.addBacklogItem("projectId", "name", "description", 0, 1);
		
		// assert
		verify(project).withBacklogItems(backlogItemCaptor.capture());
		assertThat(backlogItemCaptor.getValue().getName(), is("name"));
		
	}
	
	@Test(expected=UnknownProjectException.class)
	public void testName() throws Exception
	{
		service.addBacklogItem("unknown_project_id","name","description",0,1);
	}
	
}
