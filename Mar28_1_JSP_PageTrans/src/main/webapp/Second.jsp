<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<%
		// �� 
		//		parameter
		//			html���� ���� ��(num1, num2)
		//			request�� ���� 
		//			String or String[]
				
		//		attribute
		//			Java���� ���� ��(c, d, e)
		//			request�� ����
		//			Object (��ü)
		
		// �̵�
		//		first -> second : ����ڰ� ���� �׼��� �ؼ� �Ѿ��
		//		- request (��û)
		
		//		second -> third : �׳� �Ѿ
		//			- redirect : �ܼ� �ڵ��̵� (������)
		//			response.sendRedirect("Third.jsp")
		//			- forward : �ڵ��̵�(���� ���޵Ǵ�)
		//			RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
		// 			rd.forward(request, response);
		
		//			- include : ����(Second�ӿ� Third�� ���ԵǴ�)
		//				��ġ������ �ȵ�(Third�� ������ ��ܿ� ����) - ���� !
		//				������ ! ��ġ������ �Ǵ� include�� ������ ���� ~
		//			RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
		//			rd.include(request, response);
	%>
	
	<%
		request.setCharacterEncoding("EUC-KR");
	
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		// RequestDispatcher : Ŭ���̾�Ʈ�κ��� ���� ��û�� ���ϴ� ������ �ѱ�� ���
		// ȣ��� ������������ request.setAttribute(key, value) �޼ҵ带 ���ؼ�
		// �Ѱܹ��� �����͸� ó���� �� ����
		//		=> Redirect�ʹ� �ٸ��� (������ó���� ���ϴ� Redirect)
		//			request�� response ��ü�� ������ �Ѿ�� ������
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
		int c = num1 + num2;
		request.setAttribute("c", c);
		
		String d = "��";
		request.setAttribute("d", d);
		
		Random e = new Random();
		request.setAttribute("e", e);
		
		// rd.forward(request, response);
		rd.include(request, response);
		
	%>
	<h1>Second</h1>
	1st Number : <%=num1 %><br>
	2nd Number : <%=num2 %><hr>
</body>
</html>