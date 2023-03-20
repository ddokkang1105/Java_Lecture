package com.ddokkang.franc.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ddokkang.franc.reservation.Reservation;

public class DAO {
	// DAO / DTO ����
	//	MVC����(Model View Controller)
	//	DAO (Data Access Object)
	//		: M �߿��� DB������ �۾��� �����ϴ� Ŭ����
	//	DTO (Data Tranfer / Temp Object)
	//		: DAO�� �۾������ ǥ���ϴ� Ŭ����
	
	//java.util.Date - �ַ�(Spring������ �̰� ����)
	//java.sql.Date - JDBC������ �̰� ����
	
	//java.util.Date -> java.sql.Date
	//	: new Date(Ŭ������.get��¥���ø��������().getTime());
	
	//java.sql.Date -> java.util.Date : �˾Ƽ� �ٲ���

	
	// 1. �����ϱ�
	public static String book(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdokkangDBManager.connect();
			String sql = "insert into mar16_reservation "
					+ "values(mar16_reservation_seq.nextval, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rsv.getName());
			pstmt.setDate(2, new Date(rsv.getWhen().getTime()));
			pstmt.setString(3, rsv.getPhone());
			pstmt.setString(4, rsv.getLocation());
			
			if (pstmt.executeUpdate() == 1) {
				return "���� ����";
			}
			return ""; // Java������ �ʿ��ؼ� ������ ���� �� !!
		} catch (Exception e) {
			e.printStackTrace();
			return "���� ����";
		} finally {
			DdokkangDBManager.close(con, pstmt, null);
		}
	}
	
	// 2. ���� ���
	public static String regist(Restaurant rtr) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdokkangDBManager.connect();
			String sql = "insert into mar16_restaurant "
					+ "values(?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, rtr.getLocation());
			pstmt.setString(2, rtr.getOwner());
			pstmt.setInt(3, rtr.getSeat());
			
			if (pstmt.executeUpdate() == 1) {
				return "���� ����";
			}
			return "";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "���� ����";
		} finally {
			DdokkangDBManager.close(con, pstmt, null);
		}
	}
	
	// 3. ��ü ���� ���� Ȯ�� (�����ȣ �������� ����)
	public static ArrayList<Reservation> getAllReserve() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect();
			String sql = "select * from mar16_reservation order by r_no";
			pstmt = con.prepareStatement(sql);
			
			// rs : select���� ������ ���
			rs = pstmt.executeQuery();
			
			// ***
			ArrayList<Reservation> rsvs = new ArrayList<Reservation>();
			
			Reservation r = null;
			while (rs.next()) {
				// Reservation Ŭ������ ������� X !
				// DB�� �÷��� O !
				r = new Reservation();
				r.setNo(rs.getInt("r_no"));
				r.setName(rs.getString("r_name"));
				r.setWhen(rs.getDate("r_time"));
				r.setPhone(rs.getString("r_phonenum"));
				r.setLocation(rs.getString("r_location"));
				rsvs.add(r);
			}
			return rsvs;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DdokkangDBManager.close(con, pstmt, rs);
		}
	}
	
	// 4. ��ü ���� ��ȸ (������ �������� ����)
	public static ArrayList<Restaurant> getAllRestaurant() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect();
			String sql = "select * from mar16_restaurant order by r_location";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			ArrayList<Restaurant> rtrs = new ArrayList<Restaurant>();
			
			Restaurant r = null;
			
			while (rs.next()) {
				r = new Restaurant();
				r.setLocation(rs.getString("r_location"));
				r.setOwner(rs.getString("r_owner"));
				r.setSeat(rs.getInt("r_seat"));
				rtrs.add(r);
			}
			return rtrs;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DdokkangDBManager.close(con, pstmt, rs);
		}
	}
	
	// 5. ���� ã�� (�Է��� �¼� �� �̻��� ������ �ִ� ����, ������ �������� ����)
	public static ArrayList<Restaurant> searchRestaurant(Restaurant rtr) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect();
			String sql = "select * from mar16_restaurant where r_seat >= ? order by r_location";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, rtr.getSeat());
			rs = pstmt.executeQuery();
			
			ArrayList<Restaurant> rtrs = new ArrayList<Restaurant>();
//			Restaurant r = null;
//			while (rs.next()) {
//				r = new Restaurant();
//				r.setLocation(rs.getString("r_location"));
//				r.setOwner(rs.getString("r_owner"));
//				r.setSeat(rs.getInt("r_seat"));
//				rtrs.add(r);
//			}
			
			while (rs.next()) {
				rtrs.add(new Restaurant(rs.getString("r_location"), rs.getString("r_owner"), rs.getInt("r_seat")));
			}
			return rtrs;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DdokkangDBManager.close(con, pstmt, rs);
		}
	}
	
	// 6. ���� ã�� (������ �̸����� ã��, ���� ��ȣ������ ����)
	public static ArrayList<Reservation> searchReservation(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect();
			String sql = "select * from mar16_reservation "
					+ "where r_name like '%'||?||'%' "
					+ "order by r_no";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rsv.getName());
			rs = pstmt.executeQuery();
			
			ArrayList<Reservation> rsvs = new ArrayList<Reservation>();
			
			while (rs.next()) {
				rsvs.add(new Reservation(rs.getInt("r_no"), rs.getString("r_name"), rs.getDate("r_time"), 
						rs.getString("r_phonenum"), rs.getString("r_location")));
			}
			return rsvs;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DdokkangDBManager.close(con, pstmt, rs);
		}
	}
	
	// 7. ���� ���� ���� (�����ȣ�� �Է��ϸ�, ����ó�� ����)
	public static String updateReserve(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdokkangDBManager.connect();
			String sql = "update mar16_reservation set r_phonenum = ? where r_no in ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rsv.getPhone());
			pstmt.setInt(2, rsv.getNo());
			
			if (pstmt.executeUpdate() >= 1) {
				return "������� ����";
			}
			return "�������� ����";
		} catch (Exception e) {
			e.printStackTrace();
			return "������� ����";
		} finally {
			DdokkangDBManager.close(con, pstmt, null);
		}
	}
	
	// 8. ���� ��� (�����ȣ�� ���)
	public static String cancle(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdokkangDBManager.connect();
			String sql = "delete mar16_reservation where r_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rsv.getNo());
			
			if (pstmt.executeUpdate() == 1) {
				return "������� ����";
			}
			return "�������� ����";
		} catch (Exception e) {
			e.printStackTrace();
			return "������� ����";
		} finally {
			DdokkangDBManager.close(con, pstmt, null);
		}
		
	}
	
}
