package io.crowdcode.scrumr.web;

import io.crowdcode.scrumr.controller.UserController;
import io.crowdcode.scrumr.dto.UserDto;
import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.LastAdministorException;
import io.crowdcode.scrumr.exception.PasswordToShortException;
import io.crowdcode.scrumr.exception.UserNotFoundException;
import io.crowdcode.scrumr.web.utils.FacesUtils;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class UsersAction implements Serializable
{

	@Inject
	private UserController userController;
	
	@Inject
	private Conversation conversation;

	private static final long serialVersionUID = 1L;

	@Produces
	@Named("selectedUser")
	private UserDto currentUser = new UserDto();

	private boolean updating = false;
	private boolean editing = false;
	
	@PostConstruct
	public void setup() {
		if (conversation.isTransient())
			conversation.begin();
	}

	public String add()
	{
		System.out.println("Add new User " + currentUser);
		try
		{
			userController.registerUser(currentUser);
			FacesUtils.addInfoMessage("User with " + currentUser.getEmail() + " has been added.");
			editing = false;
			updating = false;
		} catch (InvalidEmailException | EmailAlreadyExistException | EmptyNameException | PasswordToShortException e)
		{
			FacesUtils.addErrorMessage(e);
		}
		return "";
	}

	public String update()
	{
		try
		{
			userController.updateUser(currentUser);
			FacesUtils.addInfoMessage("User " + currentUser.getEmail() + " has been updated.");
			currentUser = new UserDto();
			updating = false;
			editing = false;
		} catch (UserNotFoundException | LastAdministorException e)
		{
			FacesUtils.addErrorMessage(e);
		}
		
		return "";
	}

	public String cancel()
	{
		currentUser = new UserDto();
		updating = false;
		editing = false;
		return "";
	}

	public String edit(UserDto user)
	{
		currentUser = user;
		updating = true;
		editing = true;
		return "";
	}
	
	public String create() {
		updating = false;
		editing = true;
		return "";
	}

	public List<UserDto> getUsers()
	{
		return userController.getUsers();
	}

	public UserDto getCurrentUser()
	{
		return currentUser;
	}

	public void setCurrentUser(UserDto newUser)
	{
		this.currentUser = newUser;
	}

	public boolean isUpdating()
	{
		return updating;
	}

	public boolean isEditing()
	{
		return editing;
	}

}
