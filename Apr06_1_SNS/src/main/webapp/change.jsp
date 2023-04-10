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
	<button onclick="drop(${sessionScope.loginMember.m_id });">Drop</button>
	<form action="ChangeController" method="post" enctype="multipart/form-data" name="mem" onsubmit="return changeValid();">
		<table id="signUpArea">
			<tr>
				<td colspan="2" align="center" id="titleTd">Change</td>
			</tr>
			<tr>
				<td class="td1">ID</td>
				<td class="inputTd"><input readonly="readonly" name="m_id" value="${sessionScope.loginMember.m_id }"></td>
			</tr>
			<tr>
				<td class="td1">PW</td>
				<td class="inputTd"><input autofocus="autofocus" maxlength="10" type="password" autocomplete="off" 
				placeholder="PW / 3 - 10 Letters" name="m_pw"></td>
			</tr>
			<tr>
				<td class="td1">PW Check</td>
				<td class="inputTd"><input maxlength="10" type="password" autocomplete="off" 
				placeholder="Input The Same PW" name="m_pwck"></td>
			</tr>
			<tr>
				<td class="td1">Name</td>
				<td class="inputTd"><input maxlength="10" autocomplete="off" placeholder="Name / 3 - 10 Letters" 
				name="m_name" value="${sessionScope.loginMember.m_name }"></td>
			</tr>
			<tr>
				<td class="td1">Phone</td>
				<td class="inputTd"><input maxlength="11" autocomplete="off" placeholder="Phone / 10 - 11 Letters" 
				name="m_phone" value="${sessionScope.loginMember.m_phone }"></td>
			</tr>
			<tr>
				<td class="td1">BirthDay</td>
				<td id="selectTd">
					<select name="m_y">
					<option>
						<fmt:formatDate value="${sessionScope.loginMember.m_birthday }" pattern="yyyy" />
					</option>
 						<c:forEach var="y" begin="${cy-100 }" end="${cy }">
							<option  value="${y }">${y }</option>
						</c:forEach>
					</select>년
					<select name="m_m">
					<option>
						<fmt:formatDate value="${sessionScope.loginMember.m_birthday }" pattern="M" />
					</option>
  						<c:forEach var="m" begin="1" end="12">	
							<option value="${m }">${m }</option>
						</c:forEach>
					</select>월
					<select name="m_d">
					<option>
						<fmt:formatDate value="${sessionScope.loginMember.m_birthday }" pattern="d" />
					</option>
  						<c:forEach var="d" begin="1" end="31">
							<option value="${d }">${d }</option>
						</c:forEach>
					</select>일
				</td>
			</tr>
			<tr>
				<td class="td1">Photo</td>
				<td id="photoTd"><input type="file" name="m_photo"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" id="photoTd"><img src="img/${sessionScope.loginMember.m_photo }"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" id="submitB"><button>Change</button></td>
			</tr>
		</table>
	
	</form>
	
</body>
</html>