package io.crowdcode.scrumr.rs.resources;

import io.crowdcode.scrumr.controller.UserController;
import io.crowdcode.scrumr.dto.UserDto;
import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.PasswordToShortException;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Stateless
@Path("/admin/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminUserResource
{
	@Inject
	private UserController userController;

	@GET
	public List<UserDto> listUsers()
	{
		return userController.getUsers();
	}
	
	@POST
	public Response addNewUser(UserDto userDto)
	{
		try
		{
			String userId = userController.registerUser(userDto);

			return Response.ok().entity("{\"userId\":\""+userId+"\"}").build();

		} catch (InvalidEmailException | EmailAlreadyExistException | EmptyNameException | PasswordToShortException e)
		{
			JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
			jsonObjectBuilder.add("errorMessage", e.getMessage());
			jsonObjectBuilder.add("errorType", e.getClass().getCanonicalName());
			JsonObject jsonObject = jsonObjectBuilder.build();
			
			return Response.status(Status.BAD_REQUEST).entity(jsonObject).build();
		}
	}

}
