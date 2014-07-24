package io.crowdcode.scrumr.web;

import io.crowdcode.scrumr.controller.UserController;
import io.crowdcode.scrumr.dto.UserDto;
import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.LastAdministorException;
import io.crowdcode.scrumr.exception.PasswordToShortException;
import io.crowdcode.scrumr.exception.UserNotFoundException;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class UsersAction implements Serializable
{

	@Inject
	private UserController userController;

	private static final long serialVersionUID = 1L;

	@Produces
	@Named("selectedUser")
	@ConversationScoped
	private UserDto currentUser = new UserDto();

	public String addUser()
	{
		System.out.println("Add new User " + currentUser);
		try
		{
			if (currentUser.getId() == null)
			{
				userController.registerUser(currentUser);
			} else
			{
				userController.updateUser(currentUser);
			}
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "User with "+currentUser.getEmail()+" has been added.", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "succeed";
		} catch (InvalidEmailException | EmailAlreadyExistException | EmptyNameException | PasswordToShortException | UserNotFoundException | LastAdministorException e)
		{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return "";
	}
	
	public String cancelUser() {
		
		return "cancel";
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

}
