package com.ddokkang.mar302.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class playBaseball {
	private int t = 0;
	private String result;
	
	
	private playBaseball() {
		
		// TODO Auto-generated constructor stub
	}
	
	private static final playBaseball pb = new playBaseball();
	

	public static playBaseball getPb() {
		return pb;
	}
	
	public static String pickAns() {
		int a = new Random().nextInt(976) + 12;	// 12 ~ 987
		String ans = String.format("%03d", a);
		
		if (ans.charAt(0) == ans.charAt(1)
			|| ans.charAt(0) == ans.charAt(2)
			|| ans.charAt(1) == ans.charAt(2)) {
			return pickAns();
		}
		return ans;
	}
	
	public void playBall(HttpServletRequest request) {
		String[] comNum = result.split("");
//		int comHundred = Integer.parseInt(comNum[0]);
//		int comTen = Integer.parseInt(comNum[1]);
//		int comOne= Integer.parseInt(comNum[2]);
		System.out.println(comNum[0]);
		System.out.println(comNum[1]);
		System.out.println(comNum[2]);
		System.out.println("------------------------------------");
		
		String myNumStr = request.getParameter("input");
		String[] myNum = myNumStr.split("");
		System.out.println(myNum[0]);
		System.out.println(myNum[1]);
		System.out.println(myNum[2]);
//		int input = Integer.parseInt(request.getParameter("input"));
//		int myHundred = input / 100;
//		int myTen = (input - (myHundred * 100)) / 10;
//		int myOne = (input - (myHundred * 100) - (myTen * 10));
//		System.out.println(myHundred);
//		System.out.println(myTen);
//		System.out.println(myOne);
		System.out.println("------------------------------------");
		// ´ä ¼³Á¤
//		System.out.println(result);
		String ans = null;
		int s = 0;
		int b = 0;
		
		for (int i = 0; i < comNum.length; i++) {
			if (comNum[i] == myNum[i]) {
				s++;
				if (s == 3) {
					break;
				}
			} 
			for (int j = 0; j < myNum.length; j++) {
					if ((comNum[i] == myNum[j]) && (myNum[i] != myNum[j])) {
						b++;
					}
			}
		}
		System.out.println(b + "B " + s + "S");
		
//		if ((comHundred == myHundred) && (comTen == myTen) && (comOne == myOne)) {
//			s = 3;
//			ans = "Correct!";
//		} else if (((comHundred == myHundred) && (comTen == myTen)) || ((comHundred == myHundred) &&
//				(comOne == myOne)) || ((comTen == myTen) && (comOne == myOne))) {
//			s += 2;
//		} else if ((comHundred == myHundred) || (comTen == myTen) || (comOne == myOne)) {
//			s += 1;
//		} else if (((comHundred == myTen) || (comHundred == myOne)) && ((comTen == myHundred) || (comTen == myOne))
//				&& ((comOne == myHundred) || (comOne == myTen))) {
//			b += 3;
//		} else if (((comHundred == myTen) || (comHundred == myOne) && (comTen == myHundred) || (comTen == myOne))) {
//			b += 2;
//		} else if (((comHundred == myTen) || (comHundred == myOne) && (comOne == myHundred) || (comOne == myTen))) {
//			b += 2;
//		} else if (((comTen == myHundred) || (comTen == myOne) && (comOne == myHundred) || (comOne == myTen))) {
//			b += 2;
//		} else if ((comHundred == myTen) || (comHundred == myOne)) {
//			b++;
//		} else if ((comTen == myHundred) ||	(comTen == myOne)) {
//			b++;
//		} else if ((comOne == myHundred) || (comOne == myTen)) {
//			b++;
//		} else {
//			ans = "Out!";
//		}
			
		if (s == 3) {
			t++;
			request.setAttribute("ans", ans);
		} else if ((s == 0) && (b == 0)) {
			t++;
			request.setAttribute("ans", ans);
		} else {
			t++;
			request.setAttribute("ans", b + "B " + s + "S");
		} 
		
		request.setAttribute("t", "Try : " + t);
		
		System.out.println("------------------------------------");
		
	}
	public void getNumber() {
		int comHundred = new Random().nextInt(10);
		int comTen = new Random().nextInt(10);
		int comOne = new Random().nextInt(10);
		String result = null;
		while (true) {
			if ((comTen != comHundred) && (comTen != comOne)
					&& (comOne != comHundred)) {
				break;
			} else if (comTen == comHundred) {
				comTen = new Random().nextInt(10);
			} else if (comOne == comHundred) {
				comOne = new Random().nextInt(10);
			} else if (comOne == comTen) {
				comOne = new Random().nextInt(10);
			}
		}
		result = Integer.toString(comHundred) + Integer.toString(comTen) + Integer.toString(comOne);
//		this.result = result;
	}
}
