<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td align="center">
				${param.x } ${s } ${param.y } ${equal } ${sum }
			</td>
		</tr>
		<tr>
			<td align="center">
				${param.x } ${mi } ${param.y } ${equal } ${minus }
			</td>
		</tr>
		<tr>
			<td align="center">
				${param.x } ${mu } ${param.y } ${equal } ${mul }
			</td>
		</tr>
		<tr>
			<td align="center">
				${param.x } ${di } ${param.y } ${equal } ${divide }
			</td>
		</tr>
	</table>
</body>
</html>