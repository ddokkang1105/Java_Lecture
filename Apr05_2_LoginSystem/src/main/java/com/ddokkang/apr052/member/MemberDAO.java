package com.ddokkang.apr052.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDAO {
	// �α��� ���
	public static void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("EUC-KR");
			Member mem = new Member();
			mem.setId(request.getParameter("id"));
			mem.setPw(request.getParameter("pw"));
			
			// �α��� ������ ���� ���� (ID & PW)
			//		����Ʈ ��𿡼����� ��� ����
			//		�����ð��� ������ �α��� ���� Ǯ����
			//		session �Ҽ��� attribute or cookie
			//		cookie�� ������ !!
			if (mem.getId().equals("Help") && mem.getPw().equals("me")) {
				Member m = new Member(mem.getId(), mem.getPw());
				request.getSession().setAttribute("m", m);
				request.getSession().setMaxInactiveInterval(10);
			}
			
			// �ѹ� �α��ο� ����������, ������ �� ����Ʈ�� ������ ��
			//	<input>�� id�� �����־�����...
			//	������ ���, ������ص� �����ִ°�... => cookie !
			
			Cookie c = new Cookie("lastLoginId", mem.getId());
			c.setMaxAge(60);
			response.addCookie(c);
			
			} catch (Exception e) {
			}
		}
	
		// �������� �������� �ٴ��ٵ�... => �α����� �Ǿ��ִ��� Ȯ���� �Ǿ�߰��� !
		public static boolean loginCheck(HttpServletRequest request) {
			Member m = (Member) request.getSession().getAttribute("m");
			// �α����� �������̰ų�, �α����� ���������� 41������ ���� �� !
			return (m != null);
		}
}
