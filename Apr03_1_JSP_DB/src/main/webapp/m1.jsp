<%@page import="com.ddokkang.apr031.dto.AppleDAO"%>
<%@page import="com.ddokkang.db.manager.DdokkangDBManager"%>
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
				<tr onclick="goAppleDetail('${apple.a_loc}');">
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
					<c:forEach var="p" begin="1" end="${pageCount }">
						<a href="ApplePageController?p=${p }">${p }</a>					
					</c:forEach>
				</td>
			</tr>
		</table>
</body>
</html>