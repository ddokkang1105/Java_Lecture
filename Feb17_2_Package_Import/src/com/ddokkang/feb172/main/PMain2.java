package com.ddokkang.feb172.main;

import java.util.Scanner;

// 패키지 : 클래스 명이 중복 될 때 구별할 수 있는 수단 !
//		모든 클래스는 패키지에 넣을 수 있도록 !!


// 패키지 명이 중복 ? 똑같으면...? => 방법이 없음...
//		=> 전 세계적으로 패키지명이 중복 안되게
//		com.회사명.프로그램명.카테고리 (소문자)

// 객체
//		패키지명.클래스명 변수(객체)명 = new 패키지명.생성자();

public class PMain2 {
	public static void main(String[] args) {
		java.util.Random r = new java.util.Random();
		Scanner k = new Scanner(System.in);
		
		com.ddokkang.feb172.product.Scanner s =
				new com.ddokkang.feb172.product.Scanner("", 50000);
		
		
		
		
	}
}
