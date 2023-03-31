<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- Core 부분 -->
	<h1>${param.n }</h1>
	<hr>
	<!-- 조건문 -->
	<c:if test="${param.n % 2 == 0 }">
		Even Number
	</c:if>
	<c:if test="${param.n % 2 == 1 }">
		Odd Number	
	</c:if>
	<hr>
	
	<!-- if-else + switch-case 느낌 -->
	<c:choose>
		<c:when test="${param.n > 10 }">
			More than 10
		</c:when>
		<c:when test="${param.n > 5 }">
			More than 5
		</c:when>
		<c:otherwise>
			Other
		</c:otherwise>
	</c:choose>
	<hr>
	
	<!-- 반복문 -->
	<%
//		for (int i = 1; i <= 5; i += 2) {
//			System.out.println(i);
//		}
	%>
	
	<c:forEach var="v" begin="1" end="${param.n }" step="2">
		<marquee>${v }</marquee>
	</c:forEach>
	<hr>
	
	<%
//		for (int i : ar) {
//			System.out.println(i);
//		}
	%>
	<c:forEach var="i" items="${ar }">
		<marquee>${i }</marquee>
	</c:forEach>
	<hr>
	<c:forEach var="ddobot" items="${al }">
		${ddobot.name } - ${ddobot.age } <br>
	</c:forEach>
	<hr>
	
	<!-- try-catch -->
	<c:catch var="myExcept">
		<% int result = 100 / 2; %>
		Result : <%=result %>
	</c:catch>
	<br>	
	<c:catch var="myExcept">
		<% int result = 100 / 0; %>
		Result : <%=result %>
	</c:catch>	
	
	<c:if test="${myExcept != null }">
		Error ! : ${myExcept.message }
	</c:if>	
	
	<br>
	
	<c:out value="${param.n } ${myExcept.message }"></c:out>
	
	
	
	
</body>
</html>