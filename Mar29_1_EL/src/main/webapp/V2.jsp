<%@page import="java.util.ArrayList"%>
<%@page import="com.ddokkang.mar291.main.Ddokkang"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// EL (Expression Language)
		//		���� ���� �� Java��� ��� ����
		//		.jsp������ ��밡�� (.jsp�� ��Ĺ�� Servlet���� �ٲ� �� EL�� Java�ڵ�� �ٲ���)
		
		//		���� : ${XXX }
		//			������ ��� ����
		//			�� ��ȯ �ڵ�
		//			���� ������ �׳� �Ѿ
		//			impirt�� ��� ��
		
		//		�Ķ���Ͱ� �б� : ${param.�Ķ���͸� } (param -> �Ķ����)
		
		//		��Ʈ����Ʈ�� �б� (int, double, String, ... ����) - �⺻ �ڷ���
		//			: ${��Ʈ����Ʈ�� }
		
		//		��Ʈ����Ʈ�� �б�(��ü)
		//			�ּҰ� - ${��Ʈ����Ʈ�� }
		//			�Ӽ��� - ${��Ʈ����Ʈ��.��������� }
		
		//		��Ʈ����Ʈ�� �б�(List, [])
		//			AL / [] ��ü			- ${��Ʈ����Ʈ�� }
		//			�ε��� ��ġ�� ��ü		- ${��Ʈ����Ʈ��[�ε���] }
		//			�ε��� ��ġ�� ��ü �Ӽ� - ${��Ʈ����Ʈ��[�ε���].��������� }
		
		//			�ݺ���, ���ǹ� - EL (X) / CustomTag (O)
	%>

	<%
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		int z = (Integer) request.getAttribute("z");
		
		Ddokkang d = (Ddokkang) request.getAttribute("d");
		
		ArrayList<Ddokkang> dvs = (ArrayList<Ddokkang>) request.getAttribute("dvs");
	%>
	<%=x %> X <%=y %> = <%=z %> <br>
	<%=d.getName() %> : <%=d.getAge() %> : <%=d.getHeight() %> : <%=d.getWeight() %> <br>
	
	<%=dvs%> <p>
	<%=dvs.get(1) %> <p>
	<%=dvs.get(2).getName() %>, <%=dvs.get(3).getAge() %> <p>
	
	<!-- ArrayList�� ��ü���� �̸��� ���� �� ����ϱ� -->
	<%=dvs.get(0).getName() %>, <%=dvs.get(0).getAge() %><p>	
	<%=dvs.get(1).getName() %>, <%=dvs.get(1).getAge() %><p>	
	<%=dvs.get(2).getName() %>, <%=dvs.get(2).getAge() %><p>	
	<%=dvs.get(3).getName() %>, <%=dvs.get(3).getAge() %><p>	
	<hr>
	
	<%
		for (Ddokkang dd : dvs) {
	%>
		<%=dd.getName() %>, <%=dd.getAge() %><br>
	<%
		}
	%>
	<hr>
	
	${param.x } <br>
	${param.y } <br>
	${param.x * param.y } <br> <!-- ���� ���� ! -->
	${z } <br>
	<hr>
	${d.name } : ${d.age } : ${d.height } : ${d.weight } <br>
	<hr>
	Nope : ${param.dasdsadjqkwejqlkdasd } <!-- ���� ���� �� -->
	<hr>
	${dvs } <br>
	${dvs[1] } <br>
	${dvs[2].name }, ${dvs[3].age } <br>
	
	
	
</body>
</html>