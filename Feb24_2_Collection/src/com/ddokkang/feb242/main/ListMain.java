package com.ddokkang.feb242.main;

import java.util.ArrayList;
import java.util.Comparator;

// ArrayList
//	��Ҹ� �ε����� ����ϴ� ���� �迭�� ����
//	�迭 -> ����� ���� -> ������ ���� �迭�� ũ�⺸�� �������� ������ �Ұ��� !
//	ArrayList : ����Ǵ� �������� ���� ���� ũ�Ⱑ �ڵ������� ����
//				��Ұ� �������� �Ǹ� ArrayList�� ũ�⸦ �������� ������Ű��, �ݴ뵵 �������� !
//				�ڷ����� ��� �����͸� �ִ°� ���� ! - ���� ? -> ��...

// �ڷ����� �����ϰ� �ʹ� !
//	<	> - generic
//		�ڷ����� �����ϴ� ����
//		Ŭ������<�ڷ����� ��ü��> ���� ������...


public class ListMain {
	public static void main(String[] args) {
		ArrayList test = new ArrayList();
		test.add("�߼�");
		test.add(223);
		test.add(2.24);
		test.add(true);
		for (Object object : test) {		// �ڷ����� ���ϵ��� �ʾƼ� object��°� �򰥸�
//			System.out.println(object);
		}
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Ŀ��");
//		al.add(23);
//		al.add(1.123);
		
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(new Integer(23));
		al2.add(23);		// Auto-Boxing
		
		System.out.println(al2);
		System.out.println(al2.get(0));		// �ش� �ε����� ��
		System.out.println(al2.get(1));		
		System.out.println(al2.size());		// ����� ����
		System.out.println("=======================================");
		al2.add(30);
		al2.add(1, 90); 		// 1�� �ڸ��� 90 �ֱ�
		al2.set(2, 0);			// 2�� �ڸ��� 0���� �ٲٱ�
		al2.remove(0);			// 0���ڸ��� �ִ� ���� �����
		
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
				
//				return o1.compareTo(o2);		// ��������
				return o2.compareTo(o1);		// ��������
			}
		};
		al2.sort(c1);
		for (Integer ii : al2) {
			System.out.println(ii);
		}
	
	
	
	
	}
}
