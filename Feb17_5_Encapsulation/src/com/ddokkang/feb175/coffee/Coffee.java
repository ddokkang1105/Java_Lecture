package com.ddokkang.feb175.coffee;

public class Coffee {

	private String name;
	private int price;

	public Coffee() {
		// TODO Auto-generated constructor stub
	}

	public Coffee(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void getPrice(int price) {
		this.price = price;
	}

	public void printInfo() {
		System.out.printf("Name : %s\n", name);
		System.out.printf("Price : £Ü %,d\n", price);
	}

	
}
