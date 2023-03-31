package com.ddokkang.mar214.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateMembership")
public class CreateMembership extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		// 정보 입력 받은거
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String location = request.getParameter("location");
		String[] hobby = request.getParameterValues("hobby");
//	    List<String> hobby = null;
//	    for (String h : hobby) {
//			h = request.getParameter("hobby");
//		}
//		String[] hobby1 = new String[8]; 
//		for (int i = 0; i < hobby1.length; i++) {
//			if (request.getParameter("hobby") == null) {
//				break;
//			}
//			hobby1[i] = request.getParameter("hobby");
//			
//		}		
		String intro = request.getParameter("intro");
		
		// textarea에서 엔터 : \r\n
		// 웹페이지에서 엔터 : <br>
		intro = intro.replace("\r\n", "<br>");
		
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Membership</title><meta charset='EUC-KR'></head>");
		out.print("<body>");
		// 테이블 만들어서 입력 받은 정보 넣기
		out.print("<table>");
		out.print("<tr>");
		out.print("<td>");
		out.printf("ID : %s ", id);
		out.printf("PW : %s ", pw);
		out.printf("Gender : %s ", gender);
		out.printf("Location : %s ", location);
		if (hobby != null) {	// 취미를 선택하지 않았을 때를 대비
			out.print("Hobby : ");
			for (String s : hobby) {
				out.printf(s + " ");
			}
		}
		out.printf("Introduce : %s ", intro);
		out.print("</td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}

}
