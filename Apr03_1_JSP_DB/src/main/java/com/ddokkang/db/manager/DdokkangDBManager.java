package com.ddokkang.db.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// ������ JDBC ���α׷� ���� -> DBMS�� ������ �۾�
// Ŭ���̾�Ʈ�� ��û�� ���� ������ DB������ ������ �ϱ� ���ؼ�
// Connect ��ü�� �ҷ��;� �߾��� !

// ����
//		1. Connection ������ ���� �ð��� �ʿ��� �۾�
//		2. ���ʿ��� ���ῡ ���� ���� �ڿ��� ����

// ���� ���� => DBCP (DataBase Connection Pool)
//		�������� DB Connection�� �ϳ��� Pool�� ��Ƴ��� ����
//		�ʿ��� ������ Pool���� �ҷ��ٰ� ����ϸ� O !
//		����, ������ �� �ִ� Connection�� ���ٸ�, Connection ��ü�� ��ȯ�� ������
//			Ŭ���̾�Ʈ�� ��� ���·� ��ȯ
//		����� ���� Connection ��ü�� �ٽ� Pool�� ��ȯ

public class DdokkangDBManager {
	public static Connection connect(String poolName) throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/" + poolName);
		return ds.getConnection();
	}
	
	public static void close(Connection con, PreparedStatement psmt, ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
		}
		try {
			psmt.close();
		} catch (Exception e) {
		}
		try {
			con.close();
		} catch (Exception e) {
		}
	}
}
