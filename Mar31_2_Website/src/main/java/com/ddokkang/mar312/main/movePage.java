package com.ddokkang.mar312.main;

import javax.servlet.http.HttpServletRequest;

public class movePage {
	public static void moveHome(HttpServletRequest request) {
		request.setAttribute("content", "home.jsp");
	}
	
	public static void movePage(HttpServletRequest request) {
		int m = Integer.parseInt(request.getParameter("m"));
		System.out.println(m);
		switch (m) {
		case 0:
			request.setAttribute("content", "home.jsp");
			break;
		case 1:
			request.setAttribute("content", "menu1.jsp");
			break;
		default:
			request.setAttribute("content", "home.jsp");
			break;
		}
	}
}
