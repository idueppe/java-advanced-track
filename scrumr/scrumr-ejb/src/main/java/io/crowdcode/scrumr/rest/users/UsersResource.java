package io.crowdcode.scrumr.rest.users;

import io.crowdcode.scrumr.controller.UserController;
import io.crowdcode.scrumr.dto.UserDto;
import io.crowdcode.scrumr.dto.UserReference;
import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.LastAdministorException;
import io.crowdcode.scrumr.exception.PasswordToShortException;
import io.crowdcode.scrumr.exception.UserNotFoundException;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResource
{
	
	@Inject
	private UserController userController;
	
	@Context
	private UriInfo uriInfo;

	@POST
	public Response createUser(UserDto user) throws InvalidEmailException, EmailAlreadyExistException, EmptyNameException, PasswordToShortException {
		String userId = userController.registerUser(user);
		URI location = uriInfo.getAbsolutePathBuilder().path(userId).build();
		return Response.created(location).entity("{\"userId\":\""+userId+"\"}").build();
	}
	
	@GET
	@Path("/{userId}")
	public Response getUser(@PathParam("userId") String userId) 
	{
		return Response.ok(userController.getUser(userId)).build();
	}
	
	
	@GET
	public Response listUsers(@QueryParam("domain") String domain)
	{
		List<UserReference> result = new ArrayList<>();
		UriBuilder builder = uriInfo.getAbsolutePathBuilder().path("{userId}");
		
		for (UserDto userDto : userController.getUsers()) {
			if (domain == null || userDto.getEmail().endsWith(domain))
			{
				final UserReference userReference = new UserReference(userDto.getId(), userDto.getEmail(), builder.build(userDto.getId()).toString());
				result.add(userReference);
			}
		}
		return Response.ok(result).build();
	}
	
	
	@PUT
	@Path("/{userId}")
	public Response updateUser(UserDto user) throws UserNotFoundException, LastAdministorException 
	{
		userController.updateUser(user);
		return Response.ok().build();
	}
	
	

}
