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
	
	// ��� ��� ������ �� ��������
	public void getAllApples(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			// sql�� �ۼ�
			String sql = "select * from apple order by a_price";
			pstmt = con.prepareStatement(sql);
			// C / U / D : pstmt.executeUpdate()�� ����
			//		=> �����Ͱ� �� �� ������ �޾Ҵ���
			// R : pstmt.executeQuery()�� ����
			//		=> select����� ResultSet���� ����
			
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

			// ������ �Է�
			request.setCharacterEncoding("EUC-KR");
			String location = request.getParameter("a_loc");
			String color = request.getParameter("a_color");
			String taste = request.getParameter("a_taste");
			int price = Integer.parseInt(request.getParameter("a_loc"));
			
			// <textArea>���� ����ģ�� : \r\n
			// ������������ �ٹٲٱ� : <br>
			String intro = request.getParameter("a_intro").replace("\r\n", "<br>");
			
			// sql�� �ۼ� (�̿ϼ�) - �Է� ������ � ���� ������ �𸣱� ������
			String sql = "insert into apple values(?, ?, ?, ?, ?)";
			
			// DB���� �Ѱ��Ŵ���(pstmt)
			pstmt = con.prepareStatement(sql);
			
			// sql�� �ϼ�
			pstmt.setString(1, location);
			pstmt.setString(2, color);
			pstmt.setString(3, taste);
			pstmt.setInt(4, price);
			pstmt.setString(5, intro);
			
			// ���� + ���ó��
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
	
	// �� �����Ͱ� �� �� �ִ���?
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
	
	// DB�� �����Ͱ� 200���� ���� �ִ� ? => �ش� ������ ��ȣ�� �´� �����͸� ��������
	public void getApples(int pageNo, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			// SQL �����ϴµ� �ʿ��� �� ì���
			
			// allAppleCount : ��ü ��� ������ ��
			int applePerPage = 4;	// �� �������� ������ ��� �������� ��
			
			// ������ ���� ��������
			// Math.cell : ���� �ø� (�ݿø� X)
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
	
	// ������ ��������(Primary Key)
	// ����� �����͸� ���������� : true
	// ���������� : false

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
				return true;	// �Ϲ����� ��Ȳ : �����Ͱ� �ϳ�
			}
			return false;	// ex) �ٸ� ����� �� �����͸� �������� : ������ ����
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;	// DB������ ���°� �� ���� (ex : ������ �� ����)
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
