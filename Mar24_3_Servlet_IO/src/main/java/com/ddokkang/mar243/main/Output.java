package com.ddokkang.mar243.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/Output")
public class Output extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("EUC-KR");
		
		String path = request.getServletContext().getRealPath("img");
		System.out.println(path);
		
		MultipartRequest mr = new MultipartRequest(request, path,
				10 * 1024 * 1024, "EUC-KR", new DefaultFileRenamePolicy());
		
		String name = mr.getParameter("name");
		double height = Double.parseDouble(mr.getParameter("height"));
		double weight = Double.parseDouble(mr.getParameter("weight"));
		double bmi = weight / ((height / 100) * (height / 100));
		String bmiResult = null;
		
		if (bmi >= 40) {
			bmiResult = "Severe obesity";
		} else if (bmi >= 30) {
			bmiResult = "Moderate obesity";
		} else if (bmi >= 25) {
			bmiResult = "Mild obesity";
		} else if (bmi >= 23) {
			bmiResult = "Overweight";
		} else if (bmi >= 18.5) {
			bmiResult = "Normal weight";
		} else {
			bmiResult = "Underweight";
		}
		
		String fileName = mr.getFilesystemName("image");
		
		fileName = URLEncoder.encode(fileName, "EUC-KR");
		fileName = fileName.replace("+", " ");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><meta charset='EUC-KR'></head>");
		out.print("<body>");
		out.printf("Name : %s <br>", name);
		out.print("<br>");
		out.printf("Height : %.1f <br>", height);
		out.print("<br>");
		out.printf("Weight : %.1f <br>", weight);
		out.print("<hr>");
		out.printf("BMI Result : %.1f <br>", bmi);
		out.print("<br>");
		out.printf("BMI Caution : %s <br>", bmiResult);
		out.print("<hr>");
		out.printf("<img src='img/%s'>", fileName); // 상대경로 O
		
		out.print("</body>");
		out.print("</html>");
		
		
		
		
		
		
		
		
		
	}
}
