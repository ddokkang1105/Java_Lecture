<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="RegistController" method="post" name="apple" onsubmit="return appleValid();">
		<table id="appleArea">
			<tr>
				<td align="left" class="td1">Location : </td>
				<td><input autofocus="autofocus" autocomplete="off" 
				placeholder="Location & No Symbol" name="a_loc"></td>
			</tr>
			<tr>
				<td align="left" class="td1">Color : </td>
				<td class="td2">
					<select name="a_color">
						<option value="RED"> Red
						<option value="YELLOW"> Yellow
						<option value="GREEN"> Green
						<option value="WHITE"> White
						<option value="BLACK"> Black
					</select>
				</td>
			</tr>
			<tr>
				<td align="left" class="td1">taste : </td>
				<td class="td2">
					<select name="a_taste">
						<option value="SWEET"> Sweet
						<option value="SOUR"> Sour
						<option value="SAlTY"> Salty
						<option value="SAVORY"> Savory
						<option value="NO"> No
					</select>					
				</td>
			</tr>
			<tr>
				<td align="left" class="td1">Price : </td>
				<td class="td2"><input autocomplete="off" placeholder="Price" name="a_price"></td>
			</tr>
			<tr>
				<td align="left" class="td1">Introduce : </td>
				<td class="td2">
					<textarea placeholder="More than 4 Letters & Less than 100 Letters" 
					maxlength="100" name="a_intro"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button>Submit</button></td>
			</tr>
		</table>
	</form>
</body>
</html>