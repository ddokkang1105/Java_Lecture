package com.ddokkang.mar292.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// JSP Model2�� Ȱ���ؼ�
// ���������� ���� �������� !
//		������ �˾Ƽ�...
//	WAS ������ ������ ������ ���̰� => ���� ������ ������ ���� ���̵���(�ٲ��)

// ���� : GET��� ��û�Ҷ����� �ٸ� ��ü�� �����ϰ� �־ ������ �� ����
//	�ذ�å : ���� �ϳ� !! -> Singleton pattern !!
// 0329 ���� ���� �ٽ� ����
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RSPResult rspr = new RSPResult();
//		rspr.setWin(rspr.getWin() + 1);
//		rspr.setWin(rspr.getDraw() + 2);
//		rspr.setWin(rspr.getLose() + 3);
//		request.setAttribute("rspr1", rspr);
		
		if (!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("RSPOutput.jsp").forward(request, response);
		} else {
			RSPEngine rspe = RSPEngine.getRspe();
			rspe.calculate(request);
			System.out.println(rspe);
			request.getRequestDispatcher("RSPOutput.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
