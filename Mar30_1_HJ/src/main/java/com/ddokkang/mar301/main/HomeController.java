package com.ddokkang.mar301.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if (!request.getParameterNames().hasMoreElements()) {
//			request.getRequestDispatcher("OddEven.jsp").forward(request, response);
//		} else {
//			OddEven oe = OddEven.getOe();
//			oe.getResult(request);
//			request.getRequestDispatcher("OddEven.jsp").forward(request, response);
//		}
		
		if (request.getParameterNames().hasMoreElements()) {
			OddEven.getOe().getResult(request);
		} 
		request.getRequestDispatcher("OddEven.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
