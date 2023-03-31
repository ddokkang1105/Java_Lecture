<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function gogo() {
		location.href = "Second.jsp?num1=100&num2=200";
	}
</script>
</head>
<body>
	<%--
		First.jsp에서 두 숫자를 입력했을 때
		Second.jsp에서 각 숫자들 출력하기
	 --%>
	<a href = "Second.jsp?num1=10&num2=20">&lt;a&gt;로 [GET방식 요청]</a>
	<hr>
	<div onclick="gogo();">JavaScript로 [GET방식 요청]</div>
	<hr>
	<form action="Second.jsp">
		1st Number : <input autofocus="autofocus" autocomplete="off" name="num1"><br>	
		2nd Number : <input autocomplete="off" name="num2"><br>
		<button>Input</button>
	
	</form>
	
	
</body>
</html>