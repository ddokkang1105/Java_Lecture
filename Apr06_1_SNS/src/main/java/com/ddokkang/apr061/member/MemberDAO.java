package com.ddokkang.apr061.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			// 로그인 성공 + 상태 유지시
			request.setAttribute("lp", "member/welcome.jsp");
			return true;
		}
		// 로그인 상태가 아니거나 + 로그인 실패시
		request.setAttribute("lp", "member/login.jsp");
		return false;
	}
	public static void signUp(HttpServletRequest request) {
		// 파일 업로드 시도
		String path = null;
		MultipartRequest mr = null;
		try {
			path = request.getServletContext().getRealPath("img");
			System.out.println(path);
			mr = new MultipartRequest(request, path, 20 * 1024 * 1024, "EUC-KR", new DefaultFileRenamePolicy());
		} catch (Exception e) {	// 파일 업로드에 실패한 경우
			e.printStackTrace();
			request.setAttribute("r", "Sign Up Failed(Image Size)");
			return;	// 업로드에 실패하면 아래 내용의 DB작업은 하지 말자 (강제로 종료)
		}
		
		// 파일 업로드 성공시에 계속 진행
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
			
			
		} catch (Exception e) {	// ID 중복, DB서버 연결상태가 안좋음
			e.printStackTrace();
			// DB쪽 문제로 가입은 실패지만, 사진파일은 업로드가 되어있는 상태
			// 사진파일 지워야 ! (파일명은 한글처리가 안되어있어야함)
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
			
			// String sql = "select * from sns"; // 회원이 1000명이면 그거 다 ~~?
			// String sql = "select * from sns where m_id=? and m_pw=?";
			// 해킹 기법 - SQL Injection
			//		보안상 취약점을 이용해서 데이터베이스가 비정상적인 동작을 하게 하는 기법
			
			String sql = "select * from sns where m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {	// 데이터가 있는지 + 그 데이터를 가리키게...
				String dbPw = rs.getString("m_pw");
				if (dbPw.equals(pw)) {
					Member m = new Member(rs.getString("m_id"), rs.getString("m_pw"), rs.getString("m_name"), rs.getString("m_phone"),
							rs.getDate("m_birthday"), URLDecoder.decode(rs.getString("m_photo"), "EUC-KR"));
					request.getSession().setAttribute("loginMember", m);
					request.getSession().setMaxInactiveInterval(600);
					
					Cookie c = new Cookie("lastLogin", id);
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
		// 세션 끊기 : 다른 세션도 들어가 있을 수도 있어서.. 비추 !
//		request.getSession().setMaxInactiveInterval(-1);
		
		// Member에 대한 session만 null로 바꿔주면...
		request.getSession().setAttribute("loginMember", null);
		request.setAttribute("r", "[LogOut Success !]");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////	
	
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
			
			String b_y = mr.getParameter("m_y");
			String b_m = mr.getParameter("m_m");
			String b_d = mr.getParameter("m_d");
			
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
