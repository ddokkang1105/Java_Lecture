package com.ddokkang.mar292.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class RSPEngine {
	private int t = 0;
	private int win = 0;
	private int draw = 0;
	private int lose = 0;
	
	public RSPEngine() {
		// TODO Auto-generated constructor stub
	}
	
	private static final RSPEngine RSPE = new RSPEngine();

	public static RSPEngine getRspe() {
		return RSPE;
	}
	
	public void calculate(HttpServletRequest request) {
		int comNum = new Random().nextInt(3);
		
		String r = request.getParameter("r");
		String s = request.getParameter("s");
		String p = request.getParameter("p");
		
		String[] rspStr = { r, s, p };		
		
		int rspNum = 0;
		for (int i = 0; i < rspStr.length; i++) {
			if (rspStr[i] != null) {
				rspNum = Integer.parseInt(rspStr[i]);
				break;
			}
		}
		
		String[] rsp = {"Rock", "Scissor", "Paper"};
		String myRSP = rsp[rspNum];
		String comRSP = rsp[comNum];
		
		request.setAttribute("myRSP", "MY RSP : " + myRSP);
		request.setAttribute("comRSP", "COM RSP : " + comRSP);
		
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
		request.setAttribute("result", result);
		
		
		
		
		
		
		
		
	}
}
