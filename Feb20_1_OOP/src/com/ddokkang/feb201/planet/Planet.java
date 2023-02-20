package com.ddokkang.feb201.planet;

import com.ddokkang.feb201.person.Person;

public class Planet {
	private	String name;
	private double size;
	private boolean sight;
	
	public Planet() {
		// TODO Auto-generated constructor stub
	}

	public Planet(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public boolean isSight() {
		return sight;
	}

	public void setSight(boolean sight) {
		this.sight = sight;
	}

	public void printInfo() {
		System.out.printf("Name : %s\n", name);
//		System.out.printf("Size : %s\n", size);
//		System.out.printf("Sight : %s\n", sight);
	}
	
	public void getResident(Person p) {
		System.out.printf("%s moves to this planet %s.\n", p.getName(), name);
	}
}
