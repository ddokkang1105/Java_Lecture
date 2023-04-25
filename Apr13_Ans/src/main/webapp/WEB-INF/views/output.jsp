<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goInput() {
		location.href = "input.go";
	}
</script>
<link rel="stylesheet" href="resources/css/output.css">
<style type="text/css">
	.l {
		color: red;
	}
	
	.d {
		color: green;
	}
	
	.t {
		color: blue;
	}
	
	.v {
		color: pink;
	}
</style>
</head>
<body>
	<h1 class="${param.what }">변 환 결 과</h1>

<%-- 	<c:choose>
		<c:when test="${ur.u1 == 'cm' }">
			<h1 class="cm">변 환 결 과</h1>
		</c:when>
		<c:when test="${ur.u1 == '㎡' }">
			<h1 class="m2">변 환 결 과</h1>
		</c:when>
		<c:when test="${ur.u1 == '℃' }">
			<h1 class="doC">변 환 결 과</h1>
		</c:when>
		<c:when test="${ur.u1 == 'mi/h' }">
			<h1 class="mi">변 환 결 과</h1>
		</c:when>
	</c:choose>
 --%>
<%-- 	<c:if test="${ur.u1 == 'cm' }">
			<h1>변 환 결 과</h1>
	</c:if>
 --%>	
	<c:if test="${s_conv == 1 }">
		<h3 class="cm">${x } cm → ${r } inch</h3>
	</c:if>
	
	<c:if test="${s_conv == 2 }">
		<h3 class="m2">${x } ㎡ → ${r } 평</h3>
	</c:if>
	
	<c:if test="${s_conv == 3 }">
		<h3 class="doC">${x } ℃ → ${r } ℉</h3>
	</c:if>
	
	<c:if test="${s_conv == 4 }">
		<h3 class="mi">${x } mi/h → ${r } km/h</h3>
	</c:if>
	
	${ur.n1 } ${ur.u1 } → ${ur.n2 } ${ur.u2 }
	
	<button onclick="goInput();">뒤로</button>
	
</body>
</html>