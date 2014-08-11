package io.crowdcode.scrumr.service.task;

import io.crowdcode.scrumr.dto.TaskDto;
import io.crowdcode.scrumr.exception.DescriptionToShortException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidBacklogItemException;
import io.crowdcode.scrumr.exception.UnknownSprintIdException;
import io.crowdcode.scrumr.model.BacklogItem;
import io.crowdcode.scrumr.model.Sprint;
import io.crowdcode.scrumr.model.Task;
import io.crowdcode.scrumr.service.ProjectService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.lang3.StringUtils;

@Stateless
public class TaskServiceBean
{

	@EJB
	private ProjectService projectService;
	
	public String addTaskToSprint(String sprintId, TaskDto taskDto) throws UnknownSprintIdException, EmptyNameException, DescriptionToShortException, InvalidBacklogItemException
	{
		if (isShorterThan(taskDto.getName(), 3))
		{
			throw new EmptyNameException("A name of a task must be at least 3 characters long");
		}
		
		if (isShorterThan(taskDto.getDescription(), 10))
		{
			throw new DescriptionToShortException("The description must be longer than 10 characters");
		}
		
		if (StringUtils.isBlank(taskDto.getBacklogItemId()))
		{
			throw new InvalidBacklogItemException(taskDto.getBacklogItemId());
		}

		Sprint sprint = projectService.getSprintById(sprintId);
		
		BacklogItem item = findItemInSprint(sprint, taskDto.getBacklogItemId());
		
		if (item == null)
		{
			throw new InvalidBacklogItemException(taskDto.getBacklogItemId());
		}
		
		sprint.addTask(convert(taskDto));
		
		return "";
	}

	private BacklogItem findItemInSprint(Sprint sprint, String backlogItemId)
	{
		for (BacklogItem item : sprint.getBacklogItems())
		{
			if (item.getId().equals(backlogItemId))
			{
				return item;
			}
		}
		return null;
	}

	public Task convert(TaskDto taskDto)
	{
		return new Task().withName(taskDto.getName());
	}

	public boolean isShorterThan(final String string, final int minLength)
	{
		return StringUtils.isBlank(string) || string.length() < minLength;
	}

}
