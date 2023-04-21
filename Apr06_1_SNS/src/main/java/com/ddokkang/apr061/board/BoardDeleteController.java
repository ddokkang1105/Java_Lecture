package com.ddokkang.apr061.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddokkang.apr061.main.TokenManager;
import com.ddokkang.apr061.member.MemberDAO;

@WebServlet("/BoardDeleteController")
public class BoardDeleteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.loginCheck(request)) {
			request.setAttribute("lp", "");
			BoardDAO.getBdao().deleteBoard(request);
		}
		TokenManager.make(request);
		BoardDAO.getBdao().getBoardMsgByPage(1, request);
		request.setAttribute("content", "board.jsp");
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
