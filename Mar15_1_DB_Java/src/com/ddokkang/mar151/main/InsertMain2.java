package com.ddokkang.mar151.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain2 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner k = null;
		try {
			// ����
			String addr = "jdbc:oracle:thin:@192.168.0.164:1521:xe";
			con = DriverManager.getConnection(addr, "ddobot", "1111");
			
			// ������ �Ǿ��� �� �Է¹ޱ�(Scanner)
			k = new Scanner(System.in);
			// ��Ʈ �̸�
			System.out.print("Name: \n");
			String name = k.next();
			// ��Ʈ ����
			System.out.print("Location: \n");
			String location = k.next();
			// ��Ʈ ũ��
			System.out.print("Area: \n");
			int area = k.nextInt();
			// ��Ʈ ������
			System.out.print("Parking: \n");
			int parking = k.nextInt();
			
			// SQL
			// Java������ �ִ� �� �� �ڸ��� '?'�� !
			String sql = "insert into mar14_market values(mar14_market_seq.nextval, "
					+ "?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			// ?�� �� ä��� : pstmt.setXXX(����ǥ��ȣ, ��)
			// XXX : �ڷ���, ����ǥ��ȣ�� 1���� ���� !
			
			// sql ������ ù��°(1) ����ǥ�� String�� name�� ���� �־�� !
			pstmt.setString(1, name);
			pstmt.setString(2, location);
			pstmt.setInt(3, area);
			pstmt.setInt(4, parking);
			
			// ���� / ���� / ��� �ޱ�
//			int dataCount = pstmt.executeUpdate();
//			if (dataCount == 1) {
//				System.out.println("Success !!");
//			}
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("Success !!");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		k.close();
		
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
