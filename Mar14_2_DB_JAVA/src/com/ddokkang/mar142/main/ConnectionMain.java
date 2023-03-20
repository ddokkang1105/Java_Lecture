package com.ddokkang.mar142.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// ���� : cmd��� sqlplus��� ���α׷����� OracleDB����
//				cmd��� ����
// ����ǰ : orange, toad, eclipse, dbeaver, sqldeveloper, ...

// Socket���
// HTTP���

// DB������ ��� : Java�� ����Ǿ� ���� (�̿ϼ�����)
//		DB ����Ŀ�� ���� ������,,, => ����Ŀ ���� ����� ���ݾ� �ٸ��� !
//		������ DB�� ���缭 ���ݾ� ��ġ�� ����� �� !!

// JDBC (Java DataBase Connectivity) : �ڹٿ��� DB���α׷����� �ϱ� ���� ���Ǵ� API
// OracleDB�� ����� ! -> ���⿡ ���缭 ��ġ�� �ؾ� !
//		=> �� ����� ojdbc8.jar�� �� ���� 

//		ojdbc8.jar �ֱ⸸ �ϸ� �˾Ƽ� ����� �� ���� !!

public class ConnectionMain {
	public static void main(String[] args) {
		Connection con = null;
		try {
			// ������ DB���� �ּ� (����Ŀ���� ������ �ٸ���)
			// Data Source Explorer (������ Window - Show view - Other - Data Source Explorer)
			// - ���� �̸��ʿ� ������ ���콺 ��ư Ŭ��
			//		- Properties - Driver Properties - Connection URL ���� ���� ! (jdbc:oracle:thin:@192.168.0.164:1521:xe)
			
			String addr = "jdbc:oracle:thin:@192.168.0.164:1521:xe";
			
			con = DriverManager.getConnection(addr, "ddobot", "1111");
			System.out.println("Success !");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();				// close ö���� �ϼ��� !
										// ���� �� ������ �ٸ� ����� ����� !
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
