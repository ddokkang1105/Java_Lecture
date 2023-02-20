package com.ddokkang.feb175.menu;

// 정리 !

// 단축키 심기
//		Window - Preferences - Keys - generate 
//		- Generate getters and setters - Ctrl + Shift + z

// 1. 멤버 변수 ( 외부에서 접근 안되도록 private !! )
// 2. 기본 생성자
// 3. 생성자 오버로딩
// 4. getter / setter

public class Menu {
	
	private String name;
	private int price;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(String name, int price) {
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

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
