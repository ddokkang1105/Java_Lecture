package com.ddokkang.apr051.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// ���߿� *** �ҵ� ?
// ��
//		�׳� request�� set�� �ϴ� ���
//		parameter(a, b)
//		attribute(cc)
//		��û�� ���� ���� ���� ����� �� �ִ�
//		���ο� ��û�� �Ͼ�� ��Ȳ������ �� ��� �Ұ�
//		Third���� ��Ƽ� �� �� �ִ� ����� �ʿ� (���� Third�����δ� ���� ��û�� ���� ����)
//			: session

//		- parameter
//			GET : �ּҿ�(��Ʈ�ѷ�?�Ķ���͸�=��&�Ķ���͸�=��&...)
//			POST : ��������(��Ʈ�ѷ�?�Ķ���͸�=�� �Ⱥ���)

//		V���� ���� ��
//		String or String[]
//		request �Ҽ�

//			�� �б�
//				Java : request.getParameter("�Ķ���͸�");
//				JSP(EL) : ${param.�Ķ���͸� }

//		- request �Ҽ� attribute
//			M���� ���� ��
//			Object
//			request �Ҽ�

//			�� �б�
//				Java : request.getAttribute("��Ʈ����Ʈ��");
//				JSP(EL) : ${��Ʈ����Ʈ�� }
///////////////////////////////////////////////////////////////////////////////////////////
// HTTP ���������� Ư������ ����
//		1. Connectionless
//			����ڰ� ��û�� �� �Ŀ� ������ �޾��� �� ������ ����� Ư¡
//		2. Stateless
//			����� ������ ���¸� ��������� Ư¡

// �� ������ �����ϱ� ���ؼ� ��Ű / ���� ���

// ��Ű(Cookie) : 
//		����ڰ� ���������� ��ǻ�Ϳ� �����ߴٰ� ���߿� ����
//		����ڰ� ���� ��û�� ���ص� �������� ��û�� �ϸ� 
//		�ڵ����� ������ ������ ��������
//		�� �� �ð��� ���س����� �������� ���� ���οʹ� ������� ������ �� ����
//			=> ID/PW �����ϱ�, ���θ� ��ٱ���, �˾�â (���� �Ϸ� ���� �ʱ�), ...

//		M���� ���� ��
//		String
//		�⺻ �����ð� - 24�ð�?!
//		����� ��ǻ�Ϳ� ����Ǵµ�... -> ����� ��ȣȭ�Ǽ� ����Ǳ� ������...
//		�׷��� ������ ! - ����Ǹ� ������ ������ ��Ű�� �����ϸ� �ȵ� !!

//		�� �б�
//			Java : ���� �������ǻ�Ϳ� ������� �ִ� ��Ű�� -> �� �߿� �� ������Ʈ�� ã�Ƽ�
//			JSP(EL) : ${cookie.�̸�.value }

// ���� (Session) : 
//		��Ű�� ������� ���� BUT ������� ������ Server���� ����
//		���� �ð� ���� O, ���� �ð����� ������ ������ ������ ����
//		��Ű���ٴ� ������ ����, �޸� ��뷮 ŭ
//		������ ���� ������ -> ���� ������ -> ���� ����

//		session �Ҽ� attribute
//		M���� ���� ��
//		Object
//		���Ḹ �Ǿ��ִٸ� ��𿡼����� ����� ���� !
//		�����ð� : �⺻ 30��, ���� ���
//			�ð����� �ƹ� ��û�� ���ϸ� �ڵ����� ����

//		��Ű : ���س��� �ð��� ����ǰų�, ��Ű�� �����ϱ� �������� ����
//		���� : ����Ǵ� �ð��� ������ �� ������, �������� ����Ǹ� �ٷ� ����


public class M {
	public static void makeSecondDate(HttpServletRequest request, HttpServletResponse response) {
		int c = 3000;
		request.setAttribute("cc", c);
		
		int d = 40000;
		HttpSession hs = request.getSession();	// ����ڿ� �������� ���� ����
		hs.setMaxInactiveInterval(15);			// session�� �����ð��� 15��
		hs.setAttribute("d", d);				// session�Ҽ��� attribute
		
		String e = "500000";
		Cookie ck = new Cookie("e", e);
		ck.setMaxAge(15);						// 15�ʵ����� ����� ��ǻ���� ���Ϸ� ����
		response.addCookie(ck);					// ���� ��ü�� ��Ű�� �߰�
		System.out.println("--------------------------------");
	}
	
	public static void printDataNew(HttpServletRequest request) {
		try {
			HttpSession hs = request.getSession();
			int d = (int) hs.getAttribute("d");
			System.out.println("d : " + d);
		} catch (Exception e) {
		}
		
		// �� ������Ʈ, naver, youtube, daum, ...
		// ���� ����� ��ǻ�Ϳ� �ִ� ����
		Cookie[] cks = request.getCookies(); // ����Ǿ��ִ� ��Ű'��'�̶� �迭
		for (Cookie ck : cks) {
			if (ck.getName().equals("e")) {			// ��Ű �̸� e�� ���� 
				System.out.println("ck.getValue() : " + ck.getValue());	// ���
			}
		}
		System.out.println("--------------------------------");
	}
	
	public static void printSecondData(HttpServletRequest request) {
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		int c = (Integer) request.getAttribute("cc");
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
		System.out.println("--------------------------------");
	}
}
