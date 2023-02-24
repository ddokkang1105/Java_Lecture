package com.ddokkang.feb242.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

// Set �迭
//		����������
//		�ߺ������� �ڵ� ����
//			���� ��ü�� ������ ���� �ϳ��� ����
//		������ ����
//		HashSet, TreeSet, ...
//			=> ���������� �״� ���������� ����


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
		// ArrayList�� �����͸� �޾ƿ��� !
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
		HashSet<Integer> hs2 = new HashSet<Integer>(al); // set�� list�� ��Ƽ� �ߺ� ���� !
		for (Integer i : hs2) {
			System.out.println(i);
		}
		System.out.println("==================");
		al = new ArrayList<Integer>(hs2); // �ߺ� ���� �� �ٽ� list��
		
		// �������� ����
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
