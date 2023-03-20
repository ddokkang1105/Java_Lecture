package com.ddokkang.franc.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ddokkang.franc.reservation.Reservation;

public class DAO {
	// DAO / DTO 패턴
	//	MVC패턴(Model View Controller)
	//	DAO (Data Access Object)
	//		: M 중에서 DB관련한 작업을 전담하는 클래스
	//	DTO (Data Tranfer / Temp Object)
	//		: DAO의 작업결과를 표현하는 클래스
	
	//java.util.Date - 주력(Spring에서는 이걸 원함)
	//java.sql.Date - JDBC에서는 이걸 원함
	
	//java.util.Date -> java.sql.Date
	//	: new Date(클래스명.get날짜관련멤버변수명().getTime());
	
	//java.sql.Date -> java.util.Date : 알아서 바꿔줌

	
	// 1. 예약하기
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
				return "예약 성공";
			}
			return ""; // Java문법상 필요해서 억지로 넣은 것 !!
		} catch (Exception e) {
			e.printStackTrace();
			return "예약 실패";
		} finally {
			DdokkangDBManager.close(con, pstmt, null);
		}
	}
	
	// 2. 매장 등록
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
				return "예약 성공";
			}
			return "";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "예약 실패";
		} finally {
			DdokkangDBManager.close(con, pstmt, null);
		}
	}
	
	// 3. 전체 예약 정보 확인 (예약번호 오름차순 정렬)
	public static ArrayList<Reservation> getAllReserve() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect();
			String sql = "select * from mar16_reservation order by r_no";
			pstmt = con.prepareStatement(sql);
			
			// rs : select문을 실행한 결과
			rs = pstmt.executeQuery();
			
			// ***
			ArrayList<Reservation> rsvs = new ArrayList<Reservation>();
			
			Reservation r = null;
			while (rs.next()) {
				// Reservation 클래스의 멤버변수 X !
				// DB의 컬럼명 O !
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
	
	// 4. 전체 매장 조회 (지점명 오름차순 정렬)
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
	
	// 5. 매장 찾기 (입력한 좌석 수 이상을 가지고 있는 매장, 지점명 오름차순 정렬)
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
	
	// 6. 예약 찾기 (예약자 이름으로 찾기, 예약 번호순으로 정렬)
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
	
	// 7. 예약 정보 수정 (예약번호를 입력하면, 연락처를 변경)
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
				return "예약수정 성공";
			}
			return "예약정보 없음";
		} catch (Exception e) {
			e.printStackTrace();
			return "예약수정 실패";
		} finally {
			DdokkangDBManager.close(con, pstmt, null);
		}
	}
	
	// 8. 예약 취소 (예약번호로 취소)
	public static String cancle(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdokkangDBManager.connect();
			String sql = "delete mar16_reservation where r_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rsv.getNo());
			
			if (pstmt.executeUpdate() == 1) {
				return "예약취소 성공";
			}
			return "예약정보 없음";
		} catch (Exception e) {
			e.printStackTrace();
			return "예약취소 실패";
		} finally {
			DdokkangDBManager.close(con, pstmt, null);
		}
		
	}
	
}
