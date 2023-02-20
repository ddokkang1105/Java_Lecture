package com.ddokkang.feb176.main;

import com.ddokkang.feb176.avengers.Avengers;
import com.ddokkang.feb176.avengers.IronMan;

// �߻� �޼ҵ� ��ü ����
// Avengers�κ��� ��ӹ���..
// Ŭ�������� ��
// ���ο� ����� ���� Ŭ����
// �� �� ���� ���� �� �ְ�, ���� �ϳ��� ��ü���� ����� �� �ִ� 1ȸ�� Ŭ����
//	( = �ٸ� ������ �ҷ��� �� ����)

// �͸� ���� Ŭ����(anomy inner class)

// ������ ( Polymorphism )
// Poly + Morph
// ���� ���������� �ٸ� ����� �� �� �ִ� ... ! (Overriding�� ������ ����)

public class AMain2 {
	public static void main(String[] args) {
		Avengers a = new Avengers("Peter", 19) {
			
			@Override
			public void attack() {
				System.out.println("spider man ~ ~ ");
			}
		};
		a.printInfo();
		a.attack();
		
		System.out.println("==========================");
		IronMan i = new IronMan("Tony Stark", 40, 1234546412);
		i.printInfo();
		i.attack();
		i.smoke();
		i.drive();
		System.out.println("==========================");
	}
	
	
}
