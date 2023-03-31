<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="DdokkangValidChecker.js"></script>
<script type="text/javascript" src="nb.js"></script>
<link rel="stylesheet" href="css/nb.css">
</head>
<body>
	<form action="HomeController">
		<table>
			<tr>
				<td>
					<table>
						<tr><td>NUMBER BASEBALL</td></tr>
						<tr><td>PLAYBALL : <input autocomplete="off" autofocus="autofocus" name="input"></td></tr>
						<tr><td><button >Submit</button></td></tr>
						<tr><td>${t }</td></tr>
						<tr><td>${ans }</td></tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>