package com.ddokkang.apr031.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddokkang.apr031.dto.Apple;
import com.ddokkang.apr031.dto.AppleDAO;

@WebServlet("/M1Controller")
public class M1Controller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("content", "m1.jsp");
//		Apple.getApple(request);
//		request.getRequestDispatcher("home.jsp").forward(request, response);
//		AppleDAO.getAppledao().getAllApples(request);
		AppleDAO.getAppledao().getApples(1, request);
		request.setAttribute("content", "m1.jsp");
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
