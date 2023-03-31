package com.ddokkang.mar292.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class RSPCalculator {
	public static void calculator(HttpServletRequest request) {
		Random com = new Random();
//		int comNum = com.nextInt(3);
		int comNum = new Random().nextInt(3);
		
		String r = request.getParameter("r");
		String s = request.getParameter("s");
		String p = request.getParameter("p");
		
		String[] rspInput = {r, s, p};
		
		int rspNum = comNum;
		for (int i = 0; i < rspInput.length; i++) {
			if (rspInput[i] != null) {
				rspNum = Integer.parseInt(rspInput[i]);
				break;
			}
		}
		
		String[] rsp = {"Rock", "scissor", "paper"};
		String myRSP = rsp[rspNum];
		String comRSP = rsp[comNum];
		
		request.setAttribute("myRSP", myRSP);
		request.setAttribute("comRSP", comRSP);
		System.out.println("----------------------------");
		System.out.printf("My : %s\n", myRSP);
		System.out.printf("Com : %s\n", comRSP);
		System.out.println("----------------------------");
		
		RSPResult rspr = new RSPResult();
		System.out.println(rspr.getWin());
		System.out.println(rspr.getDraw());
		System.out.println(rspr.getLose());
		
		if (rspNum == comNum) {
			rspr.setDraw(rspr.getDraw() + 1);
		} else {
			switch (rspNum - comNum) {
			case -1: case 2:
				// Win
				rspr.setWin(rspr.getWin() + 1);
				break;
			case -2: case 1:
				// Lose
				rspr.setLose(rspr.getLose() + 1);
				break;
			}
		}
		
		request.setAttribute("rspr", rspr);
		
	}
}
