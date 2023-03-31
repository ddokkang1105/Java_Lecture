package com.ddokkang.mar313.main;

import javax.servlet.http.HttpServletRequest;

public class GetNumber {
	public static void getNumber(HttpServletRequest request) {
		double x = Double.parseDouble(request.getParameter("x"));
		double y = Double.parseDouble(request.getParameter("y"));
		
		double sum = x + y;
		double minus = x - y;
		double mul = x * y;
		double divide = x / y;
		
		request.setAttribute("sum", sum);
		request.setAttribute("s", " + ");
		request.setAttribute("minus", minus);
		request.setAttribute("mi", " - ");
		request.setAttribute("mul", mul);
		request.setAttribute("mu", " X ");
		request.setAttribute("divide", divide);
		request.setAttribute("d", " ¡À ");
		request.setAttribute("equal", " = ");
	}
}
