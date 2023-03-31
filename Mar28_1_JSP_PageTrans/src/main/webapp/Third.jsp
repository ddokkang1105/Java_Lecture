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
		// Parameter 읽기
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));

		// Attribute 읽기
		Object ccc = request.getAttribute("c");		// Object
		Integer cc = (Integer) ccc;					// Object -> Integer
		int c = cc.intValue();						// Integer -> int
		
		String d = (String) request.getAttribute("d");
		Random e = (Random) request.getAttribute("e");
	%>
	<h1>Third</h1>
	num1 : <%=num1 %><br>
	num2 : <%=num2 %><br>
	c : <%=c %><br>
	d : <%=d %><br>
	e : <%=e.nextInt(100) + 1 %><br>
</body>
</html>