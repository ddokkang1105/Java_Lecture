<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="welcomeArea">
		<tr>
			<td colspan="2" align="right">${sessionScope.loginMember.m_name } Sir, WelCome ! ${r }</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><img src="img/${sessionScope.loginMember.m_photo }"> </td>
		</tr>
		<tr>
			<td align="center"><button onclick="goChange();">Info</button></td>
			<td align="center"><button onclick="logout();">LogOut</button></td>
		</tr>
	</table>

	
</body>
</html>