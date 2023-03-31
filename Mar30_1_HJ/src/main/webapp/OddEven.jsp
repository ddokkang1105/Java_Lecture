<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>OE GAME</title>
<link rel="stylesheet" href="css/OddEven.css">
</head>
<body>
	<table id="mainTbl">
		<tr>
			<td>
				<table id="mainArea">
					<tr><td colspan="2" align="center" class="titleTd">ODD / EVEN</td></tr>
					<tr><td colspan="2" align="center" class="subTitleTd">1 To 100</td></tr>
					<tr>
						<td align="center"><a href="HomeController?g=1"><img src="img/1.png"></a></td>
						<td align="center"><a href="HomeController?g=0"><img src="img/0.png"></a></td>
					</tr>
					<tr><td colspan="2" align="center" class=comAnsTd>${oeNum } ${oeStr} </td></tr>
					<tr><td colspan="2" align="center" class=myAnsTd>${ans }</td></tr>
					<tr><td colspan="2" align="center" class=resultTd>${result }</td></tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>