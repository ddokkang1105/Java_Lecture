package com.ddokkang.apr061.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.el.parser.Token;

import com.ddokkang.apr061.main.TokenManager;
import com.ddokkang.apr061.member.MemberDAO;

@WebServlet("/BoardWriteController")
public class BoardWriteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.loginCheck(request)) {
			BoardDAO.getBdao().write(request);
		}
		TokenManager.make(request);
		BoardDAO.getBdao().getBoardByPage(1, request);
		request.setAttribute("content", "board.jsp");
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}