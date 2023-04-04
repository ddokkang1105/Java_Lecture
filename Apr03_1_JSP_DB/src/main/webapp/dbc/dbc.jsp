<%@page import="com.ddokkang.db.manager.DdokkangDBManager"%>
<%@page import="java.sql.Connection"%>
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
		// ��Ĺ�� Ʃ��뿩�� ������ �� �� �˾Ƽ�
		// Ʃ�� = Connection ��ü
		
		// ���� : DriverManager.getConnection()�� �����ϴ� ����
		//	���õ� ��� �۾��� �ؼ� Connection ��ü�� ����� �� => ����
		
		// Ŀ�ؼ�Ǯ : �̸� Connection ��ü X 100���� ����� ����
		//	Ŭ���̾�Ʈ�� ��û�ϸ� => ��������� �ϳ� �ָ� �� => ����
		
		// ���� - context.xml(���赵, �����ȹ�� �ʳ�)
		// Servers - context.xml
		//	���� �ǵ��... ��ũ�����̽� �ȿ� �ִ� ��~~~�� ������Ʈ�� �� ���� !!
		//	������Ʈ�� �ٸ��� => DB������ �ٸ���
		
		// �츮�� ���� context.xml�� �� ������Ʈ�� META-INF������ ���� !
		
		String result = "Fail";
		
		Connection con = null;
		try {
			con = DdokkangDBManager.connect("ddokkangPool");
			result = "Success";
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		DdokkangDBManager.close(con, null, null);
	
	%>
	<h1>DB Connect</h1>
	<h1><%=result %></h1>
</body>
</html>