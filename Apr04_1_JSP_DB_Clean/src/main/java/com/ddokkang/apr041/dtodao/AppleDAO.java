package com.ddokkang.apr041.dtodao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ddokkang.db.manager.DdokkangDBManager;

public class AppleDAO {
	private int allAppleCount;
	
	private static final AppleDAO appleDao = new AppleDAO();

	private AppleDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static AppleDAO getAppledao() {
		return appleDao;
	}
	
	public void registApple(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			//
			request.setCharacterEncoding("EUC-KR");
			//
			
			Apple apple = new Apple();
			apple.setA_loc(request.getParameter("a_loc"));
			apple.setA_color(request.getParameter("a_color"));
			apple.setA_taste(request.getParameter("a_taste"));
			apple.setA_price(Integer.parseInt(request.getParameter("a_price")));
			//
			apple.setA_intro(request.getParameter("a_intro").replace("\r\n", "<br>"));
			//
			
			String sql = "insert into apple values(?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, apple.getA_loc());
			pstmt.setString(2, apple.getA_color());
			pstmt.setString(3, apple.getA_taste());
			pstmt.setInt(4, apple.getA_price());
			pstmt.setString(5, apple.getA_intro());
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[Success !]");
				//
				allAppleCount++;
				//
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[Fail !]");
		}
		DdokkangDBManager.close(con, pstmt, null);
	}
	
	public void countApples() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			String sql = "select count(*) from apple";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			rs.next();	
			allAppleCount = rs.getInt("count(*)");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdokkangDBManager.close(con, pstmt, rs);
	}
	
	public void getApples(int pageNo, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			int applePerPage = 4;
			
			int pageCount = (int) Math.ceil(allAppleCount / (double) applePerPage);
			request.setAttribute("pageCount", pageCount);
			//
			int start = (applePerPage * (pageNo - 1)) + 1; 
			int end = (pageNo == pageCount) ? allAppleCount : (start + applePerPage - 1);
			//
			
			String sql = "select * from ( "
					+ 		"select rownum rn, a_loc, a_color, a_taste, a_price, a_intro "
					+ 			"from ( "
					+ 				"select * from apple order by a_price "
					+ 			") "
					+ 		") "
					+ 		"where rn >= ? and rn <= ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			ArrayList<Apple> apples = new ArrayList<Apple>();
			Apple apple = null;
			while (rs.next()) {
				apple = new Apple();
				apple.setA_loc(rs.getString("a_loc"));
				apple.setA_color(rs.getString("a_color"));
				apple.setA_taste(rs.getString("a_taste"));
				apple.setA_price(rs.getInt("a_price"));
				apple.setA_intro(rs.getString("a_intro"));
				apples.add(apple);
			}
			request.setAttribute("apples", apples);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdokkangDBManager.close(con, pstmt, rs);
	}
	
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
				Apple apple = new Apple();
				apple.setA_loc(rs.getString("a_loc"));
				apple.setA_color(rs.getString("a_color"));
				apple.setA_taste(rs.getString("a_taste"));
				apple.setA_price(rs.getInt("a_price"));
				apple.setA_intro(rs.getString("a_intro"));
				request.setAttribute("apple", apple);
				return true;
			}
			
			return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DdokkangDBManager.close(con, pstmt, rs);
		}
	}
	
}
