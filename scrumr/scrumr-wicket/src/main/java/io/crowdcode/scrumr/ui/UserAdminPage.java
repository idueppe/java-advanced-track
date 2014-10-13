package io.crowdcode.scrumr.ui;

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

public class UserAdminPage extends TemplatePage
{

	private static final long serialVersionUID = 1L;
	
	@EJB(name="UserControllerBean")
	private UserController userController;

	public UserAdminPage(PageParameters parameters)
	{
		super(parameters);
		add(new Label("title", "Hello JAT, was ist mit Mittagessen um "+new Date()));
		
		getNavigationPanel().setActiveLink(getNavigationPanel().getUserAdminLink());
		
		List<UserDto> users = userController.getUsers();
		DataView<UserDto> dataView = new DataView<UserDto>("users",new ListDataProvider<UserDto>(users)){

			@Override
			protected void populateItem(Item<UserDto> item)
			{
				UserDto user = item.getModelObject();
				item.add(new Label("email",user.getEmail()));
				item.add(new Label("fullname",user.getFullname()));
				item.add(new Label("admin",user.isAdmin()));
				
			}};
			
		add(dataView); // DataView der UserAdminPage als Component hinzufügen!!!
	}

}






