package io.crowdcode.scrumr.ui.template;

import java.util.logging.Logger;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class TemplatePage extends WebPage {
	private static final Logger LOG = Logger.getLogger(TemplatePage.class.getName());
	
	private static final long serialVersionUID = 1L;

	public TemplatePage(final PageParameters parameters) {
		super(parameters);
    }
}
