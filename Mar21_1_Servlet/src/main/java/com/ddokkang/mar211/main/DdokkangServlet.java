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
	
	// GET방식 요청(기본) 받으면
	//	주소를 알고 있으면 직접 타이핑해서 접속 O
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 랜선에 붙어있는 응답용 빨대(PrintWriter)
//		PrintWriter out = response.getWriter();
//		out.print("<html>");
//		out.print("<head><title>Hello!</title><meta charset='EUC-KR'></head>");
//		out.print("<body>");
//		for (int i = 0; i < 5; i++) {
//			out.print("<marquee>Hello !</marquee>");
//		}
//		out.print("</body>");
//		out.print("</html>");
		
		// 실행했을 때... 주소창 요청파라미터 lang의 값으로
		// korean을 입력하면 '네'
		// english를 입력하면 'Yes'
		// 그 외에는 '몰라'
		// <h1>에 담아서 출력
		
		// 클라이언트에게 서버측이 어떤 방식으로 인코딩을 했는지 알려줘야함 ! (항상)
		response.setCharacterEncoding("EUC-KR");
		
		// ?변수명=값&변수명=값&...
		String languege = request.getParameter("lang");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Language</title><meta charset='EUC-KR'></head>");
		out.print("<body>");
		out.print("<h1>");

		if (languege.equals("korean")) {
			out.print("네");
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
