package com.ddokkang.feb242.main;

import java.util.HashMap;
import java.util.Set;

// Map �迭 (Python : dict)
//		����������
//		<Key, Value>
//		Key���� ��������� �� !
//		���� ���� X
//		HashMap, HashTable, ...


public class MapMain {
	public static void main(String[] args) {
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("�Ƹ޸�ī��", 4000);
		hm.put("������", 5000);
		hm.put("�����̵�", 6000);
		hm.put("������", 7000);	// '������' Key ���� ���� ������
									// ���� �������� ����� Value ������ '����'��
		
		System.out.println(hm.get("������"));	// Key���� �־ Value�� ��� !
		System.out.println("=================================");
		Set<String> k = hm.keySet();	// Key���� ����
		for (String s : k) {
			System.out.println(s);	// Key���� ����, ������ �ߺ� -> �ϳ� ����
			System.out.println(hm.get(s));	// �ش� Key���� �´� Value�� ��� !
			System.out.println("=================================");
		}
		
		
		
		
		
		
		
		
		
	}
}
