<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<table id="registArea">
			<tr>
				<td align="right">${r } Regist Apple</td>
				<td align="center"><a href="RegistController">Click</a></td>
			</tr>
		</table>
		<table id="contentApple">
			<tr>
				<th>����</th>
				<th>����</th>
			</tr>
			<c:forEach var="apple" items="${apples }">
				<!-- onclick �� �� �����غ��� -->
				<tr onclick="">
					<td align="center">${apple.a_loc }</td>
					<td align="center">
					<fmt:formatNumber value="${apple.a_price }" type="currency"></fmt:formatNumber>
					</td>
				</tr>											
			</c:forEach>
		</table>
		<table id="pageArea">
			<tr>
				<td align="center">
				<!-- for�� ����ؼ� ������ ��ȣ ����� -->
				</td>
			</tr>
		</table>
</body>
</html>