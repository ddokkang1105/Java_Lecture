<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="Calculator" name="cal" onsubmit="return getNumber();">
		<table>
			<tr>
				<td>
					<table>
						<tr><th align="center">Calculator</th></tr>
						<tr><td align="center">X : <input autocomplete="off" autofocus="autofocus" name="x"></td></tr>
						<tr><td align="center">Y : <input autocomplete="off" name="y"></td></tr>
						<tr><td align="center"><button>Submit</button></td></tr>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<td><jsp:include page="${calResult }"></jsp:include></td>
						</tr>
					</table>				
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>