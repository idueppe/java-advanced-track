package com.lhsystems.usersadmin.web;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lhsystem.usersadmin.security.service.Calculator;
import com.lhsystem.usersadmin.security.service.CalculatorBean;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet {

	private static final String CALCULATOR_SESSION_KEY = "my_calculator_session_key";
	private static final long serialVersionUID = 1L;

	// @EJB -- doesn't work with stateful session beans
	// private Calculator calculator;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String operation = req.getParameter("operation");
		String value = req.getParameter("value");

		long sum = calculate(operation, value, getCalculator(req));
		resp.getOutputStream().println("Sum is " + sum);
	}

	private Calculator getCalculator(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		// fetch calculator bean from web session
		Calculator calculator = (Calculator) session.getAttribute(CALCULATOR_SESSION_KEY);
			
		if (calculator == null)
		{
			// no calculator found
			try {
				
				InitialContext context = new InitialContext();
				calculator = (Calculator) context.lookup("java:app/usersadmin-ejb/CalculatorBean!com.lhsystem.usersadmin.security.service.Calculator");
				
				// put calculator reference into web session
				session.setAttribute(CALCULATOR_SESSION_KEY, calculator);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return calculator;
	}

	private long calculate(String operation, String value, Calculator calculator) {
		switch (operation) {
		case "add":
			calculator.add(Long.valueOf(value));
			break;
		case "sub":
			calculator.sub(Long.valueOf(value));
			break;
		}

		return calculator.sum();
	}

}
