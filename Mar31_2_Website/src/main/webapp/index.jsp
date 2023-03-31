<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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
						<!-- 눌렀을 때 이동이 아닌 화면만 보여주게끔 -->
							<!-- <a href="Controller?m=0">Home</a> -->
							<a href="Controller">Home</a>
						</td>
						<td class="menu">
							<!-- <a href="Controller?m=1">Home</a> -->
							<a href="AController">Menu1</a>
						</td>
						<td class="menu">
							<a href="">Menu2</a>
						</td>
						<td class="menu">
							<a href="">Menu3</a>
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