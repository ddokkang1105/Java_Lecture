package com.ddokkang.apr061.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddokkang.apr061.member.MemberDAO;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.logout(request);
		MemberDAO.loginCheck(request);
		request.setAttribute("content", "title.jsp");
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.login(request, response);
		MemberDAO.loginCheck(request);
		request.setAttribute("content", "title.jsp");
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
