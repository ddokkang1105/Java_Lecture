package com.ddokkang.feb242.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

// Set 계열
//		가변사이즈
//		중복데이터 자동 삭제
//			같은 객체가 여러번 들어가면 하나만 남김
//		순서가 랜덤
//		HashSet, TreeSet, ...
//			=> 실전에서는 그닥 유용하지는 않음


public class SetMain {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("lalala");
		hs.add("zz");
		hs.add("kk");
		hs.add("zz");
		hs.add("zaza");
		hs.add("lalala");
		System.out.println(hs.size());
		System.out.println("==================");
		for (String s : hs) {
			System.out.println(s);
		}
		System.out.println("==================");
		// ArrayList로 데이터를 받아오자 !
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1234);
		al.add(1011);
		al.add(123);
		al.add(132);
		al.add(123);
		al.add(1123);
		al.add(1423);
		al.add(32424);
		al.add(1341);
		al.add(34123);
		al.add(1234);
		al.add(2120);
		al.add(1341);
		System.out.println(al);
		System.out.println("==================");
		HashSet<Integer> hs2 = new HashSet<Integer>(al); // set에 list를 담아서 중복 제거 !
		for (Integer i : hs2) {
			System.out.println(i);
		}
		System.out.println("==================");
		al = new ArrayList<Integer>(hs2); // 중복 제거 후 다시 list로
		
		// 내림차순 정렬
		Comparator<Integer> c = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		};
		al.sort(c);
		for (Integer i : al) {
			System.out.println(i);
		}
	}
}
