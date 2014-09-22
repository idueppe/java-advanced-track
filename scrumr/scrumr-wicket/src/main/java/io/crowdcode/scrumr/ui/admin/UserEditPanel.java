package io.crowdcode.scrumr.ui.admin;

import io.crowdcode.scrumr.controller.UserController;
import io.crowdcode.scrumr.dto.UserDto;
import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.PasswordToShortException;

import javax.ejb.EJB;

import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class UserEditPanel extends Panel
{

	private static final long serialVersionUID = 1L;
	
	@EJB(name="UserControllerBean")
	private UserController userController;

	public UserEditPanel(String id, IModel<UserDto> model)
	{
		super(id, model);

		Form<UserDto> form = new Form<UserDto>("userForm", model)
		{

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit()
			{
				super.onSubmit();
				UserDto user = getModelObject();
				if (user.getId() == null)
				{
					try
					{
						String id = userController.registerUser(user);
						FeedbackMessage msg = new FeedbackMessage(this, "Register User with Id "+id, FeedbackMessage.SUCCESS);
						getSession().getFeedbackMessages().add(msg);
					} catch (InvalidEmailException | EmailAlreadyExistException | EmptyNameException | PasswordToShortException e)
					{
						FeedbackMessage msg = new FeedbackMessage(this,e.getMessage(), FeedbackMessage.ERROR);
						getSession().getFeedbackMessages().add(msg);
						e.printStackTrace();
					} 
				}
				System.out.println(user);
			}
		};
		form.setDefaultModel(new CompoundPropertyModel<UserDto>(model));
		add(form);
		
		
		TextField<String> fullname = new TextField<String>("fullname");
		EmailTextField email = new EmailTextField("email");
		PasswordTextField password = new PasswordTextField("password");
		CheckBox admin = new CheckBox("admin");
		
		form.add(fullname)
			.add(email)
			.add(password)
			.add(admin);
//			.add(new AjaxFallbackButton("submit", form){});
 	}

}
