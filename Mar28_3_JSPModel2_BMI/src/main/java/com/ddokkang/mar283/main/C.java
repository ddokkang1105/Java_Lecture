package com.ddokkang.mar283.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/C")
public class C extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("V1.html").forward(request, response);	// V1.html ȣ��
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// BMI ��� ���
		Doctor.calculate(request);
		request.getRequestDispatcher("V2.jsp").forward(request, response);

		
		
//		M.resultBMI(request);	// BMI ����ϱ�
//		request.getRequestDispatcher("V2.jsp").forward(request, response);	// V2.jsp ȣ��
//		Doctor d = new Doctor();
//		M.resultBMI(request, d);	// BMI ����ϱ�
//		
//		String fileName = request.getParameter("fileName");
//		
//		PrintWriter out = response.getWriter();
//		out.print("<html>");
//		out.print("<head><meta charset='EUC-KR'></head>");
//		out.print("<body>");
//		out.printf("Name : %s <br>", d.getpName());
//		out.print("<br>");
//		out.printf("Height : %d <br>", d.getpHeight());
//		out.print("<br>");
//		out.printf("Weight : %d <br>", d.getpWeight());
//		out.print("<hr>");
////		out.printf("BMI Result : %.1f <br>", bmi);
////		out.print("<br>");
////		out.printf("BMI Caution : %s <br>", bmiResult);
////		out.print("<hr>");
//		out.printf("<img src='img/%s'>", fileName); // ����� O
//		
//		out.print("</body>");
//		out.print("</html>");
		
		
		
	}

}
