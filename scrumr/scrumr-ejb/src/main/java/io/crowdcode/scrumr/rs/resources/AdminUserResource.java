package io.crowdcode.scrumr.rs.resources;

import io.crowdcode.scrumr.controller.UserController;
import io.crowdcode.scrumr.dto.UserDto;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/admin/users")
public class AdminUserResource
{
	@Inject
	private UserController userController;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDto> listUsers()
	{
		return userController.getUsers();
	}
	
	
	
	
//
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response addNewUser(UserDto userDto)
//	{
//		try
//		{
//			String userId = userController.registerUser(userDto);
//
//			return Response.ok(Entity.json(userId)).build();
//
//		} catch (InvalidEmailException | EmailAlreadyExistException | EmptyNameException | PasswordToShortException e)
//		{
//			return Response.status(Status.BAD_REQUEST).build();
//		}
//	}
//
//	@Path("/asstring")
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response addNewUser(String userJson)
//	{
//
//		try
//		{
//			JsonObject json = Json.createReader(new StringReader(userJson)).readObject();
//			UserDto user = new UserDto()
//				.withEmail(json.getString("email",""))
//				.withFullname(json.getString("fullname",""))
//				.withPassword(json.getString("password",null))
//				.withAdmin(json.getBoolean("admin",false));
//		
//			String userId = userController.registerUser(user);
//			return Response.ok(Entity.json(userId)).build();
//		} catch (InvalidEmailException | EmailAlreadyExistException | EmptyNameException | PasswordToShortException e)
//		{
//			return Response.status(Status.BAD_REQUEST).build();
//		}
//		
//
//	}

}
