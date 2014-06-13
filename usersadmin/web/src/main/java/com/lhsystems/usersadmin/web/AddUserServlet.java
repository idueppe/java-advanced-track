package com.lhsystems.usersadmin.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhsystem.usersadmin.security.service.UsersService;

@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private UsersService usersService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>  ");
		out.println("	<body> ");
		out.println("		<h1>Add User:</h1> ");
		out.println("		<form method='post'> ");
		out.println("			Username: <input type='text' name='username'/> ");
		out.println("			Password: <input type='password' name='password' /> ");
		out.println("			<input type='submit' value='add'/> ");
		out.println("		</form> ");
		out.println("	</body> ");
		out.println("</html> ");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		usersService.addUser(username, password);

	}

	
	
}
