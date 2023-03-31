package com.ddokkang.mar313.jstlf;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class JSTLFDataMaker {
	public static void make(HttpServletRequest request) {
		int a = 123456789;
		request.setAttribute("a", a);
		
		double b = 10 / 24.0;
		request.setAttribute("b", b);
		
		double c = 123.456789;
		request.setAttribute("c", c);
		
		Date now = new Date();
		request.setAttribute("d", now);
		
		// 이거는 <fmt:formatDate /> 로 해결 안됨 !!
		// String e = "2023/03/31";
		// request.setAttribute("e", e);
		
		ArrayList<Snack> snacks = new ArrayList<Snack>();
		snacks.add(new Snack("Potato", 2000, new Date()));
		snacks.add(new Snack("Sweet Potato", 3500, new Date()));
		snacks.add(new Snack("Cheeze", 2800, new Date()));
		snacks.add(new Snack("Onion", 3000, new Date()));
		request.setAttribute("s", snacks);
		
	}
}
