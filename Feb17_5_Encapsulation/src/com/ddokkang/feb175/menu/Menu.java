package com.ddokkang.feb175.menu;

// ���� !

// ����Ű �ɱ�
//		Window - Preferences - Keys - generate 
//		- Generate getters and setters - Ctrl + Shift + z

// 1. ��� ���� ( �ܺο��� ���� �ȵǵ��� private !! )
// 2. �⺻ ������
// 3. ������ �����ε�
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
