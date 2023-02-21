package com.ddokkang.feb211.caltool;

public class PriceOfGram {
	private int price;
	private int gram;

	public PriceOfGram() {
		// TODO Auto-generated constructor stub
	}

	public PriceOfGram(int price, int gram) {
		super();
		this.price = price;
		this.gram = gram;
	}

	// 정상 : 			21,22,23,26,27
	// 무게값으로 0 :	21,22,24,25,26,27
	
	public void calculate() {
			try {
				int result = price / gram;
				System.out.printf("Price per Gram : %d\n", result);
			} catch (Exception e) {
				System.out.println("Wrong Input");
			} finally {
				System.out.println("kk");
			}
	}
	
	// 미루기 : throws -> try보다 더 주력
	// method throws Exception
	// Exception이 발생하면 method에서 해결해라 !
	
	public int divide2() throws Exception {
		int d = price / gram;
		return d;
	}
}
