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
	<%--
		������ ����(1 ~ 100)�� �־��� ��, ¦���� Ȧ���� �˷��ִ� ���
		���� ���ڿ� Ȧ¦ ���θ� ���������� ���
	 --%>
	 <%
	 Random r = new Random();
	 
	 int num1 = r.nextInt(100) + 1;
	 int num2 = r.nextInt(100) + 1;
	 %>
	 
	 <%-- return (num % 2 == 0) ? "¦��" : "Ȧ��"; --%>
	 <%!
	 public static String calOddEven(int num) {
		 if (num % 2 == 0) {
			 return "Even";
		 } else {
			 return "Odd";
		 }
	 }
	 %>
	 
	 <h1>1st Number : <%=num1 %><br></h1>
	 <h1>2nd Number : <%=num2 %><br></h1>
	 <hr>
	 <h1>1st Number : <%=calOddEven(num1) %></h1>
	 <h1>2nd Number : <%=calOddEven(num2) %></h1>
	 <hr>
</body>
</html>

















