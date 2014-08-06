package io.crowdcode.scrumr.ui;

import java.util.logging.Logger;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final Logger LOG = Logger.getLogger(HomePage.class.getName());
	
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);
		
//		getNavigationPanel().setActiveLink(getNavigationPanel().getHomeLink());

		add(new Label("pageTitle", "Wicket-Scrumr"));
		
    }
}
