package io.crowdcode.scrumr.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by idueppe on 18.05.14.
 * 
 * @author idueppe
 */
@Title("Scrumr")
//@Theme("scrumrtheme")
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
		
		Label title = new Label("Scrumr-Vaadin");
		rootLayout.addComponent(title);
		
		final TextField nameField = new TextField();
		final Label nameLabel = new Label();
		
		Button sayHello = new Button("Say Hello", new ClickListener(){

			@Override
			public void buttonClick(ClickEvent event)
			{
				nameLabel.setCaption("Hello "+nameField.getValue());
			}}	
		);
		
		rootLayout.addComponent(nameField);
		rootLayout.addComponent(sayHello);
		rootLayout.addComponent(nameLabel);
		
		UserEditComponent editComponent = new UserEditComponent();
		rootLayout.addComponent(editComponent);
	}

}
