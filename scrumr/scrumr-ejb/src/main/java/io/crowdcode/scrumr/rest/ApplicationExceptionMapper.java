package io.crowdcode.scrumr.rest;

import io.crowdcode.scrumr.exception.ApplicationException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<ApplicationException>
{

	@Override
	public Response toResponse(ApplicationException exception)
	{
		JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
		jsonObjBuilder.add("errorMessage", exception.getMessage());
		jsonObjBuilder.add("errorType", exception.getClass().getCanonicalName());
		JsonObject jsonObj = jsonObjBuilder.build();

		return Response.status(Status.NOT_ACCEPTABLE).entity(jsonObj.toString()).build();
	}

}
