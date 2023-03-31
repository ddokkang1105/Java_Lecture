package com.ddokkang.mar313.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {
			request.setAttribute("content", "calculator.jsp");
			request.setAttribute("calResult", "calOutput.jsp");
		} else {
			GetNumber.getNumber(request);
//			request.setAttribute("content", "calOutput.jsp");
			request.setAttribute("calResult", "calOutput.jsp");
			request.setAttribute("content", "calculator.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
