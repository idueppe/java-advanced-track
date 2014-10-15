package io.crowdcode.scrumr.ui.admin;

import io.crowdcode.scrumr.dto.UserDto;
import io.crowdcode.scrumr.ui.template.TemplatePage;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class UsersAdminPage extends TemplatePage {
	private static final long serialVersionUID = 1L;

	private UserDto currentUser = new UserDto();
	
	public UsersAdminPage(final PageParameters parameters) {
		super(parameters);
		
		add(new Label("pageTitle", "Users Administration"));
		 
		getNavigationPanel().setUsersAdminActive();
		
		add(new UserEditPanel("userEditPanel", Model.of(currentUser)));
		
    }
}
