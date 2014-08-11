package io.crowdcode.scrumr.service.task;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.when;
import io.crowdcode.scrumr.dto.TaskDto;
import io.crowdcode.scrumr.exception.DescriptionToShortException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidBacklogItemException;
import io.crowdcode.scrumr.exception.UnknownSprintIdException;
import io.crowdcode.scrumr.model.BacklogItem;
import io.crowdcode.scrumr.model.Sprint;
import io.crowdcode.scrumr.model.Task;
import io.crowdcode.scrumr.service.ProjectService;

import java.util.ArrayList;
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
public class TaskServiceTest
{
	@InjectMocks
	private TaskServiceBean taskService = new TaskServiceBean();
	
	@Mock
	private ProjectService projectService;
	
	@Captor
	private ArgumentCaptor<Task> taskCaptor;

	@Test
	public void test_that_a_valid_task_can_be_created() throws Exception
	{
		// Arrange
		final Sprint sprint = mock(Sprint.class);
		final BacklogItem backlogItem = new BacklogItem().withId("backlogItemId");
		when(projectService.getSprintById(anyString())).thenReturn(sprint);
		when(sprint.getBacklogItems()).thenReturn(Arrays.asList(backlogItem));
		
		// Act
		String taskId = taskService.addTaskToSprint("123", aTask());
				
		// Assert
		assertThat(taskId, is(notNullValue()));
		
		verify(sprint, times(1)).getBacklogItems();
		verify(sprint, times(1)).addTask(taskCaptor.capture());
		
		Task task = taskCaptor.getValue();
		assertThat(task.getName(), is("JUNIT"));
	}
	
	
	@Test
	public void test_manual_testing() throws Exception
	{
		final Sprint sprint = new Sprint() {

			private Task lastAdded;
			
			@Override
			public List<BacklogItem> getBacklogItems()
			{
				return Arrays.asList(new BacklogItem());
			}

			@Override
			public void addTask(Task task)
			{
				lastAdded = task;
			}
			
			
		};
		
		
		
	}
	@Test(expected=EmptyNameException.class)
	public void test_that_an_empty_name_is_not_allowed() throws Exception
	{
		taskService.addTaskToSprint("123", aTask().withName(""));
	}
	
	@Test(expected=DescriptionToShortException.class)
	public void test_that_an_empty_description_is_not_allowed() throws Exception
	{
		taskService.addTaskToSprint("123", aTask().withDescription(""));
	}
	
	@Test(expected=InvalidBacklogItemException.class)
	public void test_that_a_backlog_item_id_is_provided() throws Exception
	{
		taskService.addTaskToSprint("123", aTask().withBacklogItemId(""));
	}
	
	
	@Test(expected=InvalidBacklogItemException.class)
	public void test_with_unknown_backlog_id() throws Exception
	{
		// Arrage
		Sprint sprint = mock(Sprint.class);
		when(projectService.getSprintById(anyString())).thenReturn(sprint);
		when(sprint.getBacklogItems()).thenReturn(new ArrayList<BacklogItem>());
		
		// Act
		taskService.addTaskToSprint("123", aTask().withBacklogItemId("unknown"));
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Test(expected = UnknownSprintIdException.class)
	public void test_for_a_unknown_sprint_id() throws Exception
	{
		// Arrange
		when(projectService.getSprintById(anyString())).thenThrow(UnknownSprintIdException.class);
		// Act
		taskService.addTaskToSprint("123", aTask());
		// Assert
	}
	
	private TaskDto aTask() 
	{
		return new TaskDto()
			.withName("JUNIT")
			.withDescription("Description")
			.withBacklogItemId("backlogItemId")
			.withEstimation(10)
			.withRemaining(10)
			.withState("TODO")
			.withAssignedToEmail("junit@worker.io");
	}

}
