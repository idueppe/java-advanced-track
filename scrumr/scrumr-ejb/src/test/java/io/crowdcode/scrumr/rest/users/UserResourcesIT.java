package io.crowdcode.scrumr.rest.users;

import static org.junit.Assert.*;
import io.crowdcode.scrumr.dto.UserDto;
import io.crowdcode.scrumr.dto.UserReference;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;

public class UserResourcesIT
{
	
	private Client client;
	private WebTarget target;
	

	@Before
	public void setUp() throws Exception
	{
		client = ClientBuilder.newBuilder().register(JacksonFeatures.class).build();
		target = client.target("http://localhost:8080/scrumr/api/users");
		
	}

	@After
	public void tearDown() throws Exception
	{
		client.close();
	}

	@Test
	public void test_get_all_user_dto()
	{
		List<UserReference> users  =
				target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<UserReference>>(){});
		System.out.println(users);
	}
	
	@Test
	public void test_existing_user() throws Exception
	{
		target.path("/{userId}").resolveTemplate("userId", "123123").request(MediaType.APPLICATION_JSON).get(UserDto.class);
		
	}

	@Test
	public void test_add_new_user() throws Exception
	{
		UserDto user = new UserDto()
			.withFullname("Ingo ")
			.withEmail(UUID.randomUUID().toString()+"@dueppe.com")
			.withPassword("geheim")
			.withAdmin(true);
		
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.json(user));
		
		JsonObject json = Json.createReader(response.readEntity(InputStream.class)).readObject();
		
		for (String key : json.keySet()) 
		{
			System.out.println(key+ ":"+json.getString(key));
		}
	}
	
}
