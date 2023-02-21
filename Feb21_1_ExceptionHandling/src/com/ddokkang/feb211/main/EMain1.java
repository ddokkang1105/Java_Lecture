package com.ddokkang.feb211.main;

import java.util.InputMismatchException;
import java.util.Scanner;

// error
//			�ѱ��� - ���� -> ����
//			���			apple
//			�ٳ���			banana
//			����			????
//		Java�� ������ �� �°� �Ἥ �������� �Ұ����� ����
//		�������� �߸� !
//		�ϼ����� ������ ����

// warning
//		�������� �ڵ�
//		�������� �߸� !
//		�������� �����ϴ� => �ϼ����� ���� ( �����ϴ� �� ���� ���� ! )
//		��Ŭ������ �ܼҸ��� ��...
//		ex > Scanner ��ü ����� ���� ����� �� ���� ���

// exception
//		���α׷��� 100% �ϼ� !
//		������ �� ���� �ܺ����� ���ο� ���ؼ� �۵��� ����� �ȵǴ� ��Ȳ...
//		������ �߸��� �ƴ�
//		������ ���� -> �����ڰ� ��Ȳ�� �����ؼ� ��å�� �������� ...!

// Exception ó���� �� �� �ִ� ��� !
// try-catch !!
//try {
//		�ϴ� �� �κ��� ���� - (����)
//} catch (���������� ������) {
//		try���� �����ϴٰ� �ش� ������ Exception�� �߻��ϸ� �� �κ��� ����
//		����, ���� ���� ���������� ������� ���, catch �κ��� �׳� ����ġ��
//		�� ���� �ڵ带 ����
//} finally {
//		���������� ���α׷� ����, ���� �߻� ������� ����
//		return ���� ���� ����
//}

// �ΰ��� ������ ���ÿ� ���� ��� ? => ���� ���� catch�� ���븸 ���� !
// Java �� ���忡�� ù��° ���ܰ� �߻����� ��
// ��� ���� ���� �� �ش� ����ó�� �κ����� �Ѿ�� ������ !

// Exception
// �� ~ �� Exception�� ����ִ� ~

// e.printStackTrace();
// ��Ȳ ��� (�����ڿ�)

public class EMain1 {
	public static void main(String[] args) {
		
		Scanner k = new Scanner(System.in);
		int x = 0;
		int y = 0;
//		while (true) {
//			try {
//				System.out.print("X : ");
//				x = k.nextInt();
//				System.out.print("Y : ");
//				y = k.nextInt();
//				System.out.println(x + y);
//				System.out.println(x - y);
//				System.out.println(x * y);
//				System.out.println(x / y);
//				break;
//			} catch (InputMismatchException e) {
//				System.out.println("�ٽ� �Է����ּ���.");
//			} finally {
//				k = new Scanner(System.in);
//			}
//		}
		
		System.out.print("X : ");
		x = k.nextInt();
		System.out.print("Y : ");
		y = k.nextInt();
		System.out.println(x + y);
		System.out.println(x - y);
		System.out.println(x * y);
//		System.out.println(x / y);

		// x : 10, y : 0 => 76,77,78,86,87,91,92
		// x : 10, y : 1 => 76,77,78,86,87,88,89,90,93,94
		// x : 2, y : 1 => 76,77,78,86,87,88,89,90
		
//		try {
//			int d = x / y;
//			System.out.println(d);
//			int[] ar = {1, 2, 3};
//			System.out.println(ar[x]);
//		} catch (ArithmeticException ae) {
//			System.out.println("0���� ��� ������ ��.��");
//		} catch (IndexOutOfBoundsException iobe) {
//			System.out.println("�迭 �ε��� ��.��");
//		}
		
		try {
			int d = x / y;
			System.out.println(d);
			int[] ar = {1, 2, 3};
			System.out.println(ar[x]);
		} catch (Exception e) {
			System.out.println("��.��");
			e.printStackTrace();
		} finally {
			System.out.println("��������");
		}
	}
}
