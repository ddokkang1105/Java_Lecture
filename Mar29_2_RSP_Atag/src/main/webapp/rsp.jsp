<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/rsp.css">
</head>
<body>
	<%
/* 		String myRSP = (String) request.getAttribute("myRSP");
		String comRSP = (String) request.getAttribute("comRSP");
 */		
/* 		RSPEngine rspe = (RSPEngine) request.getAttribute("rspe");
		String result = (String) request.getAttribute("result");
 */	%>

	<table id="RSPTbl">
		<tr>
			<td id="RSPTblArea">
				<table>
					<tr><td align="center" colspan="3" id="tr1">RSP GAME</td></tr>
					<tr>
						<td><a href="HomeController?r=0"><img src="img/0.png"></a></td>
						<td><a href="HomeController?s=1"><img src="img/1.png"></a></td>
						<td><a href="HomeController?p=2"><img src="img/2.png"></a></td>
					</tr>
					<tr><td align="center" colspan="3" class="resultTitle">Result</td></tr>
					<tr><td align="center" colspan="3" class="rspTd">${myRSP }</td></tr>
					<tr><td align="center" colspan="3" class="rspTd">${comRSP } </td></tr>
					<tr><td align="center" colspan="3" class="resultTd">${result }</td></tr>
				</table>
			</td>
		</tr>
	</table>


</body>
</html>