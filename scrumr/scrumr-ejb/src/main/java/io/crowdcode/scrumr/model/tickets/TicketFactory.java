package io.crowdcode.scrumr.model.tickets;

public abstract class TicketFactory
{

	public static TicketFactory instance() {
		if ("MEETING".equals(System.getProperty("environment"))) {
			return new ProjectManagerTicketFactory();
		} else {
			return new DeveloperTicketFactory();
		}
	}
	
	public abstract Ticket newTicket(String description);

	public void assertDescriptionParameter(String description)
	{
		if (description == null || description.isEmpty()) {
			throw new IllegalArgumentException("Die Beschreibung darf nicht leer sein.");
		}
	}
	
}
