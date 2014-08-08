package io.crowdcode.scrumr.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by idueppe on 18.05.14.
 * 
 * @author idueppe
 */
@Title("Scrumr")
@Theme("scrumrtheme")
@SuppressWarnings("serial")
public class ScrumrUI extends UI
{
	private static final long serialVersionUID = 1L;

	private VerticalLayout root = new VerticalLayout();

	private VerticalLayout rootLayout = new VerticalLayout();

	@WebServlet(value = "/*", asyncSupported = false)
	@VaadinServletConfiguration(productionMode = false, ui = ScrumrUI.class, widgetset = "io.crowdcode.scrumr.ui.AppWidgetSet")
	public static class Servlet extends VaadinServlet
	{
	}

	@Override
	protected void init(VaadinRequest request)
	{
		setContent(root);
		root.setMargin(true);

		buildLoginView(true);
	}

	private void buildLoginView(boolean exit)
	{
		if (exit)
		{
			root.removeAllComponents();
		}

		rootLayout = new VerticalLayout();
		rootLayout.setSizeFull();
		root.addComponent(rootLayout);

	}

}
