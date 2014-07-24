package io.crowdcode.scrumr.web;

import io.crowdcode.scrumr.controller.UserController;
import io.crowdcode.scrumr.dto.UserDto;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class UsersAction implements Serializable
{
	
	@Inject
	private UserController userController;
	
	private static final long serialVersionUID = 1L;
	
	private UserDto newUser = new UserDto();
	
	public String addUser() {
		System.out.println("Add new User " + newUser);
//		userController;
		return "";
	}

	public List<UserDto> getUsers()
	{
		return userController.getUsers();
	}

	public UserDto getNewUser()
	{
		return newUser;
	}

	public void setNewUser(UserDto newUser)
	{
		this.newUser = newUser;
	}

	
}
