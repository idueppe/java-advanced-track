package io.crowdcode.scrumr.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/project")
public class ProjectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProjectAction projectAction;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		projectAction.add(req.getParameter("title"));
		resp.getWriter().println("NP " + projectAction.getProjects());
	}


}
