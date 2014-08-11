package io.crowdcode.scrumr.service.task;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;
import io.crowdcode.scrumr.dto.TaskDto;

import org.junit.Test;

public class TaskServiceTest
{
	
	private TaskServiceBean taskService = new TaskServiceBean();

	@Test
	public void test_create_valid_task()
	{
		// Arrange
		TaskDto task = new TaskDto();
		// Act
		String taskId = taskService.addTaskToProject("123", task);
		// Assert
		assertThat(taskId, is(notNullValue()));
	}

}
