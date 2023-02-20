package com.ddokkang.feb178.main;

import com.ddokkang.feb178.register.Academy;
import com.ddokkang.feb178.register.Student;

// ��ü�� �ʿ���� : static �޼ҵ� ���
// ��ü�� �ֱ�� �ؾ���
//			�ϳ� : Singleton ����
//			������ : 
//					�뷮����, �ڵ�ȭ�� : Factory ����
//					������ : ���±��� �ߴ� �ɷ� !

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
