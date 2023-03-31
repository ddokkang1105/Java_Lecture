<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="js/DdokkangValidChecker.js"></script>
<script type="text/javascript" src="js/calValid.js"></script>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<table id="mainTbl">
		<tr>
			<td align="center">
				<table id="titleTbl">
					<tr><th>2023-03-31</th></tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<table id="menuTbl">
					<tr>
						<td class="menu">
							<a href="Controller">Home</a>
						</td>
						<td class="menu">
							<a href="Calculator">'+ - * %' Calculate</a>
						</td>
						<td class="menu">
							<a href="JSTLCController">JSTL-Core</a>
						</td>
						<td class="menu">
							<a href="JSTLFController">JSTL-Formmating</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<jsp:include page="${content }"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>