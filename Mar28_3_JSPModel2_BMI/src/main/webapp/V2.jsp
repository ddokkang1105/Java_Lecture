<%@page import="com.ddokkang.mar283.main.Patient"%>
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
</head>
<body>
<%-- 	<%
		response.setCharacterEncoding("EUC-KR");
		request.setCharacterEncoding("EUC-KR");
	
		String path = request.getServletContext().getRealPath("img");
		System.out.println(path);
		
		MultipartRequest mr = new MultipartRequest(request, path,
				10 * 1024 * 1024, "EUC-KR", new DefaultFileRenamePolicy());
		
		String name = mr.getParameter("name");
		int age = Integer.parseInt(mr.getParameter("age"));
		int height = Integer.parseInt(mr.getParameter("height"));
		int weight = Integer.parseInt(mr.getParameter("weight"));
		double bmi = (Double) request.getAttribute("bmi");
		String bmiResult = (String) request.getAttribute("bmiResult");	
	
		String fileName = mr.getFilesystemName("image"); 
		
		fileName = URLEncoder.encode(fileName, "EUC-KR");
		fileName = fileName.replace("+", " ");
		
		
		String bmiToString = String.format("%.2f", bmi);
	%>
	<h1><%=name%>`s BMI Result</h1>
	Height : <%=height %><br>
	Weight : <%=weight %><br>
	BMI : <%=bmiToString %><br>
	BMIResult : <%=bmiResult %><br>
	<!-- BMI : <%=bmiToString %><br> -->
	<img src=img/<%=fileName %>> --%>
	
	<%
		request.setCharacterEncoding("EUC-KR");
		Patient p = (Patient) request.getAttribute("p");
	%>
	
		<table id="BmiTbl">
		<tr>
			<td align="center" colspan="2" class="title">Bmi Result</td>
		</tr>
		<tr>
			<td align="center" class="td1">Name</td>					
			<td class="td2"><%=p.getName() %></td>					
<%--  			<td class="td2">${g.name }</td> --%>					
		</tr>
		<tr>
			<td align="center" class="td1">Height</td>					
			<td class="td2"><%=p.getHeight() %>CM</td>					
		</tr>
		<tr>
			<td align="center" class="td1">Weight</td>					
			<td class="td2"><%=p.getWeight() %>KG</td>					
		</tr>
		<tr>
			<td align="center" class="td1">Bmi Result</td>					
			<td class="td2"><%=p.getBmi() %></td>					
		</tr>
		<tr>
			<td align="center" class="td1">Bmi Caution</td>					
			<td class="td2"><%=p.getBmiResult() %></td>					
		</tr>
		<tr>
			<td align="center" colspan="2"><img src=img/<%=p.getImage() %>></td>					
		</tr>
	</table>
	
</body>
</html>