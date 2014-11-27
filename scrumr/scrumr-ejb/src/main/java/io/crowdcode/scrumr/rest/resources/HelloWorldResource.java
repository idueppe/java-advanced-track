package io.crowdcode.scrumr.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/say")
public class HelloWorldResource
{
	@GET
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(@PathParam("name") String name)
	{
		return "Hello "+name;
	}
	

}
