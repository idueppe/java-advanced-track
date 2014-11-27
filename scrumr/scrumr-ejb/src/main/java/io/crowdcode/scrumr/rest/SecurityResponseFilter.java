package io.crowdcode.scrumr.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class SecurityResponseFilter implements ContainerResponseFilter
{

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException
	{
		responseContext.getHeaders().add("special-private-ingo-key", "lasödkfj nklödsnvldfj klö");
	}

}
