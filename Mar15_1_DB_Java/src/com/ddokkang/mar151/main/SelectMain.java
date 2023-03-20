package com.ddokkang.mar151.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String addr = "jdbc:oracle:thin:@192.168.0.164:1521:xe";
			con = DriverManager.getConnection(addr, "ddobot", "1111");
			
			// 상품 이름을 오름차순으로 정렬해서 상품 전체 정보 조회
			String sql = "select * from mar14_product order by p_name";
			pstmt = con.prepareStatement(sql);
			
			// pstmt.executeUpdate() : 몇 개나 영향을 받았는가 (C, U, D)
			// pstmt.executeQuery()	: 데이터 (R)
			
			// select문을 수행한 결과 : ResultSet
			//			List와 비슷한 느낌
			
			rs = pstmt.executeQuery();
			
			// rs.next() : 다음 데이터로 넘어감, xml느낌...
			//				다음 데이터가 있으면 true, 없으면 false가 리턴 
			while (rs.next()) {
				// rs.getXXX("컬럼명") : 현재 위치의 컬럼 읽기
				// rs.getXXX(인덱스) : 현재 데이터의 인덱스 컬럼 읽기 (비추천!)
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt("p_weight"));
				System.out.println(rs.getInt("p_price"));
				System.out.println("-----------------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		try {
			rs.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
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
