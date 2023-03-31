<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- core가 있어야지만 fmt를 쓸 수 있다 ? (X) -->
<!-- core, fmt 둘 다 가져와서 쓰는 경향이 있음 (c, fmt 사용 권장) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="en"/>
	<!-- fmt : 문자열 / 날짜 / 소수점 형태를 포맷팅 -->
	<fmt:formatNumber value="${a }" type="number" /> <!-- 숫자 -->
	<hr>
	<fmt:formatNumber value="${a }" type="currency" /> <!-- 통화(화폐) -->
	<hr>
	<fmt:formatNumber value="${a }" type="currency" currencySymbol="$"/> <!-- 통화(화폐) -->
	<hr>
	<fmt:formatNumber value="${b }" type="percent" /> <!-- 퍼센트 (소수점 반올림) -->
	<hr>
	<fmt:formatNumber value="${c }" pattern="#.00" /> <!-- 소수점 둘째자리까지 (반올림) -->
	<hr>

	<!-- Date 속성
		: type = "date / time / both"
			1. date 
				dateStyle = "short / long"
			2. time
				timeStyle = "short / long"
			3. both
				dateStyle = "short / long"
				timeStyle = "short / long"
	 -->
	 <fmt:formatDate value="${d }" type="both" dateStyle="long" timeStyle="short" />
	 <hr>
	 <!-- 패턴 -->
	 <fmt:formatDate value="${d }" pattern="yyyy-MM-dd E a hh" />
	 <hr>
	 
	 <!-- 과자 리스트들...
	 	이름 - 가격 (원화 표시까지) - 유통기한 (출력방식 알아서)
	  -->
	  
	  <c:forEach var="s" items="${s }">
	  	${s.name } - 
	  	￦<fmt:formatNumber value="${s.price }" pattern="#" /> - 
	  	<fmt:formatDate value="${s.exp }" pattern="dd/MM/yyyy (E) a hh:mm" />
	  	<br>
	  </c:forEach>
	 	
</body>
</html>