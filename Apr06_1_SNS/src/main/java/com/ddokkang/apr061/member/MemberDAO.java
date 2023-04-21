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
		// 세션 끊기 : 다른 세션도 들어가 있을 수도 있어서.. 비추 !
//		request.getSession().setMaxInactiveInterval(-1);
		
		// Member에 대한 session만 null로 바꿔주면...
		request.getSession().setAttribute("loginMember", null);
		request.setAttribute("r", "[LogOut Success !]");
	}
	
	public static void update(HttpServletRequest request) {
		// 파일 업로드에 실패하면(파일 용량이 초과) -> 거기서 캇트 !
		String path = null;
		MultipartRequest mr = null;
		Member m = (Member) request.getSession().getAttribute("loginMember");
		String old_m_photo = m.getM_photo();
		String new_m_photo = null;
		
		try {
			path = request.getServletContext().getRealPath("img");
			mr = new MultipartRequest(request, path, 20 * 1024 * 1024, "EUC-KR", new DefaultFileRenamePolicy());
			
			new_m_photo = mr.getFilesystemName("m_photo");	// 선택한 파일명
			if (new_m_photo != null) {	// 이 있으면 (새로운 파일을 넣었다면)
				new_m_photo = URLEncoder.encode(new_m_photo, "EUC-KR").replace("+", " ");
			} else {	// 이 없으면 (새로운 파일을 안넣었다면)
				new_m_photo = old_m_photo;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일 용량...");
			return;
		}
		
		// 여기까지 진행하는데 별 일 없었다 !
		
		// 파일 사이즈가 20MB 적은걸로 잘 선택해서 - 파일 업로드 성공
		// 파일 선택 안해서 (0MB)
		
		// 파일 선택을 했다 : 프사 바꾸겠다 -> 새 프사 파일명을 DB에 넣어야
		//					-> 새 프사 파일명을 확보
		// 기존 프사 파일 삭제도 해야 -> 원래 프사 파일명을 확보 !
		
		// 파일 선택을 안하면 : 프사 안 바꾸겠다 -> 기존 프사 파일명을 DB에 넣어야
		//					-> 원래 프사 파일명을 확보
		
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
					// 기존 사진파일 지우기
					new File(path + "/" + URLDecoder.decode(old_m_photo, "EUC-KR")).delete();
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				m = new Member(id, pw, name, phone, sdf.parse(birthday), new_m_photo);
				request.getSession().setAttribute("loginMember", m);
				
			} else {
				request.setAttribute("r", "[Change Fail !]");
				if (!new_m_photo.equals(old_m_photo)) {	// 새로운 사진 올라간거 삭제
					new File(path + "/" + URLDecoder.decode(new_m_photo, "EUC-KR")).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[Change Fail !(DB Error)]");
			if (!new_m_photo.equals(old_m_photo)) {	// 새로운 사진 올라간거 삭제
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
				String m_photo = m.getM_photo();	// 한글처리 되어있음
				m_photo = URLDecoder.decode(m_photo, "EUC-KR");	// 원상복귀
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
		
		// 회원 탈퇴 + 회원 프로필 사진 지우기
		// 세션에는 여전히 그 정보가 남아있음...
		// DeleteMemberController 에서 처리할 것 !
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
