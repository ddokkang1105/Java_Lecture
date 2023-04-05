package com.ddokkang.apr031.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddokkang.apr031.dto.AppleDAO;

@WebServlet("/AppleDetailController")
public class AppleDetailController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (AppleDAO.getAppledao().getAppleDetail(request)) {
			request.setAttribute("content", "detail.jsp");
		} else {
			AppleDAO.getAppledao().getApples(1, request);
			request.setAttribute("content", "detail.jsp");
		}
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppleDAO.getAppledao().changeApple(request);
		AppleDAO.getAppledao().getApples(1, request);
		request.setAttribute("content", "m1.jsp");
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
		// ∞≠ªÁ¥‘ «Æ¿Ã
//		if (AppleDAO.getAppledao().update(request)) {
//			AppleDAO.getAppledao().getApples(1, request);
//			request.setAttribute("content", "m1.jsp");
//		} else {
//			request.setAttribute("content", "title.jsp");
//		}
//		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
