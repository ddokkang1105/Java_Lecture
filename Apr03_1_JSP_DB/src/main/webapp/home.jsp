<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="js/DdokkangValidChecker.js"></script>
<script type="text/javascript" src="js/AppleValid.js"></script>
<script type="text/javascript" src="js/detail.js"></script>
<link rel="stylesheet" href="css/home.css">
<link rel="stylesheet" href="css/apple.css">
<link rel="stylesheet" href="css/regist.css">
<link rel="stylesheet" href="css/detail.css">
</head>
<body>
	<table id="mainArea">
		<tr>
			<td align="center">
				<table>
					<tr><th align="center"><a href="HomeController">Fruit Party</a></th></tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center" id="contentArea"><jsp:include page="${content }"></jsp:include></td>
		</tr>
		<tr>
			<td>
				<table id="menuArea">
					<tr>
						<td><a href="M1Controller"><img src="img/m1.png"></a></td>
						<td><a href=""><img src="img/m2.png"></a></td>
						<td><a href=""><img src="img/m3.png"></a></td>
						<td><a href="DBCController"><img src="img/m4.png"></a></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>