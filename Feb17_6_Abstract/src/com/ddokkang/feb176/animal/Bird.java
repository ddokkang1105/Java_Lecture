package com.ddokkang.feb176.animal;

import com.ddokkang.feb176.bite.Bite;

public class Bird extends Animal implements Bite {
	private int leg;
	
	public Bird() {
		// TODO Auto-generated constructor stub
	}

	public Bird(String sort, int age, int leg) {
		super(sort, age);
		this.leg = leg;
	}
	
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.printf("Leg : %s\n", leg);
	}
	
	@Override
	public void roar() {
		System.out.println("Check Check !!");
	}
	
	@Override
	public void bite() {
		System.out.println("Bite Everything !!");
	}
}
