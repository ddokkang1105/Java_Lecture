package com.ddokkang.feb242.main;

import java.util.ArrayList;
import java.util.Comparator;

// ArrayList
//	요소를 인덱스로 사용하는 것이 배열과 유사
//	배열 -> 사이즈가 고정 -> 데이터 수가 배열의 크기보다 많아지면 저장이 불가능 !
//	ArrayList : 저장되는 데이터의 수에 따라서 크기가 자동적으로 변경
//				요소가 가득차게 되면 ArrayList의 크기를 동적으로 증가시키고, 반대도 마찬가지 !
//				자료형을 섞어서 데이터를 넣는게 가능 ! - 좋다 ? -> 흠...

// 자료형을 통일하고 싶다 !
//	<	> - generic
//		자료형을 고정하는 역할
//		클래스명<자료형의 객체형> 값을 넣으면...


public class ListMain {
	public static void main(String[] args) {
		ArrayList test = new ArrayList();
		test.add("추석");
		test.add(223);
		test.add(2.24);
		test.add(true);
		for (Object object : test) {		// 자료형이 통일되지 않아서 object라는게 헷갈림
//			System.out.println(object);
		}
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("커피");
//		al.add(23);
//		al.add(1.123);
		
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(new Integer(23));
		al2.add(23);		// Auto-Boxing
		
		System.out.println(al2);
		System.out.println(al2.get(0));		// 해당 인덱스의 값
		System.out.println(al2.get(1));		
		System.out.println(al2.size());		// 요소의 개수
		System.out.println("=======================================");
		al2.add(30);
		al2.add(1, 90); 		// 1번 자리에 90 넣기
		al2.set(2, 0);			// 2번 자리를 0으로 바꾸기
		al2.remove(0);			// 0번자리에 있는 값을 지우기
		
		for (Integer ii : al2) {
			System.out.println(ii);
		}
		System.out.println("=======================================");
		al2.add(84);
		al2.add(150);
		al2.add(21);
		al2.add(32);
		al2.add(5);
		System.out.println("=======================================");
		Comparator<Integer> c1 = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				
//				return o1.compareTo(o2);		// 오름차순
				return o2.compareTo(o1);		// 내림차순
			}
		};
		al2.sort(c1);
		for (Integer ii : al2) {
			System.out.println(ii);
		}
	
	
	
	
	}
}
