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
	
	// 사용자가 입력한 데이터가 주소에
	// 인터넷 주소에 한글 - X
	//		ㅋ -> %2A%AC (URL인코딩)
	
	// 사용자가 입력한 ㅋ(EUC-KR) -URLEncoding-> %2A%AC
	// 사용자로부터 받아온 %2A%AC -URLDecoding-> ㅋ
	
	// GET방식 요청파라미터 한글처리
	//		EUC-KR로 맞추자 !!
	//		Tomcat server.xml 63번줄 설정을 건드렸음
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
	
	// GET방식요청 vs POST방식요청
	// GET : 요청 파라미터가 주소에 있음
	//		대부분 GET방식을 사용함
	// POST : 요청 파라미터가 주소에 없음, 내부적으로 전달
	//		보안성 높음 - 로그인, 회원가입, ...
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR"); // 이거 안하면 한글 깨져서 나옴 !
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
