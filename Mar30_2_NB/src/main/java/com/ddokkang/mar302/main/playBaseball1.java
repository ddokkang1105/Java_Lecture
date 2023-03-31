package com.ddokkang.mar302.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class playBaseball1 {
	private int t = 0;
	private String result = null;
	
	
	private playBaseball1() {
		
		// TODO Auto-generated constructor stub
	}
	
	private static final playBaseball1 pb1 = new playBaseball1();
	

	public static playBaseball1 getPb1() {
		return pb1;
	}
	
	public void pickAns() {
		int a = new Random().nextInt(976) + 12;	// 12 ~ 987
		String ans = String.format("%03d", a);
		
		if (ans.charAt(0) == ans.charAt(1)
			|| ans.charAt(0) == ans.charAt(2)
			|| ans.charAt(1) == ans.charAt(2)) {
			pickAns();
			return;
		}
		this.result = ans;
	}
	
	public void playBall(HttpServletRequest request) {
		String comNumStr = result;
		String[] comNum = result.split("");
		System.out.println(comNum[0]);
		System.out.println(comNum[1]);
		System.out.println(comNum[2]);
//		System.out.println("------------------------------------");
		
		String myNumStr = request.getParameter("input");
		String[] myNum = myNumStr.split("");
//		System.out.println(myNum[0]);
//		System.out.println(myNum[1]);
//		System.out.println(myNum[2]);
		String ans = null;
		int s = 0;
		int b = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (comNumStr.charAt(i) == myNumStr.charAt(j)) {
					if (i == j) {
						s++;
					} else {
						b++;
					}
				}
			}
		}
		t++;
//		System.out.println(b + "B " + s + "S");
//		System.out.println("------------------------------------");
		request.setAttribute("t", "Total Game : " + t);
		request.setAttribute("ans", b + "B " + s + "S");

		if (s == 3) {
			request.setAttribute("ans", "Correct!");
			t = 0;
			request.setAttribute("t", null);
			request.setAttribute("button", "<button onclick='gogohome();'>Replay</button>");
		}
	}
}
