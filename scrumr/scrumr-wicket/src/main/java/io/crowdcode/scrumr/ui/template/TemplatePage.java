package io.crowdcode.scrumr.ui.template;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class TemplatePage extends WebPage
{

	private static final long serialVersionUID = 1L;
	
	private NavigationPanel navigationPanel;

	public TemplatePage(PageParameters parameters)
	{
		super(parameters);
		
		add(navigationPanel = new NavigationPanel("navigationPanel"));
	}

	protected NavigationPanel getNavigationPanel() {
		return navigationPanel;
	}
	
}
