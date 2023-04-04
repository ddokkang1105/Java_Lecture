package com.ddokkang.apr031.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ddokkang.db.manager.DdokkangDBManager;

public class Apple {
	private String loc;
	private String color;
	private String taste;
	private int price;
	private String intro;
	
	public Apple() {
		// TODO Auto-generated constructor stub
	}
	
	public Apple(String loc, String color, String taste, int price, String intro) {
		super();
		this.loc = loc;
		this.color = color;
		this.taste = taste;
		this.price = price;
		this.intro = intro;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public static void getApple(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			String sql = "select * from apple";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			ArrayList<Apple> appleAl = new ArrayList<Apple>();
			Apple apple = null;
			
			while (rs.next()) {
				apple = new Apple();
				apple.setLoc(rs.getString("a_loc"));
				apple.setTaste(rs.getString("a_taste"));
				apple.setColor(rs.getString("a_color"));
				apple.setPrice(rs.getInt("a_price"));
				apple.setIntro(rs.getString("a_intro"));
				appleAl.add(apple);
			}
			
			request.setAttribute("apple", appleAl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdokkangDBManager.close(con, pstmt, rs);
	}
}
