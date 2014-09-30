package io.crowdcode.scrumr.users;

import io.crowdcode.scrumr.ui.template.TemplatePage;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ProjectAdminPage extends TemplatePage
{

	private static final long serialVersionUID = 1L;

	public ProjectAdminPage(final PageParameters parameters)
	{
		super(parameters);
		Label label = new Label("currentTime", new Date());
		add(label);
		
		getNavigationPanel().setActiveLink(getNavigationPanel().getProjectAdminLink());
	}

}
