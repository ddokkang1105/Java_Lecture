package com.ddokkang.feb176.main;

import com.ddokkang.feb176.animal.Bird;

// abstract method : 미완성된 메소드 ( 내용이 없는 )
// 하위클래스에서 반드시 !! 오버라이딩해서 사용해야 !!

// abstract method 가 하나라도 있으면 
// abstract 클래스 or interface 여야 함 ! 

// 클래스 : 멤버변수, 메소드

// 추상클래스 : 멤버변수, 메소드, 추상메소드
//					=> 객체생성 불가능 !

// 인터페이스 : 추상메소드, 멤버 상수
//					=> 객체생성 불가능 !

// 클래스끼리는 다중상속 X ( 1 : 1 )
// 클래스 + 인터페이스는 다중상속 O !



public class AMain1 {
	public static void main(String[] args) {
		Bird bird1 = new Bird("Check", 93, 2);
		bird1.printInfo();
		bird1.roar();
		bird1.bite();
	}
}
