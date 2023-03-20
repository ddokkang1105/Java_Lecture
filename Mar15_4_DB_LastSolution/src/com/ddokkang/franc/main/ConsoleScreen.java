package com.ddokkang.franc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.ddokkang.franc.reservation.Reservation;

public class ConsoleScreen {
	// ����ڰ� �ܼ��� �� �� �ְų�, �ֿܼ� �Է��� �� �ְ�
	// �޴��� �� �� �ִ� ��ɵ� �־�����...
	public static int ShowMainMenu() {
		Scanner k = new Scanner(System.in);
		System.out.println("=============================================");
		System.out.println("1. �����ϱ�");
		System.out.println("2. ������");
		System.out.println("3. ��ü����Ȯ��");
		System.out.println("4. ��ü������ȸ");
		System.out.println("5. ���� ã��");
		System.out.println("6. ���� ã��");
		System.out.println("7. ������������");
		System.out.println("8. ���� ���");
		System.out.println("9. ����");
		System.out.println("=============================================");
		System.out.print("��ȣ �Է� : ");
		return k.nextInt();
	}
	
	// ��� Ȯ��
	public static void printResult(String result) {
		System.out.println(result);
	}
	
	// 1. �����ϱ�(���� �Է�, ��¥�� ��-��-��/��:��)
	public static Reservation showRsvMenu() throws ParseException {
		Scanner k = new Scanner(System.in);
		
		System.out.print("������ : ");
		String name = k.next();
		
		System.out.print("���� ��¥(YYYY-MM-DD/HH:mm) : ");
		String when = k.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm");
		Date when2 = sdf.parse(when);
		
		System.out.print("����ó : ");
		String phoneNum = k.next();
		
		System.out.print("���� ������ : ");
		String location = k.next();
		
		Reservation r = new Reservation(0, name, when2, phoneNum, location);
		System.out.println("=============================================");
		return r;
	}
	// 2. ���� ���
	public static Restaurant registRtrMenu() {
		Scanner k = new Scanner(System.in);
		
		System.out.print("������ : ");
		String location = k.next();
		
		System.out.print("����� ���� : ");
		String name = k.next();
		
		System.out.print("�¼��� : ");
		int seat = k.nextInt();
		
		Restaurant r = new Restaurant(location, name, seat);
		System.out.println("=============================================");
		return r;
		
		
	}
	
	// 3. ��ü ���� ���� Ȯ�� (��¥�� ��-��-�� ���� ����/���� ��:��)
	public static void showRsvResultMenu(ArrayList<Reservation> rsvs) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E a hh:mm");
		for (Reservation r : rsvs) {
			System.out.printf("%d) ", r.getNo());
			System.out.printf("[%s - ", r.getName());
			System.out.printf("%s] ", r.getPhone());
			System.out.print(r.getLocation() + " - ");
			System.out.println("(" + sdf.format(r.getWhen()) + ")");
		}
	}
	
	// 4. ��ü ���� ��ȸ (��ġ(�¼� ��) - ����� �̸�)
	public static void showRtrResultMenu(ArrayList<Restaurant> rtrs) {
		for (Restaurant r : rtrs) {
			System.out.printf("%s(", r.getLocation());
			System.out.printf("%d) - ", r.getSeat());
			System.out.printf("%s\n", r.getOwner());
		}
	}
	
	// 5. ���� ã�� (�ּ� �¼��� �Է� => �¼� �� �̻��� ���� ������ ���)
	public static Restaurant showSearchRtrMenu() {
		Scanner k = new Scanner(System.in);
		System.out.print("�ּ� �¼� �� : ");
		int seat = k.nextInt();
		System.out.println("=============================================");
		return new Restaurant(null, null, seat);
	}
	
	// 6. ���� ã�� (������ �̸�)
	public static Reservation showSearchRsvMenu() {
		Scanner k = new Scanner(System.in);
		System.out.print("������ �̸� : ");
		String name = k.next();
		System.out.println("=============================================");
		return new Reservation(0, name, null, null, null);
	}
	
	// 7. ���� ���� ���� (�����ȣ�� �Է��ϸ�, ����ó�� ����)
	public static Reservation showUpdateMenu() {
		Scanner k = new Scanner(System.in);
		System.out.print("���� ��ȣ : ");
		int no = k.nextInt();
		System.out.print("������ ����ó : ");
		String phoneNum = k.next();
		return new Reservation(no, null, null, phoneNum, null);
	}
	
	// 8. ���� ��� (�����ȣ�� ���)
	public static Reservation showDeleteRsvMenu() {
		Scanner k = new Scanner(System.in);
		System.out.print("���� ��ȣ : ");
		int no = k.nextInt();
		System.out.println("=============================================");
		return new Reservation(no, null, null, null, null);
	}
	
	// 9. ����
	
}
