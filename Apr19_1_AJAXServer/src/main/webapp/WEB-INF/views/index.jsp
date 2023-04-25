<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/index.css">
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	$(function() {
		
		$("h1").click(function() {
			// let td = $("<td></td>").html("")
		});
		
	});
	
</script>
</head>
<body>
	<!-- 
		MyBatis 활용
		전체 과일데이터를 가격순으로
		이름 - 가격 형태로 출력
		(ex 귤 - ￦2,800)
	 -->
	 <h1>전체 과일(가격순으로)</h1>
<!-- 	 <table border="1">
	 	<tr>
			<td>이름<td>	 	
			<td>가격<td>	 	
	 	</tr>
	 </table>

	 <hr>
 -->
	 <c:forEach var="f" items="${fruits }">
	 	${f.f_name } - 
	 	<fmt:formatNumber value="${f.f_price }" type="currency" /> <p>
	 </c:forEach>
</body>
</html>