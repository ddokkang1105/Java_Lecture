package com.ddokkang.mar292.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class RSPEngine {
	private int t = 0;
	private int win = 0;
	private int draw = 0;
	private int lose = 0;
	
	private static final RSPEngine RSPE = new RSPEngine();
	
	public RSPEngine() {
		// TODO Auto-generated constructor stub
	}

	public static RSPEngine getRspe() {
		return RSPE;
	}
	
	public void calculate(HttpServletRequest request) {
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
		
		if (rspNum == comNum) {
			draw++;
			t++;
		} else {
			switch (rspNum - comNum) {
			case -1: case 2:
				// Win
				win++;
				t++;
				break;
			case -2: case 1:
				// Lose
				lose++;
				t++;
				break;
			}
		}
		
		String result = "Total Game : " + t + " Win : " + win + " Draw : " + draw + " Lose: " + lose; 		
		request.setAttribute("rspe", RSPE);
		request.setAttribute("result", result);
		

	}
	
}
