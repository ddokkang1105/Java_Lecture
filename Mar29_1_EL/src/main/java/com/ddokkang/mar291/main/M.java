package com.ddokkang.mar291.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class M {
	public static void multiply(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = x * y;
		request.setAttribute("z", z);
		
		Ddokkang d = new Ddokkang("Ddobot", 3, 190, 80);
		request.setAttribute("d", d);
		
		ArrayList<Ddokkang> dvs = new ArrayList<Ddokkang>();
		dvs.add(d);
		dvs.add(new Ddokkang("Ddubot", 3, 20.0, 9.4));
		dvs.add(new Ddokkang("Ddubut", 3, 40.0, 19.4));
		dvs.add(new Ddokkang("Ddubat", 3, 80.0, 69.4));
		request.setAttribute("dvs", dvs);
		
		
	}
}
