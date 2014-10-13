package io.crowdcode.scrumr.ui.template;

import io.crowdcode.scrumr.ui.ProjectAdminPage;
import io.crowdcode.scrumr.ui.ScrumrHomePage;
import io.crowdcode.scrumr.ui.UserAdminPage;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.html.panel.Panel;

public class NavigationPanel extends Panel
{
	private static final long serialVersionUID = 1L;

	private Link<?> homeLink;
	private Link<?> userAdminLink;
	private Link<?> projectAdminLink;
	
	
	public NavigationPanel(String id)
	{
		super(id);
		add(homeLink = new StatelessLink("navHomeLink"){
			public void onClick()
			{
				setResponsePage(ScrumrHomePage.class);				
			}
		});
		
		add(projectAdminLink = new StatelessLink("navProjectAdminLink"){
			public void onClick()
			{
				setResponsePage(ProjectAdminPage.class);				
			}
		});
		add(userAdminLink = new StatelessLink("navUserAdminLink"){
			public void onClick()
			{
				setResponsePage(UserAdminPage.class);				
			}
		});
	}
	
	public void setActiveLink(Link<?> link) {
		deactivateAll();
		link.add(AttributeModifier.replace("class", "active"));
	}
	
	public void deactivateAll() {
		homeLink.add(AttributeModifier.remove("class"));
		projectAdminLink.add(AttributeModifier.remove("class"));
		userAdminLink.add(AttributeModifier.remove("class"));
	}

	public Link<?> getHomeLink()
	{
		return homeLink;
	}

	public Link<?> getUserAdminLink()
	{
		return userAdminLink;
	}

	public Link<?> getProjectAdminLink()
	{
		return projectAdminLink;
	}

	

}
