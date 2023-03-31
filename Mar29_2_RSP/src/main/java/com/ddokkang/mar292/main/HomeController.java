package com.ddokkang.mar292.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// JSP Model2를 활용해서
// 가위바위보 게임 웹페이지 !
//		디자인 알아서...
//	WAS 종료할 때까지 전적은 쌓이게 => 매판 진행할 때마다 전적 보이도록(바뀌도록)

// 문제 : GET방식 요청할때마다 다른 객체를 생성하고 있어서 전적이 안 쌓임
//	해결책 : 엔진 하나 !! -> Singleton pattern !!
// 0329 오후 강의 다시 보기
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
