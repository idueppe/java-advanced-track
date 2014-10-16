package io.crowdcode.scrumr.rs.resources;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import io.crowdcode.scrumr.dto.UserDto;

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

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;

public class AdminUserResourceIT
{

	private Client client;
	private WebTarget target;

	@Before
	public void setup()
	{
		client = ClientBuilder.newBuilder().register(JacksonFeatures.class).build();
		target = client.target("http://localhost:8080/scrumr/api");
	}

	@After
	public void tearDown()
	{
		client.close();
	}

	@Test
	public void test_retrieving_a_list_of_users_as_string() throws Exception
	{
		String responseMsg = target.path("/admin/users").request(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(responseMsg);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_retrieving_a_list_of_users_as_object() throws Exception
	{
		List<UserDto> users = target.path("/admin/users").request(MediaType.APPLICATION_JSON).get(new GenericType<List<UserDto>>(){});
		assertThat(users,  hasItems(
				Matchers.<UserDto>hasProperty("email", equalTo("ingo.dueppe@crowdcode.de"))
				,Matchers.<UserDto>hasProperty("email",equalTo("marcus.noerder-tuitje@crowdcode.de"))));
		System.out.println(users);
	}
	
	@Test
	public void test_adding_a_user_as_json() throws Exception
	{
		UserDto user = new UserDto()
		.withFullname("Geschäftsführung")
		.withEmail(UUID.randomUUID().toString()+"gf@crowdcode.de")
		.withPassword("password")
		.withAdmin(true);
		
		Response response = target.path("/admin/users")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.json(user));
		
//		String body = response.readEntity(String.class);
		JsonObject json = Json.createReader(response.readEntity(InputStream.class)).readObject();
		
		
		for (String key : json.keySet()) 
		{
			System.out.println(key+" "+json.get(key));
		}
	}
	
	@Test
	public void test_adding_a_user_as_string() throws Exception
	{
		UserDto user = new UserDto()
			.withFullname("Geschäftsführung")
			.withEmail(UUID.randomUUID().toString()+"gf@crowdcode.de")
			.withPassword("password")
			.withAdmin(true);
		
		Response response = target.path("/admin/users/asstring")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.json(user));
		
//		String body = response.readEntity(String.class);
		JsonObject json = Json.createReader(response.readEntity(InputStream.class)).readObject();
		
		
		for (String key : json.keySet()) 
		{
			System.out.println(key+" "+json.get(key));
		}
	}

	@Test
	public void test_json() throws Exception
	{
		UserDto user = new UserDto()
			.withFullname("Geschäftsführung")
			.withEmail("gf@crowdcode.de")
			.withAdmin(false);

	}
	
}
