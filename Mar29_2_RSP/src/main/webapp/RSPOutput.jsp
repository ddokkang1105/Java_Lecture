<%@page import="com.ddokkang.mar292.main.RSPEngine"%>
<%@page import="com.ddokkang.mar292.main.RSPResult"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// 수정하기
		String myRSP = (String) request.getAttribute("myRSP");
		String comRSP = (String) request.getAttribute("comRSP");
		
		RSPEngine rspe = (RSPEngine) request.getAttribute("rspe");
		String result = (String) request.getAttribute("result");
	%>

	<form action="HomeController">
		<table>
			<tr>
				<td>
					<table>
						<tr><td colspan="3"><h1>RSP GAME</h1></td></tr>
						<tr>
							<td><button name="r" value="0">R</button></td>
							<td><button name="s" value="1">S</button></td>
							<td><button name="p" value="2">P</button></td>
						</tr>
						<tr><td colspan="3">MY RSP : ${myRSP } </td></tr>
						<tr><td colspan="3">COM RSP : ${comRSP } </td></tr>
						<tr><td colspan="3">Result : ${result }</td></tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>