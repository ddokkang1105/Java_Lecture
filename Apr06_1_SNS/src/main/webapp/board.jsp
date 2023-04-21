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
				<td colspan="2" align="center">
					${board.b_no }
					${board.b_writer }
					${board.b_when }
					${board.b_text }
					<img src="img/${board.m_photo }"> 
					<!-- 내용(버튼은 onclick으로, 기본은 1페이지, 파라미터로 넘기기) -->
				</td>
			</tr>
			<c:if test="${sessionScope.loginMember.m_id == board.b_writer }">
				<tr>
						<td align="right"><button onclick="edit(${board.b_no }, '${board.b_text }');">Edit</button></td>
						<td align="right"><button onclick="deleteB(${board.b_no })">Delete</button></td>
				</tr>
			</c:if>
		</c:forEach>
		<!-- 검색할 때 나오는 창 -->
<%-- 		<c:forEach var="s_b" items="${s_board }">
			<tr>
				<td align="center">
					${s_b.b_no }
					${s_b.b_writer }
					${s_b.b_when }
					${s_b.b_text }
					<img src="img/${s_b.m_photo }"> 
					<!-- 내용(버튼은 onclick으로, 기본은 1페이지, 파라미터로 넘기기) -->
				</td>
			</tr>
		</c:forEach> --%>
		<tr>
			<td align="left"><button onclick="left(${pageNo }, ${startPage });">&lt;</button></td>
			<td align="right"><button onclick="right(${pageNo }, ${endPage });">&gt;</button></td>
		</tr>
	</table>
</body>
</html>