<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jQuery.js"></script>
<script type="text/javascript">

	// AJAX -JavaScript-> 웹브라우저
	//	브라우저의 동일출처정책에 걸리기 때문에
	//	AJAX은 다른사람의 것을 가져올 수 없습니다...
	//		'동일출처정책'
	//			: 웹과 상호작용을 하는 JavaScript 코드에 대한 '보안' 정책
	
	// Cross-Domain AJAX - 브라우저의 동일출처정책을 뚫어버린느 AJAX
	//		다른사람이 만든거 가져오는 AJAX
	
	//		[서버측에서 다른사람에게 주고 싶다면]
	//			1) JSONP (JSON with padding)
	//				일부러 JSON모양을 뭉개서 JSON이 아닌것처럼 => AJAX가 아니게
	//			2) 응답 헤더 : Access-Control-Allow-Origin 세팅
	
	//		[서버측에서 CrossDomain을 허용하지 않았다면...]

	$(function() {
		// alert('aa');
		
		// Error 메시지 JSON형태 데이터 전체를 여기에 alert으로 출력
		// url 주소 : http://localhost/top-level-package/나올 주소값...
		
		$.getJSON("http://localhost:8082/apr201/error.getJSON", function(asd) {
			alert(JSON.stringify(asd));
			// alert('aaa');
			$.each(asd.error, function(i, e) {
				// alert(e.e_what);
				// alert(e.e_where);
				alert(e.e_what + " - " + e.e_where);
			})
		});
		
	});
</script>
</head>
<body>
	
</body>
</html>