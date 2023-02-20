package com.ddokkang.feb178.register;

public class Student {
	private int num;
	private String name;
	private int age;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int num, String name, int age) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
	}
	
	public void printInfo() {
		System.out.printf("No.%d\n", num);
		System.out.printf("Name : %s\n", name);
		System.out.printf("Age : %d\n", age);
	}
	
	
	
	
	
	
	
	
	
//	public Student() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	public Student(String name, int age) {
//		super(name, age);
//	}
//	
//	@Override
//	public void printStuInfo() {
//		// TODO Auto-generated method stub
//		super.printStuInfo();
//	}
	
}
