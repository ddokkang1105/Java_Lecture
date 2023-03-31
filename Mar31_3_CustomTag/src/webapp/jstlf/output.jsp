<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- core�� �־������ fmt�� �� �� �ִ� ? (X) -->
<!-- core, fmt �� �� �����ͼ� ���� ������ ���� (c, fmt ��� ����) -->
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
	<!-- fmt : ���ڿ� / ��¥ / �Ҽ��� ���¸� ������ -->
	<fmt:formatNumber value="${a }" type="number" /> <!-- ���� -->
	<hr>
	<fmt:formatNumber value="${a }" type="currency" /> <!-- ��ȭ(ȭ��) -->
	<hr>
	<fmt:formatNumber value="${a }" type="currency" currencySymbol="$"/> <!-- ��ȭ(ȭ��) -->
	<hr>
	<fmt:formatNumber value="${b }" type="percent" /> <!-- �ۼ�Ʈ (�Ҽ��� �ݿø�) -->
	<hr>
	<fmt:formatNumber value="${c }" pattern="#.00" /> <!-- �Ҽ��� ��°�ڸ����� (�ݿø�) -->
	<hr>

	<!-- Date �Ӽ�
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
	 <!-- ���� -->
	 <fmt:formatDate value="${d }" pattern="yyyy-MM-dd E a hh" />
	 <hr>
	 
	 <!-- ���� ����Ʈ��...
	 	�̸� - ���� (��ȭ ǥ�ñ���) - ������� (��¹�� �˾Ƽ�)
	  -->
	  
	  <c:forEach var="s" items="${s }">
	  	${s.name } - 
	  	��<fmt:formatNumber value="${s.price }" pattern="#" /> - 
	  	<fmt:formatDate value="${s.exp }" pattern="dd/MM/yyyy (E) a hh:mm" />
	  	<br>
	  </c:forEach>
	 	
</body>
</html>