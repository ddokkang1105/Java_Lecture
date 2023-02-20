package com.ddokkang.feb172.product;

public class Product {
	String name;
	int price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public void printInfo() {
		System.out.printf("Name : %s\n", name);
		System.out.printf("Price : %d\n", price);
	}
}
