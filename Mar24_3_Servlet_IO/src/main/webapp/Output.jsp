<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/output.css">
</head>
<body>
	<%
		request.setCharacterEncoding("EUC-KR");
		
		String path = request.getServletContext().getRealPath("img");
		System.out.println(path);
		
		MultipartRequest mr = new MultipartRequest(request, path,
				10 * 1024 * 1024, "EUC-KR", new DefaultFileRenamePolicy());
		
		String name = mr.getParameter("name");
		double height = Double.parseDouble(mr.getParameter("height"));
		double weight = Double.parseDouble(mr.getParameter("weight"));
		double bmi = weight / ((height / 100) * (height / 100));
		String bmiResult = null;
		
		// BMI 수치 => 소수점 둘째자리까지만 (*** 아래에서는 안되니까 여기서 해결 !!)
		String bmi2 = String.format("%.2f", bmi);
		
		if (bmi >= 40) {
			bmiResult = "Severe obesity";
		} else if (bmi >= 30) {
			bmiResult = "Moderate obesity";
		} else if (bmi >= 25) {
			bmiResult = "Mild obesity";
		} else if (bmi >= 23) {
			bmiResult = "Overweight";
		} else if (bmi >= 18.5) {
			bmiResult = "Normal weight";
		} else {
			bmiResult = "Underweight";
		}
		
		String fileName = mr.getFilesystemName("image");
		
		fileName = URLEncoder.encode(fileName, "EUC-KR");
		fileName = fileName.replace("+", " ");
	%>


	<table id="BmiTbl">
		<tr>
			<td align="center" colspan="2" class="title">Bmi Result</td>
		</tr>
		<tr>
			<td align="center" class="td1">Name</td>					
			<td class="td2"><%=name %></td>					
		</tr>
		<tr>
			<td align="center" class="td1">Height</td>					
			<td class="td2"><%=height %>CM</td>					
		</tr>
		<tr>
			<td align="center" class="td1">Weight</td>					
			<td class="td2"><%=weight %>KG</td>					
		</tr>
		<tr>
			<td align="center" class="td1">Bmi Result</td>					
			<td class="td2"><%=bmi2 %></td>					
		</tr>
		<tr>
			<td align="center" class="td1">Bmi Caution</td>					
			<td class="td2"><%=bmiResult %></td>					
		</tr>
		<tr>
			<td align="center" colspan="2"><img src=img/<%=fileName %>></td>					
		</tr>
	</table>
 	
</body>
</html>