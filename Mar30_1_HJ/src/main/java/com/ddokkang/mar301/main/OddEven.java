package com.ddokkang.mar301.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class OddEven {
	private int t = 0;
	private int win = 0;
	private int lose = 0;
	
	private OddEven() {
		// TODO Auto-generated constructor stub
	}
	
	private static final OddEven OE = new OddEven();

	public static OddEven getOe() {
		return OE;
	}
	
	public void getResult(HttpServletRequest request) {
		int oeNum = new Random().nextInt(Integer.MAX_VALUE) + 1;
		String oeStr  = null;
		if (oeNum % 2 == 0) {
			oeStr = "Even";
		} else {
			oeStr = "Odd";
		}
		String oeNumToStr = String.format("%,d", oeNum);
		request.setAttribute("oeNum", "Ans : " + oeNumToStr);
		request.setAttribute("oeStr", oeStr);
		
		String ans = null;
		int choice = Integer.parseInt(request.getParameter("g"));
		
		if (oeNum % 2 == choice) {
			ans = "Correct";
			win++;
			t++;
		} else {
			ans = "Wrong";
			lose++;
			t++;
		}
		
		request.setAttribute("ans", "My Answer is " + ans);
		request.setAttribute("result", "\"" + t + "\" Game \'" + win + "\' Win \'" + lose + "\' lose");
		
	}
}
