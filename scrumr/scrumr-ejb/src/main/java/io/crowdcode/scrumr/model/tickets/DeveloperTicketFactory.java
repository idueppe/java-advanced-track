package io.crowdcode.scrumr.model.tickets;

public class DeveloperTicketFactory extends TicketFactory
{

	@Override
	public Ticket newTicket(String description)
	{
		if (description == null || description.isEmpty()) {
			throw new IllegalArgumentException("Die Beschreibung darf nicht leer sein.");
		} 
		
		if (description.contains("bad bug")) {
			return new ChangeRequest();
		} else if (description.contains("bug")) {
			return new BugTicket();
		} else {
			return new FeatureTicket();
		}
	}

}
