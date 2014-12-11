package io.crowdcode.scrumr.ui;

import io.crowdcode.scrumr.ui.template.TemplatePage;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ScrumrHomePage extends TemplatePage
{

	private static final long serialVersionUID = 1L;

	public ScrumrHomePage(PageParameters parameters)
	{
		super(parameters);
		add(new Label("title", "Hello JAT, was ist mit Mittagessen um "+new Date()));
		
		getNavigationPanel().setActiveLink(getNavigationPanel().getHomeLink());
	}

}






