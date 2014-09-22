package io.crowdcode.scrumr.ui.template;

import io.crowdcode.scrumr.ui.HomePage;
import io.crowdcode.scrumr.ui.admin.ProjectsAdminPage;
import io.crowdcode.scrumr.ui.admin.UsersAdminPage;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.html.panel.Panel;

public class NavigationPanel extends Panel
{

	private static final long serialVersionUID = 1L;

	private StatelessLink<?> homeLink;
	private StatelessLink<?> projectsAdminLink;
	private StatelessLink<?> usersAdminLink;

	@SuppressWarnings({ "rawtypes", "serial" })
	public NavigationPanel(String id)
	{
		super(id);

		homeLink = new StatelessLink("navHomeLink")
		{

			@Override
			public void onClick()
			{
				setResponsePage(HomePage.class);
			}
		};

		projectsAdminLink = new StatelessLink("navProjectsAdminLink")
		{

			@Override
			public void onClick()
			{
				setResponsePage(ProjectsAdminPage.class);
			}
		};

		usersAdminLink = new StatelessLink("navUsersAdminLink")
		{

			@Override
			public void onClick()
			{
				setResponsePage(UsersAdminPage.class);
			}
		};

		add(homeLink);
		add(projectsAdminLink);
		add(usersAdminLink);

	}

	public void setHomeActive()
	{
		homeLink.add(AttributeModifier.append("class", "active"));
	}

	public void setProjectsAdminActive()
	{
		projectsAdminLink.add(AttributeModifier.append("class", "active"));
	}

	public void setUsersAdminActive()
	{
		usersAdminLink.add(AttributeModifier.append("class", "active"));
	}


	
}
