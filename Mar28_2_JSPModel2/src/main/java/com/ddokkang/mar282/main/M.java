package com.ddokkang.mar282.main;

import javax.servlet.http.HttpServletRequest;

public class M {
	// Model : �Ϲ� Java Class
	//	���� ���� (���, DB, ...)
	
	// back-end������ B
	public static void add(HttpServletRequest request) { // ��û��ü
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = x + y;
		request.setAttribute("z", z);
	}
}


















