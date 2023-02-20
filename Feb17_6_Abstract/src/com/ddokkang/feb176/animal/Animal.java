package com.ddokkang.feb176.animal;

public abstract class Animal {
	private String sort;
	private int age;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(String sort, int age) {
		super();
		this.sort = sort;
		this.age = age;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void printInfo() {
		System.out.printf("Sort : %s\n", sort);
		System.out.printf("Age : %s\n", age);
	}
	
	public abstract void roar();
}
