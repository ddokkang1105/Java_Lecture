package com.ddokkang.feb212.main;

import java.util.StringTokenizer;

// ��Ʈ��ũ�� ���ؼ� �����͸� �޾ƿ��� : ��������
// ��Ʈ��ũ�� ���ؼ� �����͸� ������ �� : ��������
// �ѱ�ó���� ��ٷο� �� �� ���� !

// �ܿ������� ã�ƺ��� !! (�ڵ��ϼ��� �ִ� ���, ���� �о�鼭 !!)

// charAt() : Ư�� ��ġ�� �ִ� ���ڸ� �̾Ƴ� ��
//		System.out.println(s2.charAt(2));
// startsWith() : �����ϴ� �ܾ �´��� �ƴ��� Ȯ���� �� (true / false)
//		System.out.println(s2.startsWith("��"));
// contains() : ã�� �ܾ �ִ��� (true / false)
//		System.out.println(s2.contains("�ʹ�"));
// replace() : Ư���� ���ڸ� �ٸ� ���ڷ� �ٲ� �� 
//		System.out.println(s2.replace("�ް�", "3��"));
// substring() : ���ϴ� ��ġ�� ���ڸ� ���� �� (������ġ, ����ġ - 1)
//		System.out.println(s2.subSequence(2, 5));

// String ��ü�� �����ϴµ� ������ ��Ƽ�...
// printf�� �����ϴ�
//		String s3 = String.format("���� : %.2fkg", 123.4123);
//		System.out.println(s3);

// String ���� �߰�
//		String s1 = "kk";
//		s1 = new String(s1 + "zz");
//		System.out.println(s1);

// String�� �뷮���� �߰�
//		StringBuffer sb = new StringBuffer(s1);
//		sb.append("wow");
//		sb.append("what?");
//		sb.append("oh god !");
//		System.out.println(sb);
// String Type ���� �����ϱ�
//		String s4 = sb.toString();
//		System.out.println(s4);

// String �и�
//		String s5 = "kim,lee,park,choi";
// 1. split
// ��� �� �� ����
//		String[] s5Ar = s5.split(",");

// 2. StringTokenizer
// ������� ����
//		StringTokenizer st = new StringTokenizer(s5, ",");
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
// while �� Ȱ���Ͽ� ���
//		while (st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}
// �ӵ����� �� : StringTokenizer
// data�ӿ��� ������ ���ٸ� : split

public class TextMain1 {
	public static void main(String[] args) {
		// ���� X -> ��� !
//		String s1 = "���ƾƾƤ��ƾ�";
//		
//		String s2 = new String("�� �ް� !!!!! �ʹ� �ų� ~~");
//		System.out.println(s2.charAt(2));
//		System.out.println(s2.length());
//		System.out.println(s2.startsWith("��"));
//		System.out.println(s2.contains("�ʹ�"));
//		System.out.println(s2.replace("�ް�", "3��"));
//		System.out.println(s2.subSequence(2, 7));
//		System.out.println(s2.substring(2, 7));
//		
//		String s3 = String.format("���� : %.2fkg", 123.4123);
//		System.out.println(s3);

//		String s1 = "kk";
//		s1 = new String(s1 + "zz");
//		System.out.println(s1);

//		StringBuffer sb = new StringBuffer(s1);
//		sb.append("wow");
//		sb.append("what?");
//		sb.append("oh god !");
//		System.out.println(sb);
//		
//		String s4 = sb.toString();
//		System.out.println(s4);
//		
		String s5 = "kim,lee,park,choi";
//		
//		String[] s5Ar = s5.split(",");

		StringTokenizer st = new StringTokenizer(s5, ",");
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		while (st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}

	}
}
