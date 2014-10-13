package io.crowdcode.scrumr;

import io.crowdcode.scrumr.ui.ScrumrHomePage;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.wicketstuff.javaee.injection.JavaEEComponentInjector;
import org.wicketstuff.javaee.naming.global.AppJndiNamingStrategy;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see io.crowdcode.scrumr.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return ScrumrHomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		getComponentInstantiationListeners().add(new JavaEEComponentInjector(this, new AppJndiNamingStrategy("scrumr-ejb")));
		super.init();

		// add your configuration here
	}
}
