package com.ddokkang.feb176.avengers;

import javax.print.attribute.standard.PrinterInfo;

import com.ddokkang.feb176.driver.Driver;
import com.ddokkang.feb176.smoker.Smoker;

public class IronMan extends Avengers implements Smoker, Driver {
//	String attribute;
//	String smoke;
//	String drive;
	int property;
	
	public IronMan() {
		// TODO Auto-generated constructor stub
	}

//	public IronMan(String name, int age, String attribute, String smoke, String drive) {
//		super(name, age);
//		this.attribute = attribute;
//		this.smoke = smoke;
//		this.drive = drive;
//	}
//	
//	
//	@Override
//	public void printInfo() {
//		super.printInfo();
//		System.out.printf("Attribute : %s\n", attribute);
//		System.out.printf("Smoke : %s\n", smoke);
//		System.out.printf("Drive : %s\n", drive);
//	}
//	
	public IronMan(String name, int age, int property) {
	super(name, age);
	this.property = property;
}

	
	public int getProperty() {
		return property;
	}

	public void setProperty(int property) {
		this.property = property;
	}

	@Override
		public void printInfo() {
			// TODO Auto-generated method stub
			super.printInfo();
			System.out.printf("Property : %d\n", property);
		}
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("Beeeeeeeeeeeem !!!");
	}
	
	@Override
		public void smoke() {
			// TODO Auto-generated method stub
		System.out.println("Buuuuuo !");	
		}
	
	@Override
		public void drive() {
			// TODO Auto-generated method stub
			System.out.println("buaaaaaaaaaaaang ~");
		}
	
}
