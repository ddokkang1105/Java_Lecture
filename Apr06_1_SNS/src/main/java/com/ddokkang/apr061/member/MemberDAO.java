package com.ddokkang.apr061.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddokkang.db.manager.DdokkangDBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberDAO {
	
	public static boolean loginCheck(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		if (m != null) {
			// �α��� ���� + ���� ������
			request.setAttribute("lp", "member/welcome.jsp");
			return true;
		}
		// �α��� ���°� �ƴϰų� + �α��� ���н�
		request.setAttribute("lp", "member/login.jsp");
		return false;
	}
	public static void signUp(HttpServletRequest request) {
		// ���� ���ε� �õ�
		String path = null;
		MultipartRequest mr = null;
		try {
			path = request.getServletContext().getRealPath("img");
			System.out.println(path);
			mr = new MultipartRequest(request, path, 20 * 1024 * 1024, "EUC-KR", new DefaultFileRenamePolicy());
		} catch (Exception e) {	// ���� ���ε忡 ������ ���
			e.printStackTrace();
			request.setAttribute("r", "Sign Up Failed(Image Size)");
			return;	// ���ε忡 �����ϸ� �Ʒ� ������ DB�۾��� ���� ���� (������ ����)
		}
		
		// ���� ���ε� �����ÿ� ��� ����
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			String id = mr.getParameter("m_id");
			String pw = mr.getParameter("m_pw");
			String name = mr.getParameter("m_name");
			String phone = mr.getParameter("m_phone");
			String y = mr.getParameter("m_y");
			int m = Integer.parseInt(mr.getParameter("m_m"));
			int d = Integer.parseInt(mr.getParameter("m_d"));
			String birthday = String.format("%s%02d%02d", y, m, d);
			
			String photo = mr.getFilesystemName("m_photo");
			
			photo = URLEncoder.encode(photo, "EUC-KR").replace("+", " ");
			
			String sql = "insert into sns values("
					+ "?, ?, ?, ?, to_date(?, 'YYYYMMDD'), ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.setString(5, birthday);
			pstmt.setString(6, photo);
			request.setAttribute("photo", photo);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[Sign Up Success !]");
			}
			
			
		} catch (Exception e) {	// ID �ߺ�, DB���� ������°� ������
			e.printStackTrace();
			// DB�� ������ ������ ��������, ���������� ���ε尡 �Ǿ��ִ� ����
			// �������� ������ ! (���ϸ��� �ѱ�ó���� �ȵǾ��־����)
			File f = new File(path + "/" + mr.getFilesystemName("m_photo"));
			f.delete();
			request.setAttribute("r", "[Sign Up Failed !]");
		}
		DdokkangDBManager.close(con, pstmt, null);
	}
	
	public static void login(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			request.setCharacterEncoding("EUC-KR");
			String id = request.getParameter("m_id");
			String pw = request.getParameter("m_pw");
			
			// String sql = "select * from sns"; // ȸ���� 1000���̸� �װ� �� ~~?
			// String sql = "select * from sns where m_id=? and m_pw=?";
			// ��ŷ ��� - SQL Injection
			//		���Ȼ� ������� �̿��ؼ� �����ͺ��̽��� ���������� ������ �ϰ� �ϴ� ���
			
			String sql = "select * from sns where m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {	// �����Ͱ� �ִ��� + �� �����͸� ����Ű��...
				String dbPw = rs.getString("m_pw");
				if (dbPw.equals(pw)) {
					Member m = new Member(rs.getString("m_id"), rs.getString("m_pw"), rs.getString("m_name"), rs.getString("m_phone"),
							rs.getDate("m_birthday"), rs.getString("m_photo"));
					request.getSession().setAttribute("loginMember", m);
					request.getSession().setMaxInactiveInterval(600);
					
					Cookie c = new Cookie("lastLoginId", id);
					c.setMaxAge(60 * 60 * 24 * 5);
					response.addCookie(c);
					request.setAttribute("r", "[Login Success !]");
				} else {
					request.setAttribute("r", "[Login Failed(PW Error) !]");
				}
			} else {
				request.setAttribute("r", "[Login Failed(No Regist ID) !]");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[Login Failed(DB Server Error) !]");
		}
		DdokkangDBManager.close(con, pstmt, rs);
		
	}

	public static void logout(HttpServletRequest request) {
		// ���� ���� : �ٸ� ���ǵ� �� ���� ���� �־.. ���� !
//		request.getSession().setMaxInactiveInterval(-1);
		
		// Member�� ���� session�� null�� �ٲ��ָ�...
		request.getSession().setAttribute("loginMember", null);
		request.setAttribute("r", "[LogOut Success !]");
	}
	
	public static void update(HttpServletRequest request) {
		// ���� ���ε忡 �����ϸ�(���� �뷮�� �ʰ�) -> �ű⼭ ıƮ !
		String path = null;
		MultipartRequest mr = null;
		Member m = (Member) request.getSession().getAttribute("loginMember");
		String old_m_photo = m.getM_photo();
		String new_m_photo = null;
		
		try {
			path = request.getServletContext().getRealPath("img");
			mr = new MultipartRequest(request, path, 20 * 1024 * 1024, "EUC-KR", new DefaultFileRenamePolicy());
			
			new_m_photo = mr.getFilesystemName("m_photo");	// ������ ���ϸ�
			if (new_m_photo != null) {	// �� ������ (���ο� ������ �־��ٸ�)
				new_m_photo = URLEncoder.encode(new_m_photo, "EUC-KR").replace("+", " ");
			} else {	// �� ������ (���ο� ������ �ȳ־��ٸ�)
				new_m_photo = old_m_photo;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���� �뷮...");
			return;
		}
		
		// ������� �����ϴµ� �� �� ������ !
		
		// ���� ����� 20MB �����ɷ� �� �����ؼ� - ���� ���ε� ����
		// ���� ���� ���ؼ� (0MB)
		
		// ���� ������ �ߴ� : ���� �ٲٰڴ� -> �� ���� ���ϸ��� DB�� �־��
		//					-> �� ���� ���ϸ��� Ȯ��
		// ���� ���� ���� ������ �ؾ� -> ���� ���� ���ϸ��� Ȯ�� !
		
		// ���� ������ ���ϸ� : ���� �� �ٲٰڴ� -> ���� ���� ���ϸ��� DB�� �־��
		//					-> ���� ���� ���ϸ��� Ȯ��
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			String id = mr.getParameter("m_id");
			String pw = mr.getParameter("m_pw");
			String name = mr.getParameter("m_name");
			String phone = mr.getParameter("m_phone");
			String m_y = mr.getParameter("m_y");
			int m_m = Integer.parseInt(mr.getParameter("m_m"));
			int m_d = Integer.parseInt(mr.getParameter("m_d"));
			String birthday = String.format("%s%02d%02d", m_y, m_m, m_d);
			
			String sql = "update sns set m_pw=?, m_name=?, m_phone=?, "
					+ "m_birthday=to_date(?, 'YYYYMMDD'), m_photo=? "
					+ "where m_id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, phone);
			pstmt.setString(4, birthday);
			pstmt.setString(5, new_m_photo);
			pstmt.setString(6, id);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[Change Success !]");
				if (!new_m_photo.equals(old_m_photo)) {
					// ���� �������� �����
					new File(path + "/" + URLDecoder.decode(old_m_photo, "EUC-KR")).delete();
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				m = new Member(id, pw, name, phone, sdf.parse(birthday), new_m_photo);
				request.getSession().setAttribute("loginMember", m);
				
			} else {
				request.setAttribute("r", "[Change Fail !]");
				if (!new_m_photo.equals(old_m_photo)) {	// ���ο� ���� �ö󰣰� ����
					new File(path + "/" + URLDecoder.decode(new_m_photo, "EUC-KR")).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[Change Fail !(DB Error)]");
			if (!new_m_photo.equals(old_m_photo)) {	// ���ο� ���� �ö󰣰� ����
				try {
					new File(path + "/" + URLDecoder.decode(new_m_photo, "EUC-KR")).delete();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		DdokkangDBManager.close(con, pstmt, null);
	}
	
	public static void delete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String m_id = m.getM_id();
			
			String sql = "delete from sns where m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[Drop Success !]");
				String m_photo = m.getM_photo();	// �ѱ�ó�� �Ǿ�����
				m_photo = URLDecoder.decode(m_photo, "EUC-KR");	// ���󺹱�
				String path = request.getServletContext().getRealPath("img");
				File f = new File(path + "/" + m_photo);
				f.delete();
			} else {
				request.setAttribute("r", "[Already Drop !]");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[Drop Fail !(DB Error)]");
		}
		DdokkangDBManager.close(con, pstmt, null);
		
		// ȸ�� Ż�� + ȸ�� ������ ���� �����
		// ���ǿ��� ������ �� ������ ��������...
		// DeleteMemberController ���� ó���� �� !
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////	
	
	public static void submitBoard(HttpServletRequest request) {
//		Board board = null;
		
		String text = request.getParameter("b_text");
		text.replace("\r\n", "<br>");
	}
	
	public static void dropMember(HttpServletRequest request) {
		String path = null;
		Member m = (Member) request.getSession().getAttribute("loginMember");
		String old_m_photo = m.getM_photo();

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			path = request.getServletContext().getRealPath("img"); 
			
			String id = request.getParameter("m_id");
			String sql = "delete from sns where m_id=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			if (pstmt.executeUpdate() == 1) {
				request.getSession().setAttribute("loginMember", null);
				request.setAttribute("r", "[Drop Success !]");
				new File(path + "/" + URLDecoder.decode(old_m_photo, "EUC-KR")).delete();
			} else {
				request.setAttribute("r", "[Drop Fail !]");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdokkangDBManager.close(con, pstmt, null);
		
	}
	
	public static void changeMember(HttpServletRequest request) {
		
		
		Member m = (Member) request.getSession().getAttribute("loginMember");
//		System.out.println(m.getM_id());
//		System.out.println(m.getM_pw());
//		System.out.println(m.getM_name());
//		System.out.println(m.getM_phone());
//		System.out.println(m.getM_birthday());
//		System.out.println(m.getM_photo());
		
		Date birth = m.getM_birthday();
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		String m_m = sdf.format(birth);
//		System.out.println(m_y);
		request.setAttribute("m_m", m_m);
		
	}
	
	public static void loginMember(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			String id = request.getParameter("m_id");
			String pw = request.getParameter("m_pw");
//			System.out.println(id);
//			System.out.println(pw);
			
			String sql = "select * from sns where m_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			Member mem = null;
			while (rs.next()) {
				mem = new Member();
				mem.setM_id(rs.getString("m_id"));
				mem.setM_pw(rs.getString("m_pw"));
				mem.setM_name(rs.getString("m_name"));
				mem.setM_phone(rs.getString("m_phone"));
				mem.setM_birthday(rs.getDate("m_birthday"));
				mem.setM_photo(rs.getString("m_photo"));
			}
//			System.out.println(mem.getM_id());
//			System.out.println(mem.getM_pw());
//			System.out.println(mem.getM_name());
//			System.out.println(mem.getM_phone());
//			System.out.println(mem.getM_birthday());
//			System.out.println(mem.getM_photo());
//			System.out.println("===================================");
			
			if ((mem.getM_id().equals(id)) && (mem.getM_pw().equals(pw))) {
				Member m = new Member(mem.getM_id(), mem.getM_pw(), mem.getM_name(), mem.getM_phone(), mem.getM_birthday(), mem.getM_photo());
				request.getSession().setAttribute("loginMember", m);
				request.getSession().setMaxInactiveInterval(60);
			} else {
				request.setAttribute("r", "[Login Failed !]");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[Login Failed !]");
		}
		DdokkangDBManager.close(con, pstmt, rs);
		
		
	}
	
	public static void signUpMember(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			
			request.setCharacterEncoding("EUC-KR");
			
			String path = request.getServletContext().getRealPath("img");
			System.out.println(path);
			
			MultipartRequest mr = new MultipartRequest(request, path,
					10 * 1024 * 1024, "EUC-KR", new DefaultFileRenamePolicy());
			
			Member mem = new Member();
			mem.setM_id(mr.getParameter("m_id"));
			mem.setM_pw(mr.getParameter("m_pw"));
			mem.setM_name(mr.getParameter("m_name"));
			mem.setM_phone(mr.getParameter("m_phone"));
//			mem.setM_birthday(mr.getParameter("m_birthday_y"));
			mem.setM_photo(URLEncoder.encode(mr.getFilesystemName("m_photo"), "EUC-KR").replace("+", " "));
			
//			String b_y = mr.getParameter("m_y");
//			String b_m = mr.getParameter("m_m");
//			String b_d = mr.getParameter("m_d");
			
//			System.out.println(b_y);
//			System.out.println(b_m);
//			System.out.println(b_d);
//			System.out.println("--------------------------------");
//			System.out.println(mem.getM_id());
//			System.out.println(mem.getM_pw());
//			System.out.println(mem.getM_name());
//			System.out.println(mem.getM_phone());
//			System.out.println(mem.getM_photo());
//			System.out.println("--------------------------------");
			
			
			
			
			
			
		} catch (Exception e) {
		}
		DdokkangDBManager.close(con, pstmt, null);
		
	}
	
}
