package com.lhsystems.usersadmin.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhsystems.usersadmin.dto.UserDto;
import com.lhsystems.usersadmin.service.UserService;

@WebServlet(urlPatterns = "/users")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private UserService userService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		printHtml(resp.getWriter());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String role = req.getParameter("role");

		UserDto userDto = new UserDto() //
			.withUsername(username)//
			.withEmail(email)//
				.withRole(role);

		userService.addUser(userDto);

		System.out.println("Add user " + username + " " + email + " " + role);

		printHtml(resp.getWriter());
	}

	private void printHtml(PrintWriter out) {
		out.println("<html><body>");
		out.println("<h1>Users List</h1>");

		out.println("		<h4>Liste:</h4> ");

		printUserList(out);

		out.println("		<h4>Add User:</h4> ");
		out.println("		<form method='post'> ");
		out.println("			<label>Username</label><br/><input type='text' name='username'/> <br/> ");
		out.println("			<label>Email</label><br/><input type='text' name='email' /> <br/>");
		out.println("			<label>Role</label>");
		out.println("					<select name='role'>");
		out.println("						<option value='user'>User</option>");
		out.println("						<option value='admin'>Admin</option>");
		out.println("						<option value='attendee'>Attendee</option>");
		out.println("					</select>");
		out.println("			<input type='submit' value='add'/> ");
		out.println("		</form> ");
		out.println("	</body> ");
		out.println("</html> ");
	}

	private void printUserList(PrintWriter out) {
		out.println("<ul>");

		for (UserDto user : userService.findAll()) {
			out.print("<li>" + user.getEmail() + "</li>");
		}

		out.println("</ul>");
	}

}
