package com.ddokkang.mar302.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 숫자 야구
//	3자리 숫자(백의 자리 0 가능) 중복 숫자 X
//	입력하는 부분
//		1. 숫자가 아닌거 입력못하게(값이 안 넘어가도록)
//		2. 중복 숫자 => 다시 입력
//		3. 무조건 3자리 숫자가 되도록 !
//		유효성 검사 !
// 시도횟수, S B Check
// 3S => 정답

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameterNames().hasMoreElements()) {
			playBaseball.getPb().playBall(request);
		} else {
			
		}
		request.getRequestDispatcher("nb.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
