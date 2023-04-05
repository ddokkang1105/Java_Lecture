<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<button class="deleteButton" onclick="deleteApple('${apple.a_loc}');">Delete</button>
	<button class="backButton" onclick="back();">Back</button>
	<form action="AppleDetailController" method="post" name="apple" onsubmit="return AppleValid();">
		<table id="detailArea">
			<tr>
				<td align="left" class="td1">Location : </td>
				<td class="td2"><input readonly="readonly" autocomplete="off" name="a_loc" value="${apple.a_loc }"></td>
			</tr>
			<tr>
				<td align="left" class="td1">Color : </td>
				<td class="td2"><input autocomplete="off" name="a_color" value="${apple.a_color }"></td>
			</tr>
			<tr>
				<td align="left" class="td1">taste : </td>
				<td class="td2"><input autocomplete="off" name="a_taste" value="${apple.a_taste }"></td>
			</tr>
			<tr>
				<td align="left" class="td1">Price : </td>
				<td class="td2"><input autocomplete="off" name="a_price" value="${apple.a_price }"></td>
			</tr>
			<tr>
				<td align="left" class="td1">Introduce : </td>
				<td class="td2">
					<textarea autocomplete="off" maxlength="100" name="a_intro">${apple.a_intro }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button class="submitButton">Submit</button></td>
			</tr>
		</table>
	</form>
</body>
</html>