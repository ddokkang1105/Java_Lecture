package com.ddokkang.feb175.person;

public class Person {
	private String name;
	private int age;
	private double weight;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0) {
			age *= -1;
		}
		this.age = age;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void printInfo() {
		System.out.printf("Name : %s\n", name);
		System.out.printf("Age : %d\n", age);
		System.out.printf("Weight : %.1f\n", weight);
	}
	
}
