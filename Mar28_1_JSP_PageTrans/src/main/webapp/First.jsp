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
		First.jsp���� �� ���ڸ� �Է����� ��
		Second.jsp���� �� ���ڵ� ����ϱ�
	 --%>
	<a href = "Second.jsp?num1=10&num2=20">&lt;a&gt;�� [GET��� ��û]</a>
	<hr>
	<div onclick="gogo();">JavaScript�� [GET��� ��û]</div>
	<hr>
	<form action="Second.jsp">
		1st Number : <input autofocus="autofocus" autocomplete="off" name="num1"><br>	
		2nd Number : <input autocomplete="off" name="num2"><br>
		<button>Input</button>
	
	</form>
	
	
</body>
</html>