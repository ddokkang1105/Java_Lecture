package com.ddokkang.apr061.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ddokkang.apr061.member.Member;
import com.ddokkang.db.manager.DdokkangDBManager;

public class BoardDAO {
	private int boardCount;
	
	private static final BoardDAO BDAO = new BoardDAO();
	
	private BoardDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static BoardDAO getBdao() {
		return BDAO;
	}

	// 전체 내용
	// 페이징
	// 그 글의 작성자만 내용을 수정하거나 / 삭제
	
	//////////////////////////////////////////////////////////////////////////////////////////
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
//			System.out.println("Count : " + boardCount);
			
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
				request.getSession().setAttribute("formerToken", token);
				boardCount++;
			} else {
				request.setAttribute("r", "F5");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[Write Failed !]");
		}
		DdokkangDBManager.close(con, pstmt, null);
	}
	
	public void getBoard(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			String sql = "select * "
					+ "from ( "
					+ 		"select rownum rn, b_no, b_writer, b_when, b_text, m_photo "
					+ 		"from ("
					+			"select * "
					+ 			"from board, sns "
					+ 			"where b_writer = m_id "
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
				board.setM_photo(rs.getString("m_photo"));
				boardArr.add(board);
			}
			request.setAttribute("board", boardArr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdokkangDBManager.close(con, pstmt, rs);
	}
	
	public void getBoardByPage(int pageNo, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			int startPage = 1;
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", boardCount);
			request.setAttribute("pageNo", pageNo);
			
//			Member m = (Member) request.getSession().getAttribute("loginMember");
//			String m_photo = m.getM_photo();
			
			String sql = "select * "
					+ "from ( "
					+ 		"select rownum rn, b_no, b_writer, b_when, b_text, m_photo "
					+ 		"from ("
					+			"select * "
					+ 			"from board, sns "
					+ 			"where b_writer = m_id "
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
				board.setM_photo(rs.getString("m_photo"));
				// 사진 추가하기
//				board.setM_photo(m_photo);
				boardArr.add(board);
			}
			request.setAttribute("board", boardArr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdokkangDBManager.close(con, pstmt, rs);
	}
	
	public void searchBoard(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			String search = request.getParameter("s_board");
			
			String sql = "select b_no, b_writer, b_when, b_text, m_photo from board, sns "
					+ "where b_text like '%'||?||'%' and b_writer = m_id";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			
			rs = pstmt.executeQuery();
			
			ArrayList<Board> s_board = new ArrayList<Board>();
			Board b = null;
			while (rs.next()) {
				b = new Board();
				b.setB_no(rs.getInt("b_no"));
				b.setB_writer(rs.getString("b_writer"));
				b.setB_when(rs.getDate("b_when"));
				b.setB_text(rs.getString("b_text").replace("\r\n", "<br>"));
				// 사진추가하기
				b.setM_photo(rs.getString("m_photo"));
				s_board.add(b);
			}
			request.setAttribute("s_board", s_board);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdokkangDBManager.close(con, pstmt, rs);
	}
	
	public void editBoard(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			int b_no = Integer.parseInt(request.getParameter("b_no"));
			String b_text = request.getParameter("b_text");
			
			String sql = "update board set b_when=sysdate, b_text=? where b_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, b_text);
			pstmt.setInt(2, b_no);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[Edit Success !]");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[Edit Fail !]");
		}
		DdokkangDBManager.close(con, pstmt, null);
	}
	
	public void deleteBoard(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			int b_no = Integer.parseInt(request.getParameter("b_no"));
			
			String sql = "delete from board where b_no=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[Delete Success !]");
				boardCount--;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[Delete Fail !]");
		}
		DdokkangDBManager.close(con, pstmt, null);
	}
	
}
