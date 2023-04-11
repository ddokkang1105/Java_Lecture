<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- 	<form action="HomeController" method="post" name="login" onsubmit="return loginValid();"> -->
	<form action="LoginController" method="post" name="login" onsubmit="return loginValid();">
		<table id="loginArea">
			<tr>
				<td colspan="2" align="center" class="loginTd">Login</td>
			</tr>
			<tr>
				<td class="td1">ID</td> 
				<td class="td2"><input maxlength="10" autocomplete="off" placeholder="ID" name="m_id" value="${cookie.lastLoginId.value }"></td> 
			</tr>
			<tr>
				<td class="td1">PW</td> 
				<td class="td2"><input maxlength="10" type="password" autocomplete="off" placeholder="PW" name="m_pw"></td> 
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="loginB">Login</button>
				</td>
			</tr>
		</table>
	</form>
	<button onclick="goSignUp();" class="signUpB">Sign up</button>
</body>
</html>