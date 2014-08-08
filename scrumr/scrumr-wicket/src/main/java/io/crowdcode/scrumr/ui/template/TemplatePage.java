package io.crowdcode.scrumr.ui.template;

import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class TemplatePage extends WebPage
{

	private static final long serialVersionUID = 1L;
	private NavigationPanel navigationPanel;
	private FeedbackPanel successMessagePanel;
	private FeedbackPanel errorMessagePanel;

	public TemplatePage(PageParameters parameters)
	{
		super(parameters);
		navigationPanel = new NavigationPanel("navigationPanel");
		
		successMessagePanel = new FeedbackPanel("successMessagePanel", new IFeedbackMessageFilter()
		{
			
			@Override
			public boolean accept(FeedbackMessage message)
			{
				return message.getLevel() <= FeedbackMessage.SUCCESS;
			}
		});
		errorMessagePanel = new FeedbackPanel("errorMessagePanel", new IFeedbackMessageFilter()
		{
			@Override
			public boolean accept(FeedbackMessage message)
			{
				return !(message.getLevel() <= FeedbackMessage.SUCCESS);
			}
		});
		add(successMessagePanel);
		add(errorMessagePanel);
		add(navigationPanel);
	}
	
	public NavigationPanel getNavigationPanel() {
		return navigationPanel;
	}

	@Override
	protected void onBeforeRender()
	{
		super.onBeforeRender();
		errorMessagePanel.setVisible(errorMessagePanel.anyMessage());
		successMessagePanel.setVisible(successMessagePanel.anyMessage());
	}

}
