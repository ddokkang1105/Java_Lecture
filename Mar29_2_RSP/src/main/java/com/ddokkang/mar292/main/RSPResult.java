package com.ddokkang.mar292.main;

public class RSPResult {
	// RSPCalculator와 합치기 !!
	
	private int win = 0;
	private int draw = 0;
	private int lose = 0;
	
	public RSPResult() {
		// TODO Auto-generated constructor stub
	}

	public RSPResult(int win, int draw, int lose) {
		super();
		this.win = win;
		this.draw = draw;
		this.lose = lose;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}
	
	

}
