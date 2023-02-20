package com.ddokkang.feb201.person;

import com.beaver.feb201.avengers.Avengers;

public class Person {
	private String name;
	private Avengers hero;
	
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name) {
		super();
		this.name = name;
		System.out.println("Ummm ~ I'm " + name + "!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void chooseHero(Avengers a) {
		hero = a;
	}
	
	public void sayHelp() {
		System.out.println("Help ~~ !!");
		hero.attack();
	}
}
