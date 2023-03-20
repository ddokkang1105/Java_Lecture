package com.ddokkang.mar151.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
	public static void main(String[] args) {
		// ������Է� -> �� �ܾ �����ϴ� ��� ������ ��ǰ�� 20% ���ε� �������� �ٲٱ� !
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner k = null;
		
		try {
			String addr = "jdbc:oracle:thin:@192.168.0.164:1521:xe";
			con = DriverManager.getConnection(addr, "ddobot", "1111");
			k = new Scanner(System.in);
			System.out.print("ã�� ���� ���� �̸� : ");
			String name = k.next();
			
			// ������ : ����� �ڹ��� �����̱� ������... % ���� ! -> %?% - X !
			// ***** '%'||?||'%' ***** -> ���ڿ� ��ġ�� || ����ϱ� !!
			String sql = "update mar14_product "
					+ "set p_price = p_price * 0.8 "
					+ "where p_m_no in ( "
					+ 	"select m_no "
					+ 	"from mar14_market "
					+ 	"where m_name like '%'||?||'%'"
					+ ")";
			
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
