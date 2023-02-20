package com.ddokkang.feb175.main;

import javax.swing.JFrame;

import com.ddokkang.feb175.coffee.Coffee;
import com.ddokkang.feb175.person.Person;

// 캡슐화 ( Encapsulation )
//		멤버변수에 접근할 수 있는 통로 ! 를 만들고 그 통로에 안전장치를 하는 개념 !
//		즉 ! 외부에 노출을 할 필요가 없는 정보들을 캡슐처럼 감싸서 '은닉'하는 기능


public class EMain1 {
	public static void main(String[] args) {
		
		// 타이틀이 lol인 JFrame
		
//		JFrame f = new JFrame("lol");
//		
//		// 사이즈를 300, 500 수정
//		f.setSize(300, 500);
//		
//		// 타이틀을 수정
//		f.setTitle("lolol");
//		
//		// 보이게 하고 싶음
//		// f.show();
//		f.setVisible(true);
		
		// 커피...
		// 이름이 아메리카노, 가격이 3000원
		// 출력
		
		Coffee c = new Coffee("Americano", 3000);
		c.printInfo();
		System.out.println("=========================");
		
		Person p = new Person();
		p.setName("Kim");
		p.setAge(-23);
		System.out.println(p.getAge());
		
	}
}
