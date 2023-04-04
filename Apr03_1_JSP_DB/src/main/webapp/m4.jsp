<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="en"/>
	<table>
		<tr>
			<td>
				<table>
					<tr>
						<th>지역</th>
						<th>가격</th>
					</tr>
					<c:forEach var="apple" items="${apples }">
						<tr>
							<td>${apple.a_loc }</td>
							<td>
								￦<fmt:formatNumber value="${appple.a_price }" pattern="#" />
							</td>
						</tr>											
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>