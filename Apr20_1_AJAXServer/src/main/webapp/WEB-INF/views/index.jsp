<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url: "error.getXML",
				success: function(asd) {
					$(asd).find("error").each(function(i, e) {
						let e_what = $(e).find("e_what").text();
						let e_where = $(e).find("e_where").text();
						// let e_print = e_what + e_where;
						// $("body").append(e_print);
						// alert(e_what + " - " + e_where);
					})
				}
		});
		
		
	});
	

</script>
</head>
<body>
	<!-- 
		MyBatis 활용
		전체 에러데이터를 e_where 오름차순 정렬해서
		e_what - e_where 형태로 출력
	 -->
	 <c:forEach var="e" items="${errors }">
	 	${e.e_what } - ${e.e_where } <p>
	 </c:forEach>
	 
</body>
</html>