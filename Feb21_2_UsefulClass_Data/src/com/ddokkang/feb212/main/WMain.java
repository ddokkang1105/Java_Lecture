package com.ddokkang.feb212.main;

// Wrapper Class : (�ڷ���) �⺻������ ��ü�� (���尴ü)
//		Integer, Double, Long, Void, Boolean, ...
//		�⺻ �ڷ����� ��ü�� �ٷ�� ���� ����ϴ� Class
//		Java�� �⺻���� ���� ������ �ִ� ��ü ������ ���� !
//		�⺻���� ������ �ִ� ���� ���ο� �ΰ� �� ���� �����ϴ� ��� !
//	Boxing : �⺻�� -> ����Ŭ����
//	UnBoxing : ����Ŭ���� -> �⺻��

// ����ϴ� ����
// 1. ��ü�� Ŭ������ �����ϴ� method ����� ��
// 2. Ŭ������ �����ϴ� ����� ���(MIN_VALUE, MAX_VALUE, ...)
// 3. ����, ���ڷ� ����ȯ�� �� �� (^vvvvvvvvvvv^)

// Integer ��ü ���� -> �������� �־ -> int������ return
//		Integer b = new Integer(a);
//		System.out.println(b.getClass());
//		System.out.println(b);
//		b.intValue();
//		System.out.println(b.TYPE);
//		System.out.println(b.getClass());

// �⺻�� -> ��ü��
//		double c = 123.456;
//		Double d = new Double(c);

// ��ü�� -> �⺻��
//		Boolean e = new Boolean(true);
//		boolean f = e.booleanValue();

// ��ü�� -> �⺻�� ( ���� �������� �ڵ����� ���� : Auto-Unboxing )
//		Integer g = 10;

// �⺻�� -> ��ü��
//		Integer g = 10;
//		int h = g;

// int�� �ִ� / �ּ� ����
//		int max = Integer.MAX_VALUE;
//		int min = Integer.MIN_VALUE;

// String -> �⺻�� ( ���̷�Ʈ�δ� �����, ��ü���� ���ľ� ! )
// String -> ��ü�� -> �⺻��
//		String k = "345.67";
//		Double k2 = Double.parseDouble(k);
//		double k3 = k2.doubleValue();
//		
//		String m = "150";
//		int m2 = Integer.parseInt(m);
//		System.out.println(m2);

public class WMain {
	public static void main(String[] args) {
//		int a = 10;
//		String a1 = "100";
////		double bb = (double) a1;
//
//		Integer b = new Integer(a);
//		System.out.println(b.getClass());
//		System.out.println(b);
//		b.intValue();
//		System.out.println(b.TYPE);
//		System.out.println(b.getClass());
//		
//		double c = 123.456;
//		Double d = new Double(c);
//		
//		Boolean e = new Boolean(true);
//		boolean f = e.booleanValue();
//		
//		Integer g = 10;
//		int h = g;
//		
//		int max = Integer.MAX_VALUE;
//		int min = Integer.MIN_VALUE;
		
//		System.out.println(max);
//		System.out.println(min);
//		System.out.println("==============================");

		String s1 = Integer.toString(10);
		System.out.println(s1 + 10 + 10);
		System.out.println(s1.getClass());
		System.out.println("==============================");
		String s2 = Integer.toBinaryString(10);
		System.out.println(s2);
		System.out.println(s2.getClass());

		String k = "345.67";
		Double k2 = Double.parseDouble(k);
		double k3 = k2.doubleValue();
		
		String m = "150";
		int m2 = Integer.parseInt(m);
		System.out.println(m2);
		
		
	}
}
