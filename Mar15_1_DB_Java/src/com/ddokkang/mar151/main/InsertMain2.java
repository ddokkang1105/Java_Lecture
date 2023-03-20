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
			// 연결
			String addr = "jdbc:oracle:thin:@192.168.0.164:1521:xe";
			con = DriverManager.getConnection(addr, "ddobot", "1111");
			
			// 연결이 되었을 때 입력받기(Scanner)
			k = new Scanner(System.in);
			// 마트 이름
			System.out.print("Name: \n");
			String name = k.next();
			// 마트 지역
			System.out.print("Location: \n");
			String location = k.next();
			// 마트 크기
			System.out.print("Area: \n");
			int area = k.nextInt();
			// 마트 주차장
			System.out.print("Parking: \n");
			int parking = k.nextInt();
			
			// SQL
			// Java변수에 있는 값 들어갈 자리에 '?'로 !
			String sql = "insert into mar14_market values(mar14_market_seq.nextval, "
					+ "?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			// ?에 값 채우기 : pstmt.setXXX(물음표번호, 값)
			// XXX : 자료형, 물음표번호는 1부터 시작 !
			
			// sql 변수의 첫번째(1) 물음표는 String인 name의 값을 넣어라 !
			pstmt.setString(1, name);
			pstmt.setString(2, location);
			pstmt.setInt(3, area);
			pstmt.setInt(4, parking);
			
			// 전송 / 실행 / 결과 받기
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
