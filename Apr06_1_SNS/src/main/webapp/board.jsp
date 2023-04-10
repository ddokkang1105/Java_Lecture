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
	<c:if test="${sessionScope.loginMember != null }">
		<form action="BoardWriteController">
			<table>
				<tr>
					<td>
						<input name="token" value="${generatedToken }" type="hidden">
						<textarea placeholder="Write !" name="b_text" autocomplete="off" autofocus="autofocus" maxlength="200"></textarea>
					</td>		
					<td><button>Submit</button></td>		
				</tr>
			</table>
		</form>
	</c:if>
	<form action="">
		<table>
			<tr>
				<td align="center">
					<input autocomplete="off" autofocus="autofocus" placeholder="2-10 Letters" maxlength="10" name="b_search">
				</td>
				<td align="center">
					<button>Search</button>
				</td>
			</tr>
		</table>	
	</form>
	<table>
		<c:forEach var="board" items="${board }">
			<tr>
				<td align="center">
					${board.b_no }
					${board.b_writer }
					${board.b_when }
					${board.b_text }
					<!-- 내용(버튼은 onclick으로, 기본은 1페이지, 파라미터로 넘기기) -->
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td><button onclick="left();"><</button></td>
			<td><button onclick="right('${EndPage }');">></button></td>
		</tr>
	</table>
</body>
</html>