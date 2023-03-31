package com.ddokkang.mar212.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	// GET��� ��û - ���� x, y ���� �޾��� ��
	// ��Ģ���꿡 ���� ����� ����ϴ� ������
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("EUC-KR");
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Calculator</title><meta charset='EUC-KR'></head>");
		out.print("<body>");
		out.print("<h1>Calculator</h1>");
		out.print("<table border='1'>");
		out.print("<tr>");
		out.print("<th>X, Y</th>");
		out.print("<th>X + Y</th>");
		out.print("<th>X - Y</th>");
		out.print("<th>X * Y</th>");
		out.print("<th>X / Y</th>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>");
		out.printf("%d, %d", x, y);
		out.print("</td>");
		out.print("<td align='center'>");
		out.print(x + y);
		out.print("</td align='center'>");
		out.print("<td align='center'>");
		out.print(x - y);
		out.print("</td>");
		out.print("<td align='center'>");
		out.print(x * y);
		out.print("</td>");
		out.print("<td align='center'>");
		if (y == 0) {
			out.print("�߸��� ���Դϴ�.");
		} else {
			out.printf("%.2f", (double) x / y);
		}
		out.print("</td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
