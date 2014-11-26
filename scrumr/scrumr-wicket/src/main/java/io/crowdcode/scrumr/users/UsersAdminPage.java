package io.crowdcode.scrumr.users;

import io.crowdcode.scrumr.controller.UserController;
import io.crowdcode.scrumr.dto.UserDto;
import io.crowdcode.scrumr.ui.template.TemplatePage;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class UsersAdminPage extends TemplatePage
{

	private static final long serialVersionUID = 1L;
	
	@EJB(name="UserControllerBean")
	private UserController userController;

	public UsersAdminPage(final PageParameters parameters)
	{
		super(parameters);
		Label label = new Label("currentTime", new Date());
		add(label);
		
		getNavigationPanel().setActiveLink(getNavigationPanel().getUserAdminLink());
		
		final List<UserDto> users = userController.getUsers();
		
		DataView<UserDto> dataView = new DataView<UserDto>("users", new ListDataProvider<UserDto>(users))
		{

			@Override
			protected void populateItem(Item<UserDto> item)
			{
				final UserDto user = item.getModelObject();
				item.add(new Label("email", user.getEmail()));
				item.add(new Label("fullname", user.getFullname()));
				item.add(new Label("admin", user.isAdmin()));
			}
		};
		
		add(dataView);
	}

}
