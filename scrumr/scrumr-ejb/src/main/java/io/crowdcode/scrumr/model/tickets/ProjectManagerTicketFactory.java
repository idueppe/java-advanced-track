package io.crowdcode.scrumr.model.tickets;

public class ProjectManagerTicketFactory extends TicketFactory
{

	@Override
	public Ticket newTicket(String description)
	{
		assertDescriptionParameter(description); 
		return buildTicket(description);
	}
	
	public Ticket defaultTicket() {
		return buildTicket("default");
	}

	private Ticket buildTicket(String description)
	{
		if (description.contains("change")) {
			return new ChangeRequest();
		} else if (description.contains("feature")) {
			return new FeatureTicket();
		} else {
			return new BugTicket();
		}
	}

}
