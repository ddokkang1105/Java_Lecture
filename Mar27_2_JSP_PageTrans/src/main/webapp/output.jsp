<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function getRandomColor() {
		// Math.random()					-> 0.0 ~ 0.99999
		// Math.random() * 255				-> 0.0 ~ 254.99999
		// Math.round(Math.random() * 255)	-> 0 ~ 255
		
		let r = Math.round(Math.random() * 255);
		let g = Math.round(Math.random() * 255);
		let b = Math.round(Math.random() * 255);
		
		return "rgb(" + r + ", " + g + ", " + b +")";
		
	}
	
	function init() {
		// alert(getRandomColor());
		let cv = document.getElementById("cv");
		let pen = cv.getContext("2d");
		let x = null;
		let y = null;
		
		setInterval(() => {
			pen.save();
			pen.fillStyle = "rgba(0, 0, 0, 0.2)";
			pen.fillRect(0, 0, 500, 500);
			
			pen.shadowOffsetX = 0;
			pen.shadowOffsetY = 0;
			pen.shadowBlur = 5;
			pen.shadowColor = "white";
			
			x = Math.random() * 500;
			y = Math.random() * 500;
			pen.fillStyle = getRandomColor();
			pen.fillRect(x, y, 20, 20);
			
			pen.restore();
			
		}, 200);
	}
	
</script>
</head>
<body onload="init();">
	<canvas id="cv" width="500px" height="500px"></canvas>
	<hr>

	<%
		// response.sendRedirect("test.jsp");
		request.setCharacterEncoding("EUC-KR");
	
		String outPut = request.getParameter("string");
		
		StringTokenizer st = new StringTokenizer(outPut, ",");
		int resultNum1 = 0;
		while (st.hasMoreTokens()) {
			try {
				resultNum1 += Integer.parseInt(st.nextToken());
				
			} catch (Exception e) {
			}
		}
		
		String[] sData = outPut.split(",");
		int resultNum2 = 0;
		
		for (String s : sData) {
			try {
				resultNum2 += Integer.parseInt(s);				
			} catch (Exception e) {
			}
		}
	%>
	
	
	Result : <%=outPut %><br>
	StringTokenizer Result : <%=resultNum1 %><br>
	Split Result : <%=resultNum2 %><br>
</body>
</html>