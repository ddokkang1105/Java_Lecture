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
				<th>지역</th>
				<th>가격</th>
			</tr>
			<c:forEach var="apple" items="${apples }">
				<!-- onclick 들어갈 거 생각해보기 -->
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
				<!-- for문 사용해서 페이지 번호 만들기 -->
				</td>
			</tr>
		</table>
</body>
</html>