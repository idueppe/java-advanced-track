package io.crowdcode.scrumr.rest;

import io.crowdcode.scrumr.rest.resources.HelloWorldResource;
import io.crowdcode.scrumr.rest.resources.UsersResource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class JaxRsActivator extends Application
{

	@Override
	public Set<Class<?>> getClasses()
	{
		Set<Class<?>> classes = new HashSet<>();
		classes.add(HelloWorldResource.class);
		classes.add(UsersResource.class);
		classes.add(ApplicationExceptionMapper.class);
		classes.add(SecurityResponseFilter.class);
		return classes;
	}
	
	

}
