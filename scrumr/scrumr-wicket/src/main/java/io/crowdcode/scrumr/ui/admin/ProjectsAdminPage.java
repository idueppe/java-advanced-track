package io.crowdcode.scrumr.ui.admin;

import io.crowdcode.scrumr.ui.template.TemplatePage;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ProjectsAdminPage extends TemplatePage {
	private static final long serialVersionUID = 1L;

	public ProjectsAdminPage(final PageParameters parameters) {
		super(parameters);
		
		add(new Label("pageTitle", "Projects Administration"));
		
		getNavigationPanel().setProjectsAdminActive();
		
    }
}
