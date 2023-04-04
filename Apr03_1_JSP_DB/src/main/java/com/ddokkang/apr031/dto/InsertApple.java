package com.ddokkang.apr031.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import com.ddokkang.db.manager.DdokkangDBManager;

public class InsertApple {
	public static void insert(HttpServletRequest request) {
		AppleAns apple = new AppleAns();
		apple.setA_loc(request.getParameter("a_loc"));
		apple.setA_color(request.getParameter("a_color"));
		apple.setA_taste(request.getParameter("a_taste"));
		apple.setA_price(Integer.parseInt(request.getParameter("a_price")));
		apple.setA_intro(request.getParameter("a_intro"));
		
//		System.out.println(a_loc);
//		System.out.println(a_color);
//		System.out.println(a_taste);
//		System.out.println(a_price);
//		System.out.println(a_intro);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			String sql = "insert into apple values(?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, apple.getA_loc().toUpperCase());
			pstmt.setString(2, apple.getA_color());
			pstmt.setString(3, apple.getA_taste());
			pstmt.setInt(4, apple.getA_price());
			pstmt.setString(5, apple.getA_intro());
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("Success !");
				request.setAttribute("r", "[Success !]");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[Fail !]");
		}
		DdokkangDBManager.close(con, pstmt, null);
		
	}
}
