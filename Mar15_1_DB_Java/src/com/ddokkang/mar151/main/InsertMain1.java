package com.ddokkang.mar151.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// SQL���� ����ؼ�
//		-> DB������ ����
//		-> DB�������� �����ؼ�
//		-> �� ����� �޾ƿ� �� �־�� !

public class InsertMain1 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String addr = "jdbc:oracle:thin:@192.168.0.164:1521:xe";
			
			con = DriverManager.getConnection(addr, "ddobot", "1111");
//			System.out.println("Success !");
			
			// SQL�� �ۼ� ! (insert)
			// ������ �� 2���� !!! ***
			String sql = "insert into mar14_product " 		// 1. ���� ���� !!
					+ "values(mar14_product_seq.nextval, " 	// ���� ���ϸ� productvalues�� ���͹��� !!
					+ "'�׽�Ʈ', 10, 10, 3)";				// 2. ) �ڿ� ; ���� �� �� !
			
			// ������ ���� / ���� / ��� �޾ƿ��� �۾��� �ϴ� �Ѱ� �Ŵ���
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();		// ������ ���� / ���� / ����ޱ�
			
			
			
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
