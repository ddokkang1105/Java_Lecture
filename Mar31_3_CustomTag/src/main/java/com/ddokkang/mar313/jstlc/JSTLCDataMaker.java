package com.ddokkang.mar313.jstlc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class JSTLCDataMaker {
	
	public static void make(HttpServletRequest request) {
		int[] ar = {123, 456, 78, 91, 234};
		request.setAttribute("ar", ar);
		
		ArrayList<Ddokkang> al = new ArrayList<Ddokkang>();
		al.add(new Ddokkang("Ddobot", 3, 50.3, 10.6));
		al.add(new Ddokkang("Ddobat", 2, 39.2, 12.8));
		al.add(new Ddokkang("Ddabat", 5, 57.8, 30.9));
		al.add(new Ddokkang("Ddubot", 7, 12.4, 6.5));
		request.setAttribute("al", al);
		
		
	}
	
	
}
