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
		랜덤한 숫자(1 ~ 100)를 넣었을 때, 짝인지 홀인지 알려주는 기능
		뽑은 숫자와 홀짝 여부를 웹페이지에 출력
	 --%>
	 <%
	 Random r = new Random();
	 
	 int num1 = r.nextInt(100) + 1;
	 int num2 = r.nextInt(100) + 1;
	 %>
	 
	 <%-- return (num % 2 == 0) ? "짝수" : "홀수"; --%>
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

















