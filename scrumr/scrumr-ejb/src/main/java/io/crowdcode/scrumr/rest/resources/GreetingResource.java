package io.crowdcode.scrumr.rest.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;


@Singleton
@Path("/say")
public class GreetingResource
{
	
	private List<String> names = new ArrayList<>();
	
	@Context
	private UriInfo uriInfo;
	
	@GET
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8")
	public String say(@PathParam("name") String name) {
		return "Hello "+name;
	}

	
	@POST
	public Response addName(String name) throws URISyntaxException {
		names.add(name);
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		URI location = uriBuilder.path(name).build();
//		URI location = new URI("http://localhost:8080/scrumr/api/say/"+name);
		return Response.created(location).encoding("UTF-8").build(); 
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response listNames(@QueryParam("contains") String contains)
	{
		System.out.println("Wir filtern nach "+contains);
		return Response.ok().entity(names).build();
	}
	
}
