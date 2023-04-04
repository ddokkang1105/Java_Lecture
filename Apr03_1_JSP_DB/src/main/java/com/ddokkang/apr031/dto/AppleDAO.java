package com.ddokkang.apr031.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ddokkang.db.manager.DdokkangDBManager;

public class AppleDAO {
	
	private int allAppleCount;
	
	private static final AppleDAO APPLEDAO = new AppleDAO();
	
	private AppleDAO() {
		// TODO Auto-generated constructor stub
	}

	public static AppleDAO getAppledao() {
		return APPLEDAO;
	}
	
	// 모든 사과 데이터 다 가져오기
	public void getAllApples(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			// sql문 작성
			String sql = "select * from apple order by a_price";
			pstmt = con.prepareStatement(sql);
			// C / U / D : pstmt.executeUpdate()로 실행
			//		=> 데이터가 몇 개 영향을 받았는지
			// R : pstmt.executeQuery()로 실행
			//		=> select결과를 ResultSet으로 보냄
			
			rs = pstmt.executeQuery();
			
			ArrayList<AppleAns> apples = new ArrayList<AppleAns>();
			AppleAns appleAns = null;
			while (rs.next()) {
				appleAns = new AppleAns();
				appleAns.setA_loc(rs.getString("a_loc"));
				appleAns.setA_color(rs.getString("a_color"));
				appleAns.setA_taste(rs.getString("a_taste"));
				appleAns.setA_price(rs.getInt("a_price"));
				appleAns.setA_intro(rs.getString("a_intro"));
				apples.add(appleAns);
			}
			request.setAttribute("apples", apples);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdokkangDBManager.close(con, pstmt, rs);
	}
	
