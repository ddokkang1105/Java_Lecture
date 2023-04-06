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
			<td align="right">${sessionScope.loginMember.m_name } Sir, WelCome !</td>
		</tr>
		<tr>
			<td align="center"><img src="img/${sessionScope.loginMember.m_photo }"> </td>
		</tr>
		<tr>
			<td align="right"><button onclick="logout();">LogOut</button></td>
		</tr>
	</table>

	
</body>
</html>