package com.ddokkang.apr031.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddokkang.apr031.dto.AppleDAO;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	
	// ��Ĺ�� �� ������Ʈ�� ó�� �����ų ��
	public HomeController() {
		// ��� ������ �� ���� ��������
		AppleDAO.getAppledao().countApples();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("content", "title.jsp");
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