	public void registApple(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");

			// 데이터 입력
			request.setCharacterEncoding("EUC-KR");
			String location = request.getParameter("a_loc");
			String color = request.getParameter("a_color");
			String taste = request.getParameter("a_taste");
			int price = Integer.parseInt(request.getParameter("a_loc"));
			
			// <textArea>에서 엔터친거 : \r\n
			// 웹페이지에서 줄바꾸기 : <br>
			String intro = request.getParameter("a_intro").replace("\r\n", "<br>");
			
			// sql문 작성 (미완성) - 입력 값으로 어떤 값을 넣을지 모르기 때문에
			String sql = "insert into apple values(?, ?, ?, ?, ?)";
			
			// DB관련 총괄매니저(pstmt)
			pstmt = con.prepareStatement(sql);
			
			// sql문 완성
			pstmt.setString(1, location);
			pstmt.setString(2, color);
			pstmt.setString(3, taste);
			pstmt.setInt(4, price);
			pstmt.setString(5, intro);
			
			// 실행 + 결과처리
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[Success !]");
				allAppleCount++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[Fail !]");
		}
		DdokkangDBManager.close(con, pstmt, null);
	}
	
	// 총 데이터가 몇 개 있는지?
	public void countApples() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			String sql = "select count(*) count from apple";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			rs.next();
			allAppleCount = rs.getInt("count");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdokkangDBManager.close(con, pstmt, rs);
	}
	
	// DB에 데이터가 200만개 정도 있다 ? => 해당 페이지 번호에 맞는 데이터만 가져오기
	public void getApples(int pageNo, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			// SQL 수행하는데 필요한 값 챙기기
			
			// allAppleCount : 전체 사과 데이터 수
			int applePerPage = 4;	// 한 페이지당 보여줄 사과 데이터의 수
			
			// 페이지 갯수 가져오기
			// Math.cell : 숫자 올림 (반올림 X)
			int pageCount = (int) Math.ceil(allAppleCount / (double) applePerPage);
			request.setAttribute("pageCount", pageCount);
			//////////////////////////////////////////////////////////////////
			
			int start = (applePerPage * (pageNo - 1)) + 1;
			int end = (pageNo == pageCount) ? allAppleCount : (start + applePerPage - 1);
			
			String sql = "select * "
			+ "from ("
			+ 		"select rownum rn, a_loc, a_color, a_taste, a_price, a_intro "
			+ 			"from ("
			+ 				"select * "
			+ 					"from apple "
			+ 					"order by a_price "
			+ 			") "
			+ ") "
			+ "where rn >= ? and rn <= ?";		
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			ArrayList<AppleAns> apples = new ArrayList<AppleAns>();
			AppleAns appleAns = null;
			while (rs.next()) {
				appleAns = new AppleAns();
				appleAns.setA_loc(rs.getString("a_loc"));
				appleAns.setA_color(rs.getString("a_color"));
				appleAns.setA_taste(rs.getString("a_taste"));
				appleAns.setA_price(rs.getInt("a_price"));
				appleAns.setA_intro(rs.getString("a_intro"));
				apples.add(appleAns);
			}
			request.setAttribute("apples", apples);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdokkangDBManager.close(con, pstmt, rs);
		
	}
	
	// 상세정보 가져오기(Primary Key)
	// 제대로 데이터를 가져왔으면 : true
	// 실패했으면 : false

	public boolean getAppleDetail(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			String loc = request.getParameter("a_loc");
			
			String sql = "select * from apple where a_loc = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loc);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				AppleAns apple = new AppleAns();
				apple.setA_loc(rs.getString("a_loc"));
				apple.setA_color(rs.getString("a_color"));
				apple.setA_taste(rs.getString("a_taste"));
				apple.setA_price(rs.getInt("a_price"));
				apple.setA_intro(rs.getString("a_intro"));
				request.setAttribute("apple", apple);
				return true;	// 일반적인 상황 : 데이터가 하나
			}
			return false;	// ex) 다른 사람이 그 데이터를 지웠으면 : 데이터 없음
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;	// DB서버의 상태가 안 좋음 (ex : 서버가 안 켜짐)
		} finally {
			DdokkangDBManager.close(con, pstmt, rs);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//	public void function() {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			con = DdokkangDBManager.connect("ddokkangPool");
//			
//			String sql = "select * from apple "
//					+ "where a_loc = ?";
//			pstmt = con.prepareStatement(sql);
//			
//			pstmt.setString(1, sql);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		DdokkangDBManager.close(con, pstmt, rs);
//	}
	
	
	
	
//	public void getApplesByPage(HttpServletRequest request) {
//		int count = allAppleCount;
//		System.out.println(count);
//		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			con = DdokkangDBManager.connect("ddokkangPool");
//			
//			String sql = "select rn, a_loc, a_color, a_taste, a_price, a_intro "
//					+ "from ("
//					+ "select rownum rn, a_loc, a_color, a_taste, a_price, a_intro "
//					+ "from ("
//					+ "select a_loc, a_color, a_taste, a_price, a_intro "
//					+ "from apple "
//					+ "order by a_price "
//					+ ") "
//					+ ") "
//					+ "where rn >= 1 and rn <= 5";
//
//			pstmt = con.prepareStatement(sql);
//			
//			int pageStart = 0;
//			int pageLast = 0;
//			int pageCount = 3;
////			request.setAttribute("pageCount", pageCount);
//			
//			rs = pstmt.executeQuery();
//			
//			ArrayList<AppleAns> apples = new ArrayList<AppleAns>();
//			AppleAns apple = null;
//			while (rs.next()) {
//				apple = new AppleAns();
//				apple.setA_loc(rs.getString("a_loc"));
//				apple.setA_color(rs.getString("a_color"));
//				apple.setA_taste(rs.getString("a_taste"));
//				apple.setA_price(rs.getInt("a_price"));
//				apple.setA_intro(rs.getString("a_intro"));
//				apples.add(apple);
//			}
//			request.setAttribute("apples", apples);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		DdokkangDBManager.close(con, pstmt, rs);
//		
//	}
	
}
