package com.ddokkang.feb201.main;

import com.ddokkang.feb201.avengers.Ironman;
import com.ddokkang.feb201.person.Person;
import com.ddokkang.feb201.planet.Planet;

public class OMain1 {
	public static void main(String[] args) {
		Planet p = new Planet("Earth");
		
		Person p1 = new Person("Ji");
		
		p.getResident(p1);
		System.out.println("===================================");
		Ironman i1 = new Ironman();
		
		
		p1.chooseHero(i1);
		p1.sayHelp();
		
		p.setSize(1000);
		p.setSight(true);
		System.out.println("===================================");
		System.out.println(p.getSize());
		System.out.println(p.isSight());
	}
}
