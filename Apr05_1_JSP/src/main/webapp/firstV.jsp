<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- <%@ taglib prefix="c" uri="" %>
<%@ taglib prefix="fmt" uri="" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function gogogo() {
		location.href = "SecondC?a=20&b=200";
	}

</script>
</head>
<body>
	<%
		// ����ڰ� ��� �׼��� ���� �� �̵� : ��û
		//		- <a> �±׸� �Ἥ : Ŭ���ϸ� GET 
		//		- JS�� �Ἥ : �̺�Ʈ�� �߰����� �� GET���
		//			(JS�� HTML����°� ���� -> JS�� <form>�� Ȱ���� POST��ĵ� ����)
		//		- <form> + <button> : ��ư�� Ŭ������ �� GET / POST ���
	%>
	<h1>First</h1>
	d : ${sessionScope.d } <br>
	e : ${cookie.e.value } <br>
	<a href="SecondC?a=10&b=100">SecondC��</a>
	<hr>
	<div onclick="gogogo();">SecondC��</div>
	<hr>
	<form action="SecondC">
		<input name="a"> <br>
		<input name="b"> <br>
		<button>SecondC��</button>
	</form>
	
</body>
</html>