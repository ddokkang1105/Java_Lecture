package com.ddokkang.feb175.main;

import javax.swing.JFrame;

import com.ddokkang.feb175.coffee.Coffee;
import com.ddokkang.feb175.person.Person;

// ĸ��ȭ ( Encapsulation )
//		��������� ������ �� �ִ� ��� ! �� ����� �� ��ο� ������ġ�� �ϴ� ���� !
//		�� ! �ܺο� ������ �� �ʿ䰡 ���� �������� ĸ��ó�� ���μ� '����'�ϴ� ���


public class EMain1 {
	public static void main(String[] args) {
		
		// Ÿ��Ʋ�� lol�� JFrame
		
//		JFrame f = new JFrame("lol");
//		
//		// ����� 300, 500 ����
//		f.setSize(300, 500);
//		
//		// Ÿ��Ʋ�� ����
//		f.setTitle("lolol");
//		
//		// ���̰� �ϰ� ����
//		// f.show();
//		f.setVisible(true);
		
		// Ŀ��...
		// �̸��� �Ƹ޸�ī��, ������ 3000��
		// ���
		
		Coffee c = new Coffee("Americano", 3000);
		c.printInfo();
		System.out.println("=========================");
		
		Person p = new Person();
		p.setName("Kim");
		p.setAge(-23);
		System.out.println(p.getAge());
		
	}
}
