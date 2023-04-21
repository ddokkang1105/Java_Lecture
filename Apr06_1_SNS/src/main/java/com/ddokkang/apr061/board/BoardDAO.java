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

	// ��ü ����
	// ����¡
	// �� ���� �ۼ��ڸ� ������ �����ϰų� / ����
	
	//////////////////////////////////////////////////////////////////////////////////////////
	// ���� �ִ� ���뿡�� �˻��� ���� ����¡�� ��� �װſ� ���� �ڵ� �߰�
	
	// "s_board"�� �������� ���� �˻��� ���� ����¡���� �˻�� ������ �� �ְ� ���ְ�
	// ��ü ����¡�ϴ� �޼ҵ忡�� "s_board"���� ������ null�� �����Ͽ� ��ü�� ���, 
	// ���� ������ �˻��� ���� count�� ������ boardCount�� �־ �� ������ ���� ����¡�� �� �� �ֵ���
	
	// "s_board"�� �������� �����
	public void searchBoardMsg(HttpServletRequest request) {
		String s_board = request.getParameter("s_board");
		request.getSession().setAttribute("s_board", s_board);
	}
	
	// �Խ��� ó�� �������� �� �˻��� �ʱ�ȭ ��Ű��
	public void clearSearch(HttpServletRequest request) {
		request.getSession().setAttribute("s_board", null);
	}
	
	// �˻��� ���� count(*) - Controller���� ���� ������� ���� �Ŷ� private
	// ���ϰ��� int�� �����Ͽ� �˻��� ���� count���� ��ȯ
	private int getSearchCount(String s_board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			String sql = "select count(*) from sns, board where b_writer = m_id and b_text like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s_board);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("count(*)");
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;	// �˻�� �ش��ϴ� �Խñ��� ���� ��
		} finally {
			DdokkangDBManager.close(con, pstmt, rs);
		}
	}
	
	// ����¡�ϴ� �޼ҵ� ����� ! �ε� �˻����� ��/���� �߰��� ����
	public void getBoardMsgByPage(int pageNo, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String s_board = (String) request.getSession().getAttribute("s_board");
			
			int startPage = 1;
			int endPage = boardCount;
			if (s_board == null) {
				s_board = "";
			} else {
				endPage = getSearchCount(s_board);
			}
			
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("pageNo", pageNo);
			
			con = DdokkangDBManager.connect("ddokkangPool");
			
			String sql = "select * "
					+ "from ( "
					+ 		"select rownum rn, b_no, b_writer, b_when, b_text, m_photo "
					+ 		"from ("
					+			"select * "
					+ 			"from board, sns "
														// UPPER �Լ��� �̿��� ��/�ҹ��� ������� ã��
					+ 			"where b_writer = m_id and upper(b_text) like upper('%'||?||'%') "
					+ 			"order by b_when "
					+ 		") "
					+ ") "
					+ "where rn=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s_board);
			pstmt.setInt(2, pageNo);
			
			rs = pstmt.executeQuery();
			
			ArrayList<Board> board = new ArrayList<Board>();
			Board b = null;
			
			while (rs.next()) {
				b = new Board();
				b.setB_no(rs.getInt("b_no"));
				b.setB_writer(rs.getString("b_writer"));
				b.setB_when(rs.getDate("b_when"));
				b.setB_text(rs.getString("b_text"));
				b.setM_photo(rs.getString("m_photo"));
				board.add(b);
			}
			request.setAttribute("board", board);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdokkangDBManager.close(con, pstmt, rs);
	}
	
	
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
			// insert�� ���� ��
			// �� ��ȣ - seq
			// �ۼ� ��¥ - sysdate
			// �� �ۼ��� ���̵� ??
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String b_writter = m.getM_id();
			// �� ���� 
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
				// ���� �߰��ϱ�
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
				// �����߰��ϱ�
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
