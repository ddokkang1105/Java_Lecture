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
		//		값을 받을 때 Java대신 사용 가능
		//		.jsp에서만 사용가능 (.jsp를 톰캣이 Servlet으로 바꿀 때 EL을 Java코드로 바꿔줌)
		
		//		문법 : ${XXX }
		//			연산자 사용 가능
		//			형 변환 자동
		//			값이 없으면 그냥 넘어감
		//			impirt가 없어도 됨
		
		//		파라미터값 읽기 : ${param.파라미터명 } (param -> 파라미터)
		
		//		어트리뷰트값 읽기 (int, double, String, ... 포함) - 기본 자료형
		//			: ${어트리뷰트명 }
		
		//		어트리뷰트값 읽기(객체)
		//			주소값 - ${어트리뷰트명 }
		//			속성값 - ${어트리뷰트명.멤버변수명 }
		
		//		어트리뷰트값 읽기(List, [])
		//			AL / [] 자체			- ${어트리뷰트명 }
		//			인덱스 위치의 객체		- ${어트리뷰트명[인덱스] }
		//			인덱스 위치의 객체 속성 - ${어트리뷰트명[인덱스].멤버변수명 }
		
		//			반복문, 조건문 - EL (X) / CustomTag (O)
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
	
	<!-- ArrayList의 객체들의 이름과 나이 값 출력하기 -->
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
	${param.x * param.y } <br> <!-- 연산 가능 ! -->
	${z } <br>
	<hr>
	${d.name } : ${d.age } : ${d.height } : ${d.weight } <br>
	<hr>
	Nope : ${param.dasdsadjqkwejqlkdasd } <!-- 값이 없을 때 -->
	<hr>
	${dvs } <br>
	${dvs[1] } <br>
	${dvs[2].name }, ${dvs[3].age } <br>
	
	
	
</body>
</html>