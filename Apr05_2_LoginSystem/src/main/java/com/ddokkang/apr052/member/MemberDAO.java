package com.ddokkang.apr052.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDAO {
	// 로그인 기능
	public static void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("EUC-KR");
			Member mem = new Member();
			mem.setId(request.getParameter("id"));
			mem.setPw(request.getParameter("pw"));
			
			// 로그인 성공한 유저 정보 (ID & PW)
			//		사이트 어디에서든지 사용 가능
			//		일정시간이 지나면 로그인 상태 풀리게
			//		session 소속의 attribute or cookie
			//		cookie는 위험해 !!
			if (mem.getId().equals("Help") && mem.getPw().equals("me")) {
				Member m = new Member(mem.getId(), mem.getPw());
				request.getSession().setAttribute("m", m);
				request.getSession().setMaxInactiveInterval(10);
			}
			
			// 한번 로그인에 성공했으면, 다음에 이 사이트에 들어왔을 때
			//	<input>에 id가 남아있었으면...
			//	접속을 끊어도, 재부팅해도 남아있는것... => cookie !
			
			Cookie c = new Cookie("lastLoginId", mem.getId());
			c.setMaxAge(60);
			response.addCookie(c);
			
			} catch (Exception e) {
			}
		}
	
		// 페이지를 여기저기 다닐텐데... => 로그인이 되어있는지 확인이 되어야겠음 !
		public static boolean loginCheck(HttpServletRequest request) {
			Member m = (Member) request.getSession().getAttribute("m");
			// 로그인이 유지중이거나, 로그인이 성공했으면 41번줄이 있을 것 !
			return (m != null);
		}
}
