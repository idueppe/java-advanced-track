package com.lhsystems.usersadmin.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhsystem.usersadmin.security.domain.User;
import com.lhsystem.usersadmin.security.service.UsersService;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private UsersService usersService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		out.println("<html><body><h1>Users</h1>");
		out.println("<ul>");

		for (User user : usersService.listAllUsers()) {
			out.println("<li>");
			out.println(user.toString());
			out.println("</li>");
		}

		out.println("</ul>");
		out.println("</body></html>");
	}

}
