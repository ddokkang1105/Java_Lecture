package com.ddokkang.mar211.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DdokkangServlet")
public class DdokkangServlet extends HttpServlet {
	
	// GET��� ��û(�⺻) ������
	//	�ּҸ� �˰� ������ ���� Ÿ�����ؼ� ���� O
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������ �پ��ִ� ����� ����(PrintWriter)
//		PrintWriter out = response.getWriter();
//		out.print("<html>");
//		out.print("<head><title>Hello!</title><meta charset='EUC-KR'></head>");
//		out.print("<body>");
//		for (int i = 0; i < 5; i++) {
//			out.print("<marquee>Hello !</marquee>");
//		}
//		out.print("</body>");
//		out.print("</html>");
		
		// �������� ��... �ּ�â ��û�Ķ���� lang�� ������
		// korean�� �Է��ϸ� '��'
		// english�� �Է��ϸ� 'Yes'
		// �� �ܿ��� '����'
		// <h1>�� ��Ƽ� ���
		
		// Ŭ���̾�Ʈ���� �������� � ������� ���ڵ��� �ߴ��� �˷������ ! (�׻�)
		response.setCharacterEncoding("EUC-KR");
		
		// ?������=��&������=��&...
		String languege = request.getParameter("lang");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Language</title><meta charset='EUC-KR'></head>");
		out.print("<body>");
		out.print("<h1>");

		if (languege.equals("korean")) {
			out.print("��");
		} else if (languege.equals("english")) {
			out.print("Yes");
		} else {
			out.print(";;");
		}
		
		out.print("</h1>");
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
