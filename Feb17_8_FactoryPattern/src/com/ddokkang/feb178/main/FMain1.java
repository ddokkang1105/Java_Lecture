package com.ddokkang.feb178.main;

import com.ddokkang.feb178.register.Academy;
import com.ddokkang.feb178.register.Student;

// 객체가 필요없다 : static 메소드 기반
// 객체가 있기는 해야함
//			하나 : Singleton 패턴
//			여러개 : 
//					대량생산, 자동화된 : Factory 패턴
//					나머지 : 여태까지 했던 걸로 !

public class FMain1 {
	public static void main(String[] args) {
		Academy ac = new Academy();
		
		Student s1 = ac.consult("aa", 20);
		s1.printInfo();
		System.out.println("=======================");
		Student s2 = ac.consult("bb", 21);
		s2.printInfo();
		System.out.println("=======================");
		Student s3 = ac.consult("cc", 22);
		s3.printInfo();
		System.out.println("=======================");
		
		
		
		
	}
}
