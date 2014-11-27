package io.crowdcode.scrumr.rest.resources;

import io.crowdcode.scrumr.controller.UserController;
import io.crowdcode.scrumr.dto.UserDto;
import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.PasswordToShortException;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/users")
public class UsersResource
{
	@Inject
	private UserController userController;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listUsers() {
		List<UserDto> users = userController.getUsers();
		return Response.ok().entity(users).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(UserDto user) throws InvalidEmailException, EmailAlreadyExistException, EmptyNameException, PasswordToShortException 
	{
		String userId = userController.registerUser(user);
		return Response.ok(Entity.json(userId)).build();
	}
	
}
