package com.ddokkang.feb176.main;

import com.ddokkang.feb176.avengers.Avengers;
import com.ddokkang.feb176.avengers.IronMan;

// 추상 메소드 객체 생성
// Avengers로부터 상속받은..
// 클래스명은 모름
// 내부에 만들어 놓은 클래스
// 단 한 번만 사용될 수 있고, 오직 하나의 객체만을 사용할 수 있는 1회용 클래스
//	( = 다른 곳에서 불러올 수 없음)

// 익명 내부 클래스(anomy inner class)

// 다형성 ( Polymorphism )
// Poly + Morph
// 같은 형태이지만 다른 기능을 할 수 있는 ... ! (Overriding과 밀접한 관련)

public class AMain2 {
	public static void main(String[] args) {
		Avengers a = new Avengers("Peter", 19) {
			
			@Override
			public void attack() {
				System.out.println("spider man ~ ~ ");
			}
		};
		a.printInfo();
		a.attack();
		
		System.out.println("==========================");
		IronMan i = new IronMan("Tony Stark", 40, 1234546412);
		i.printInfo();
		i.attack();
		i.smoke();
		i.drive();
		System.out.println("==========================");
	}
	
	
}
