<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	/* 
		table {
			float: left;
			margin-left; 10px;
		}
	 */

</style>
</head>
<body>
	<%
	
		out.print("<table>");
		out.print("<tr>");
	// for�� ���� ���� Java�����̶� HTML�����̶� ����� �غ��� !!
		for (int row = 2; row <= 9; row++){
			out.print("<td>");
			out.print("<table border='1'>");
			out.print("<tr>");
			out.print("<td align='center'>");
			out.print("<h1>" + row + "��" + "</h1>");
			for (int col = 1; col <= 9; col++) {
				out.print(row + " X " + col + " = " + (row * col));
				out.print("<br>");
			}
			out.print("</td>");
			out.print("</tr>");
			out.print("</table>");
			out.print("</td>");
		}
		out.print("</tr>");
		out.print("</table>");
		
	%>
</body>
</html>