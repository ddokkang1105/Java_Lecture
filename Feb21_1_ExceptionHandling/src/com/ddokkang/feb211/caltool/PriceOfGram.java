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

	// ���� : 			21,22,23,26,27
	// ���԰����� 0 :	21,22,24,25,26,27
	
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
	
	// �̷�� : throws -> try���� �� �ַ�
	// method throws Exception
	// Exception�� �߻��ϸ� method���� �ذ��ض� !
	
	public int divide2() throws Exception {
		int d = price / gram;
		return d;
	}
}
