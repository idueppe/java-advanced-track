package com.lhsystems.usersadmin.ui;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.lhsystems.usersadmin.domain.Role;
import com.lhsystems.usersadmin.domain.User;
import com.lhsystems.usersadmin.service.UserAdminService;
import com.lhsystems.usersadmin.service.UserAlreadyExistsException;
import com.lhsystems.usersadmin.service.UserNotFoundException;


@Named
@ConversationScoped
public class UsersAdminView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UserAdminService userAdminService;
	
	@Inject
	private Conversation conversation;


	private User selectedUser;
	
	@PostConstruct
	public void init(){
		if (conversation.isTransient())
			conversation.begin();
	}
	
	public List<User> getUsers()
	{
		return userAdminService.listAllUsers();
	}
	
	public String editUser(User user)
	{
		selectedUser = user;
		return "edit_user";
	}
	
	public String createNewUser()
	{
		selectedUser = new User();
		return "create_user";
	}
	
	public boolean isEditingUser()
	{
		return selectedUser != null && selectedUser.getId() != null;
	}
	
	public String cancel()
	{
		selectedUser = null;
		return "cancel";
	}
	
	public String save()
	{
		try {
			userAdminService.updateUser(selectedUser);
			return "done";
		} catch (UserNotFoundException e) {
			FacesMessage message = new FacesMessage(e.getMessage(), e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "";
		}
	}
	
	public String create()
	{
		try {
			userAdminService.createUser(selectedUser);
			selectedUser = new User();
			return "done";
		} catch (UserAlreadyExistsException e) {
			FacesMessage message = new FacesMessage(e.getMessage(), e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "";
		}
	}
	
	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}
}

