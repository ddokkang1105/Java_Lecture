package com.ddokkang.mar282.main;

import javax.servlet.http.HttpServletRequest;

public class M {
	// Model : 일반 Java Class
	//	실제 업무 (계산, DB, ...)
	
	// back-end개발자 B
	public static void add(HttpServletRequest request) { // 요청객체
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = x + y;
		request.setAttribute("z", z);
	}
}


















