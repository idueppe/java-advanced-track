package com.lhsystems.usersadmin.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhsystem.usersadmin.security.service.SayHelloService;

@WebServlet("/hello")
public class SayHelloServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private SayHelloService sayHelloService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		out.println("Hello World!");
		String name = req.getParameter("name");
		out.println(sayHelloService.say(name));
		
	}
	
		

}
