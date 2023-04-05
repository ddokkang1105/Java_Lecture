package com.ddokkang.apr051.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// ***����
// Controller
//		JSPȯ�濡�� ��Ȳ�Ǵ���...!
//			(GET? POST?) �ϱ⿡�� Servlet�� ���� !
//				����� �ؾ��ϸ� M(Model)����
//				��������ϸ� V(View)�� 
//	�帧 ����


@WebServlet("/FirstC") // <- FirstC ��Ĺ�� ��� !
public class FirstC extends HttpServlet {
	
	// �� ������Ʈ���� main�޼ҵ尡 ����
	// ��Ĺ�� ����(main�� ��Ĺ��) -> �˾Ƽ� FirstC ��ü�� �����...
	
	// �� ������Ʈ�� ó�� ������ ��
	public FirstC() {
		super();
		// ó�� �������� �� ��� ������ �� ������ �޾ƿ��� ���ؼ� �������
	}
	
	// ������Ʈ�� ������ ��ȯ : C�� ��û -> M�� ���� �۾� -> V�� ������
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����Ʈ�� ó�� ������ or
		// FirstC�� ��û�Ķ���� �ϳ��� ���� GET������� ��û�ϸ�,
		if (!request.getParameterNames().hasMoreElements()) {
			
			// firstV.jsp�� ���� �Ͼ ��û�� �������ִ� ��ü
			RequestDispatcher rd = request.getRequestDispatcher("firstV.jsp");
			rd.forward(request, response); // firstV.jsp�� ������
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
