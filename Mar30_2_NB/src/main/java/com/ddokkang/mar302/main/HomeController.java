package com.ddokkang.mar302.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ���� �߱�
//	3�ڸ� ����(���� �ڸ� 0 ����) �ߺ� ���� X
//	�Է��ϴ� �κ�
//		1. ���ڰ� �ƴѰ� �Է¸��ϰ�(���� �� �Ѿ����)
//		2. �ߺ� ���� => �ٽ� �Է�
//		3. ������ 3�ڸ� ���ڰ� �ǵ��� !
//		��ȿ�� �˻� !
// �õ�Ƚ��, S B Check
// 3S => ����

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
