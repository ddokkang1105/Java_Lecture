package com.ddokkang.feb176.main;

import com.ddokkang.feb176.animal.Bird;

// abstract method : �̿ϼ��� �޼ҵ� ( ������ ���� )
// ����Ŭ�������� �ݵ�� !! �������̵��ؼ� ����ؾ� !!

// abstract method �� �ϳ��� ������ 
// abstract Ŭ���� or interface ���� �� ! 

// Ŭ���� : �������, �޼ҵ�

// �߻�Ŭ���� : �������, �޼ҵ�, �߻�޼ҵ�
//					=> ��ü���� �Ұ��� !

// �������̽� : �߻�޼ҵ�, ��� ���
//					=> ��ü���� �Ұ��� !

// Ŭ���������� ���߻�� X ( 1 : 1 )
// Ŭ���� + �������̽��� ���߻�� O !



public class AMain1 {
	public static void main(String[] args) {
		Bird bird1 = new Bird("Check", 93, 2);
		bird1.printInfo();
		bird1.roar();
		bird1.bite();
	}
}
