package io.crowdcode.scrumr.ui.template;

import io.crowdcode.scrumr.users.HomePage;
import io.crowdcode.scrumr.users.ProjectAdminPage;
import io.crowdcode.scrumr.users.UsersAdminPage;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.html.panel.Panel;

public class NavigationPanel extends Panel 
{

	private static final long serialVersionUID = 1L;
	
	private Link<?> homeLink;
	private Link<?> projectAdminLink;
	private Link<?> userAdminLink;
	

	public NavigationPanel(String id)
	{
		super(id);
		
		add(homeLink = new StatelessLink("navHomeLink"){

			@Override
			public void onClick()
			{
				setResponsePage(HomePage.class);
			}});
		
		add(projectAdminLink = new StatelessLink("navProjectAdminLink"){

			@Override
			public void onClick()
			{
				setResponsePage(ProjectAdminPage.class);
			}});
		
		add(userAdminLink = new StatelessLink("navUserAdminLink") {

			@Override
			public void onClick()
			{
				setResponsePage(UsersAdminPage.class);
			}});
	}
	
	public void setActiveLink(Link<?> link) {
		link.add(AttributeModifier.replace("class", "active"));
	}

	public Link<?> getHomeLink()
	{
		return homeLink;
	}

	public Link<?> getProjectAdminLink()
	{
		return projectAdminLink;
	}

	public Link<?> getUserAdminLink()
	{
		return userAdminLink;
	}

	
	
}
