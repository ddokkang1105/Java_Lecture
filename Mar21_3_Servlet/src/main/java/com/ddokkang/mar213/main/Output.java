package com.ddokkang.mar213.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Output")
public class Output extends HttpServlet {
	
	// ����ڰ� �Է��� �����Ͱ� �ּҿ�
	// ���ͳ� �ּҿ� �ѱ� - X
	//		�� -> %2A%AC (URL���ڵ�)
	
	// ����ڰ� �Է��� ��(EUC-KR) -URLEncoding-> %2A%AC
	// ����ڷκ��� �޾ƿ� %2A%AC -URLDecoding-> ��
	
	// GET��� ��û�Ķ���� �ѱ�ó��
	//		EUC-KR�� ������ !!
	//		Tomcat server.xml 63���� ������ �ǵ����
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("EUC-KR");
		String a = request.getParameter("a");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Hi</title><meta charset='EUC-KR'></head>");
		out.print("<body>");
		
		out.print("<h2>Output-Get</h2>");
		out.printf("<h2>%s</h2>", a);
		
		out.print("</body>");
		out.print("</html>");
	}
	
	// GET��Ŀ�û vs POST��Ŀ�û
	// GET : ��û �Ķ���Ͱ� �ּҿ� ����
	//		��κ� GET����� �����
	// POST : ��û �Ķ���Ͱ� �ּҿ� ����, ���������� ����
	//		���ȼ� ���� - �α���, ȸ������, ...
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR"); // �̰� ���ϸ� �ѱ� ������ ���� !
		response.setCharacterEncoding("EUC-KR");
		String a = request.getParameter("a");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Hi</title><meta charset='EUC-KR'></head>");
		out.print("<body>");
		
		out.print("<h2>Output-POST</h2>");
		out.printf("<h2>%s</h2>", a);
		
		out.print("</body>");
		out.print("</html>");
	}

}