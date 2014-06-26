package com.lhsystems.usersadmin.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhsystems.usersadmin.service.UserService;

@WebServlet(urlPatterns="/users")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
//	@EJB
//	private UserService userService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		
		out.println("<html><body><h1>Hello Berlin!</h1></body></html>");
		
	}
	
	

}
