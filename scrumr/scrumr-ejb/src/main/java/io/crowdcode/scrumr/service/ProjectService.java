package io.crowdcode.scrumr.service;

import io.crowdcode.scrumr.exception.UnknownSprintIdException;
import io.crowdcode.scrumr.model.Sprint;


public interface ProjectService {

	Sprint getSprintById(String sprintId) throws UnknownSprintIdException;
	
}