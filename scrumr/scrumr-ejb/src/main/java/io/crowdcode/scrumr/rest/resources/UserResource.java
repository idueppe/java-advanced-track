package io.crowdcode.scrumr.rest.resources;

import io.crowdcode.scrumr.controller.UserController;
import io.crowdcode.scrumr.dto.UserDto;
import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.LastAdministorException;
import io.crowdcode.scrumr.exception.PasswordToShortException;
import io.crowdcode.scrumr.exception.UserNotFoundException;

import java.net.URI;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Named
@Stateless
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource
{
	
	@Context
	private UriInfo uriInfo;

	@Inject
	private UserController userController;

	@GET
	public Response listUsers()
	{
		List<UserDto> users = userController.getUsers();
		return Response.ok().entity(users).build();
	}

	@POST
	public Response createUser(UserDto user) throws InvalidEmailException, EmailAlreadyExistException, EmptyNameException, PasswordToShortException
	{
//		try
//		{
			String userId = userController.registerUser(user);
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
			URI userResource = builder.path(userId).build();
			return Response.created(userResource).build();
//		} catch (InvalidEmailException | EmailAlreadyExistException | EmptyNameException | PasswordToShortException e)
//		{
//			JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
//			jsonObjBuilder.add("errorMessage", e.getMessage());
//			jsonObjBuilder.add("errorType", e.getClass().getCanonicalName());
//			JsonObject jsonObj = jsonObjBuilder.build();
//
//			return Response.status(Status.NOT_ACCEPTABLE).entity(jsonObj.toString()).build();
//		}
	}

	@PUT
	@Path("/{userId}")
	public Response updateUser(@PathParam("userId") String userId, UserDto user) throws UserNotFoundException, LastAdministorException
	{
//		try
//		{
			user.setId(userId);
			userController.updateUser(user);
			return Response.accepted().build();
//		} catch (UserNotFoundException | LastAdministorException e)
//		{
//			return Response.status(Status.NOT_ACCEPTABLE).entity(e.getMessage()).build();
//		}
	}
	
	@GET
	@Path("/{userId}")
	public Response getUser(@PathParam("userId") String userId)
	{
		return Response.ok().entity(userController.getUser(userId)).build();
	}

}
