package com.lhsystems.usersadmin.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhsystem.usersadmin.security.dto.UserDto;
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
		printHtml(out);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String roleName = req.getParameter("role");
		
		UserDto userDto = new UserDto()
			.withEmail(email)
			.withUsername(username)
			.withRoleName(roleName);
		
		usersService.createUser(userDto);
		printHtml(resp.getWriter());
	}

	private void printHtml(PrintWriter out) {
		printHtmlHeader(out);
		printUsersListe(out, usersService.listUsers());
		printAddUserForm(out);
		printHtmlFooter(out);
	}
	
	private void printHtmlHeader(PrintWriter out) {
		out.println("<html><body>");
	}

	private void printUsersListe(PrintWriter out, List<UserDto> users) {
		out.println("<h1>Users List</h1>");
		out.println("		<h4>Liste:</h4> ");
		out.println("<ul>");
		for (UserDto user : users) {
			out.println("<li>");
			out.println(user.getUsername()+" "+user.getEmail()+" "+user.getRoleName());
			out.println("</li>");
		}
		out.println("</ul>");
	}

	private void printAddUserForm(PrintWriter out) {
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
	}

	private void printHtmlFooter(PrintWriter out) {
		out.println("	</body> ");
		out.println("</html> ");
	}

}
