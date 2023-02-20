package com.ddokkang.feb178.register;

public class Academy {
	private int studentCount;
	
	public Student consult(String name, int age) {
		studentCount++;
		Student s = new Student(studentCount, name, age);
		return s;
	}
	
	
	
	
	
	
//	private String stuName;
//	private int stuAge;
//	
//	public Academy() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Academy(String stuName, int stuAge) {
//		super();
//		this.stuName = stuName;
//		this.stuAge = stuAge;
//	}
//
//	public String getStuName() {
//		return stuName;
//	}
//
//	public void setStuName(String stuName) {
//		this.stuName = stuName;
//	}
//
//	public int getStuAge() {
//		return stuAge;
//	}
//
//	public void setStuAge(int stuAge) {
//		this.stuAge = stuAge;
//	}
//	
//	public void printStuInfo() {
//		System.out.println(num);
//		System.out.printf("Name : %s\n", stuName);
//		System.out.printf("Age : %d\n", stuAge);
//	}
	
	
}
