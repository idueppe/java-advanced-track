package com.lhsystems.usersdomain.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhsystem.usersadmin.security.service.Calculator;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private Calculator calculator;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String operation = req.getParameter("operation");
		String value = req.getParameter("value");
		
		long sum = calculate(operation, value);
		resp.getOutputStream().println("Sum is "+sum);
	}

	private long calculate(String operation, String value) {
		switch (operation)
		{
		case "add" : 
			calculator.add(Long.valueOf(value));
			break;
		case "sub" :
			calculator.sub(Long.valueOf(value));
			break;
		}
		
		return calculator.sum();
	}

	
}
