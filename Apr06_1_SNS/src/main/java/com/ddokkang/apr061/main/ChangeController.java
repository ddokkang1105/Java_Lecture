package com.ddokkang.apr061.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddokkang.apr061.member.MemberDAO;

@WebServlet("/ChangeController")
public class ChangeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.loginCheck(request)) {
			MemberDAO.update(request);
			DataManager.getCurYear(request);
			request.setAttribute("lp", "");
			request.setAttribute("content", "change.jsp");
		} else {
			request.setAttribute("content", "title.jsp");
		}
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.loginCheck(request)) {
			MemberDAO.update(request);
			DataManager.getCurYear(request);
			request.setAttribute("content", "");
		} else {
			request.setAttribute("content", "title.jsp");
		}
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
