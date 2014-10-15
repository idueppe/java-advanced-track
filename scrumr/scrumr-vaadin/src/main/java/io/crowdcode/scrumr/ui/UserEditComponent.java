package io.crowdcode.scrumr.ui;

import io.crowdcode.scrumr.controller.UserController;
import io.crowdcode.scrumr.dto.UserDto;
import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.PasswordToShortException;

import java.util.UUID;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

public class UserEditComponent extends CustomComponent
{

	private static final long serialVersionUID = 1L;
	
	@AutoGenerated
	private Label lblEmail;
	
	@AutoGenerated
	private TextField txtEmail;
	
	@AutoGenerated
	private Button btnSave;

	public UserEditComponent()
	{
		GridLayout gridLayout = new GridLayout(2,5);
		setCompositionRoot(gridLayout);
		
		lblEmail = new Label("Email");
		txtEmail = new TextField();
		
		gridLayout.addComponent(lblEmail);
		gridLayout.addComponent(txtEmail);
		
		btnSave = new Button("Save", new ClickListener()
		{
			
			@Override
			public void buttonClick(ClickEvent event)
			{
				UserDto userDto = new UserDto();
				userDto.setEmail(txtEmail.getValue());
				userDto.setFullname(UUID.randomUUID().toString());
				userDto.setPassword(UUID.randomUUID().toString());
				try
				{
					UserController userController = (UserController) 
							new InitialContext().lookup("java:app/scrumr-ejb/UserControllerBean!io.crowdcode.scrumr.controller.UserController");
					String id = userController.registerUser(userDto);
					 new Notification("Added User with Id "+id);
				} catch (NamingException | InvalidEmailException | EmailAlreadyExistException | EmptyNameException | PasswordToShortException e)
				{
					e.printStackTrace();
				}
			}
		});
		gridLayout.addComponent(btnSave);
	}


}
