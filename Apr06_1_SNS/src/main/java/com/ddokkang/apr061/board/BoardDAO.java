package com.ddokkang.apr061.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ddokkang.apr061.member.Member;
import com.ddokkang.db.manager.DdokkangDBManager;

public class BoardDAO {
	private int boardCount = 0;
	
	private static final BoardDAO BDAO = new BoardDAO();
	
	private BoardDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static BoardDAO getBdao() {
		return BDAO;
	}

	public void countBoard() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			String sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			boardCount = rs.getInt("count(*)");
			System.out.println("Count : " + boardCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdokkangDBManager.close(con, pstmt, rs);
	}
	
	public void write(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			// insert에 넣을 값
			// 글 번호 - seq
			// 작성 날짜 - sysdate
			// 글 작성자 아이디 ??
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String b_writter = m.getM_id();
			// 글 내용 
			String b_text = request.getParameter("b_text").replace("\r\n", "<br>");
			
			String formerToken = (String) request.getSession().getAttribute("formerToken");
			System.out.println(formerToken);
			
			String token = request.getParameter("token");
			System.out.println(token);
			
			if (formerToken == null || !token.equals(formerToken)) {
				String sql = "insert into board values(board_seq.nextval, "
						+ "?, sysdate, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, b_writter);
				pstmt.setString(2, b_text);
			}
			
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[Write Successful !]");
				boardCount++;
				request.getSession().setAttribute("formerToken", token);
			} else {
				request.setAttribute("r", "F5");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[Write Failed !]");
		}
		DdokkangDBManager.close(con, pstmt, null);
	}
	
	// 전체 내용
	
	public void getBoard(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			String sql = "select * "
					+ "from ( "
					+ 		"select rownum rn, b_no, b_writer, b_when, b_text "
					+ 		"from ("
					+			"select b_no, b_writer, b_when, b_text "
					+ 			"from board "
					+ 			"order by b_no "
					+ 		")"
					+ ")";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			Board board = null;
			ArrayList<Board> boardArr = new ArrayList<Board>();
			while (rs.next()) {
				board = new Board();
				board.setB_no(rs.getInt("b_no"));
				board.setB_writer(rs.getString("b_writer"));
				board.setB_when(rs.getDate("b_when"));
				board.setB_text(rs.getString("b_text").replace("\r\n", "<br>"));
				boardArr.add(board);
			}
			request.setAttribute("board", boardArr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdokkangDBManager.close(con, pstmt, rs);
	}
	
	// 페이징
	public void getBoardByPage(int pageNo, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			request.setAttribute("EndPage", boardCount);
			
			String sql = "select * "
					+ "from ( "
					+ 		"select rownum rn, b_no, b_writer, b_when, b_text "
					+ 		"from ("
					+			"select b_no, b_writer, b_when, b_text "
					+ 			"from board "
					+ 			"order by b_no "
					+ 		") "
					+ ") "
					+ "where rn=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pageNo);
			
			rs = pstmt.executeQuery();
			
			Board board = null;
			ArrayList<Board> boardArr = new ArrayList<Board>();
			while (rs.next()) {
				board = new Board();
				board.setB_no(rs.getInt("b_no"));
				board.setB_writer(rs.getString("b_writer"));
				board.setB_when(rs.getDate("b_when"));
				board.setB_text(rs.getString("b_text").replace("\r\n", "<br>"));
				boardArr.add(board);
			}
			request.setAttribute("board", boardArr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdokkangDBManager.close(con, pstmt, rs);
	}
	
	// 검색어 (글 내용을 포함하는 글)
	// 그 글의 작성자만 내용을 수정하거나 / 삭제
	
}
