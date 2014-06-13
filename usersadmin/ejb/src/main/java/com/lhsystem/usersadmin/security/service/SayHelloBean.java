package com.lhsystem.usersadmin.security.service;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;


@Stateless
@Local(SayHelloService.class)
@Remote(SayHelloServiceRemote.class)
public class SayHelloBean implements SayHelloService, SayHelloServiceRemote {

	@Override
	public String say(String name) {
		return "Hello" + name;
	}

}
