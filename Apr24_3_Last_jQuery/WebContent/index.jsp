<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jQuery.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="text.js"></script>
</head>
<body>
	<!-- 
		회원가입
		id / pw / pw확인 / 이름 / 우편번호, 주소, 상세주소 / 버튼
	 -->
	 <table>
	 	<tr>
	 		<td>
				id : <input>	 		
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>
				pw : <input type="password">	 		
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>
				pw확인 : <input type="password">	 		
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>
				이름 : <input>	 		
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>
				addr : <input id="addr1" readonly="readonly"> <br>
				<input id="addr2" readonly="readonly"> <br>	 		
	 		 	<input>
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>
				<button>버튼</button>	 		
	 		</td>
	 	</tr>
	 </table>
	 
</body>
</html>