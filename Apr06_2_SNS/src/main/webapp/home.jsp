<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="js/DdokkangValidChecker.js"></script>
<script type="text/javascript" src="js/home.js"></script>
<script type="text/javascript" src="js/signUp.js"></script>
<script type="text/javascript" src="js/change.js"></script>
<script type="text/javascript" src="js/board.js"></script>
<link rel="stylesheet" href="css/home.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/signUp.css">
<link rel="stylesheet" href="css/welcome.css">
</head>
<body>
	<table id="mainArea">
		<tr>
			<td align="center">
				<table id="titleArea">
					<tr><td align="center">Title</td></tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<table id="boardArea">
					<tr><td align="center"><a href="BoardController">Board</a></td></tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="right">
				<jsp:include page="${lp }" />
			</td>
		</tr>
		<tr>
			<td align="center" >
				<table id="contentArea">
					<tr>
						<td align="center" class="contentTd">
							<jsp:include page="${content }"></jsp:include>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		
	</table>
</body>
</html>