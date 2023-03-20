package com.ddokkang.mar151.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// SQL문을 사용해서
//		-> DB서버로 전송
//		-> DB서버에서 실행해서
//		-> 그 결과를 받아올 수 있어야 !

public class InsertMain1 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String addr = "jdbc:oracle:thin:@192.168.0.164:1521:xe";
			
			con = DriverManager.getConnection(addr, "ddobot", "1111");
//			System.out.println("Success !");
			
			// SQL문 작성 ! (insert)
			// 주의할 점 2가지 !!! ***
			String sql = "insert into mar14_product " 		// 1. 띄어쓰기 주의 !!
					+ "values(mar14_product_seq.nextval, " 	// 띄어쓰기 안하면 productvalues로 부터버림 !!
					+ "'테스트', 10, 10, 3)";				// 2. ) 뒤에 ; 쓰지 말 것 !
			
			// 서버에 전송 / 실행 / 결과 받아오는 작업을 하는 총괄 매니저
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();		// 서버에 전송 / 실행 / 결과받기
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		try {
			pstmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
