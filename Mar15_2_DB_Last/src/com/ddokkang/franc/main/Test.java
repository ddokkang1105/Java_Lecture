/*
 * package com.ddokkang.franc.main;
 * 
 * import java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.PreparedStatement; import java.sql.SQLException;
 * 
 * public class Test { public static void main(String[] args) { Connection con =
 * null; PreparedStatement pstmt = null;
 * 
 * try { String addr = "jdbc:oracle:thin:@192.168.0.164:1521:xe"; con =
 * DriverManager.getConnection(addr, "ddobot", "1111");
 * System.out.println("Success.."); } catch (Exception e) {
 * System.out.println("Fail.."); }
 * 
 * try { con.close(); // close ö���� �ϼ��� ! // ���� �� ������ �ٸ� ����� ����� ! } catch
 * (SQLException e) { e.printStackTrace(); } } }
 */