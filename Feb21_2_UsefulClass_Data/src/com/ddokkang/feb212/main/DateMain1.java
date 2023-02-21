package com.ddokkang.feb212.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// ***�߿�***
// Date.java : ��~~~~~�� ����(1900���) ������� Class
//			Y2K�� ������ ���� ����
//			���� ������ ���� ����
//			1900��� ��ÿ� �뷮�� ������ ������ �������� 2�ڸ���...
//			1970��� ������ ��ǻ�� : �ӵ��� ��û ������, ��ġ�� �뷮�� ������.
//			�������� ���� �Ƴ��� ���ؼ� ����ó�� 4byte�� �ƴ� 2byte�� �Ҵ�
//			������ ���� !
//			1900��, 2000�� ���� ���ڸ��� 00���� �ν��ؼ� ���ϵ� !
//			-> ������ �Ұ��������� ! -> ��ǻ���� ���۵� ���ɼ��� ������ ���̶� ����,,,!
//			�ٵ� ���� ������ ��

// Date : ��¥ / �ð� 

// �⺻���� -> ���� �ð� / ��¥
// import java.util.Date;
// ���� -> ����⵵ - 1900
// System.out.println(now.getYear() + 1900);
// �� -> 0 : January
// System.out.println(now.getMonth() + 1);
// ��
// System.out.println(now.getDate());
// ���� -> 0 : Sunday
// System.out.println(now.getDay());
// String[] day = { "��", "��", "ȭ", "��", "��", "��", "��" };
// System.out.println(day[now.getDay()]);

// deprecated
//		������ �帣��, ��ǻ�͵� ���� -> ������ ����� ������ ��������...
//		���α׷��� �� ������Ʈ�� �Ǿ�� �ϴµ�...
//		���ּ��� / ����� ������ ��ȹ�� ���ܹ���
//		���� �ڹٹ��������� OK ! / ���� �������� �������� �Ҹ������� ���Ŷ� ~

// Date - �������� -> String
// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E a hh:mm", Locale.CANADA);
// String s1 = sdf.format(now);
// System.out.println(s1);


// Ư�� �ð� ��¥
// Date d2 = new Date(2023, 2, 14);

// String - ���� ���� -> Date
//		try {
//			String s2 = "2000-02-14";
//			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//			Date d3 = sdf2.parse(s2);
//			System.out.println(d3);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("============================");

// Calender / Local~~~
// �� �� ������...?

public class DateMain1 {
	public static void main(String[] args) {
//		Date now = new Date();
//		System.out.println(now);
//		
//		System.out.println(now.getYear() + 1900);
//		System.out.println(now.getMonth() + 1);
//		System.out.println(now.getDate());
////		System.out.println(now.getDay());
//		String[] day = { "��", "��", "ȭ", "��", "��", "��", "��" };
//		System.out.println(day[now.getDay()]);
//		System.out.println("============================");
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E a hh:mm");
//		
//		String s1 = sdf.format(now);
//		System.out.println(s1);
//		System.out.println("============================");
//		
////		Date d2 = new Date(2023, 2, 14);
//		Date d2 = new Date(123, 2, 14);
//		System.out.println(d2);
//		System.out.println("============================");
//		
//		try {
//			String s2 = "2000-02-14";
//			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//			Date d3 = sdf2.parse(s2);
//			System.out.println(d3);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("============================");
		
		try {
			String s3 = "2013/02/21";
			SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd");
			Date d4 = sdf3.parse(s3);
//			d4.setMonth(1);
//			System.out.println(d4);
//			System.out.println(day[d4.getDay()]);
//			System.out.printf("10�� �� ���� ��¥�� ���� : %s\n", day[d4.getDay()]);
			
			SimpleDateFormat sdf4 = new SimpleDateFormat("E");
			String dayy = sdf4.format(d4);
			System.out.printf("10�� �� ���� ��¥�� ���� : %s\n", dayy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("============================");
		
		
		
	}
}
