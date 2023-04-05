<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Third</h1>
	<hr>
	a : ${param.a } <br>
	b : ${param.b } <br>
	c : ${cc } <br>
	d : ${sessionScope.d } <br>
	<hr>
	<jsp:include page="${baby }" />
	<%
		// 실행했을 때 무한루프... : include가 잘못됐을 때
		//							or 없는 페이지를 include 했을 때
	%>
</body>
</html>