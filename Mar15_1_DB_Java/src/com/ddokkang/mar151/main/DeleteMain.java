package com.ddokkang.mar151.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain {
	public static void main(String[] args) {
		// 상품명 입력 -> 입력한 내용을 포함하는 상품명의 정보 삭제
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner k = new Scanner(System.in);
		
		try {
			String addr = "jdbc:oracle:thin:@192.168.0.164:1521:xe";
			con = DriverManager.getConnection(addr, "ddobot", "1111");
			System.out.print("삭제할 상품명 : ");
			String name = k.next();
			String sql = "delete mar14_product "
					+ "where p_name like '%'||?||'%'";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			if (pstmt.executeUpdate() >= 1) {
				System.out.println("Success !!");
			} else {
				System.out.println("Fail ..");
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
