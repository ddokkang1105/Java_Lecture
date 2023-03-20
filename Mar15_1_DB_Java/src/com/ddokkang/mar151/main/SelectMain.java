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
			
			// ��ǰ �̸��� ������������ �����ؼ� ��ǰ ��ü ���� ��ȸ
			String sql = "select * from mar14_product order by p_name";
			pstmt = con.prepareStatement(sql);
			
			// pstmt.executeUpdate() : �� ���� ������ �޾Ҵ°� (C, U, D)
			// pstmt.executeQuery()	: ������ (R)
			
			// select���� ������ ��� : ResultSet
			//			List�� ����� ����
			
			rs = pstmt.executeQuery();
			
			// rs.next() : ���� �����ͷ� �Ѿ, xml����...
			//				���� �����Ͱ� ������ true, ������ false�� ���� 
			while (rs.next()) {
				// rs.getXXX("�÷���") : ���� ��ġ�� �÷� �б�
				// rs.getXXX(�ε���) : ���� �������� �ε��� �÷� �б� (����õ!)
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
