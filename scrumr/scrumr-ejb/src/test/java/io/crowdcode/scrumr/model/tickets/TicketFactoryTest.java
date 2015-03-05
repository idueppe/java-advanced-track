package io.crowdcode.scrumr.model.tickets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;

public class TicketFactoryTest
{
	
	@Test
	public void testTicketFactoryNotNull() throws Exception
	{
		assertThat(TicketFactory.instance(), is(notNullValue()));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExceptionIfDescriptionIsNull() throws Exception
	{
		TicketFactory.instance().newTicket(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testExceptionIfDescriptionIsEmpty() throws Exception
	{
		TicketFactory.instance().newTicket("");
	}
	
	@Test
	public void testNewTicketByDescriptionForDeveloper() throws Exception
	{
		System.setProperty("environment", "ATHOME");
		TicketFactory factory = TicketFactory.instance();
		assertThat(factory.newTicket("bad bug"), instanceOf(ChangeRequest.class));
		assertThat(factory.newTicket("feature"), instanceOf(FeatureTicket.class));
		assertThat(factory.newTicket("bug"), instanceOf(BugTicket.class));
	}
	
	@Test
	public void testNewTicketByDescriptionForPM() throws Exception
	{
		System.setProperty("environment","MEETING");
		TicketFactory factory = TicketFactory.instance();
		assertThat(factory.newTicket("change"), instanceOf(ChangeRequest.class));
		assertThat(factory.newTicket("feature"), instanceOf(FeatureTicket.class));
		assertThat(factory.newTicket("bug"), instanceOf(BugTicket.class));
	}
	
}
