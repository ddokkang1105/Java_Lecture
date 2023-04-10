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
	<form action="BoardSearchController">
		<table>
			<tr>
				<td align="center">
					<input autocomplete="off" autofocus="autofocus" placeholder="2-10 Letters" maxlength="10" name="s_board">
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
					사진추가하기
					<!-- 내용(버튼은 onclick으로, 기본은 1페이지, 파라미터로 넘기기) -->
				</td>
			</tr>
			<tr>
				<td align="right">작성자 수정, 삭제 넣기</td>
			</tr>
		</c:forEach>
		<c:forEach var="s_b" items="${s_board }">
			<td align="center">
				${s_b.b_no }
				${s_b.b_writer }
				${s_b.b_when }
				${s_b.b_text }
				사진추가하기
				<!-- 내용(버튼은 onclick으로, 기본은 1페이지, 파라미터로 넘기기) -->
			</td>
		</c:forEach>
		<tr>
			<td><button onclick="left(${page }, ${startPage });"><</button></td>
			<td><button onclick="right(${page }, ${endPage });">></button></td>
		</tr>
	</table>
</body>
</html>