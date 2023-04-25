<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script type="text/javascript" src="jQuery.js"></script>
<script type="text/javascript">
	$(function() {
		// alert('asd');
		
		let s = $('.slider').bxSlider({
			mode: 'fade',
			speed: 100,
			caption: true,
			auto: true,
			autoDelay: 300,
			controls: true,
			slideWidth: 300
		});
		
		
		// 962c476d368e7ab9b964e93fa271060b
		$("button").click(function() {
			let iVal = $("input").val();
			
			// $.getJSON() 요청 헤더에 대한 기능이 없어서 => 처리를 못해요... ㅠㅠ
			$.ajax({
				url: "https://dapi.kakao.com/v3/search/book",
				data: {query : iVal},
				beforeSend: function(req) {	// 요청 보내기 전에 콜백함수
					req.setRequestHeader("Authorization", "KakaoAK 962c476d368e7ab9b964e93fa271060b");
				},
				success: function(bookJSON) {
					// alert(JSON.stringify(bookJSON));
					
					// 테이블 구성할건데...
					// 이미지 사진 / 책제목 - 출판사 / 정가 / 판매가
					
					$("table").empty();
					$(".slider").empty();
					
					$.each(bookJSON.documents, function(i, b) {
						// alert(b.title);
						// let td1 = $("<td></td>").text(b_thumbnail);
						// 속성을 건드릴때는 attr()
						let img = $("<img>").attr("src", b.thumbnail);
						let td1 = $("<td></td>").append(img);
						let td2 = $("<td></td>").text(b.title + " - " + b.publisher);
						let td3 = $("<td></td>").text(b.price);
						let td4 = $("<td></td>").text(b.sale_price);
						
						let tr = $("<tr></tr>").append(td1, td2, td3, td4);
						$("table").append(tr);
						
						let img2 = $("<img>").attr("src", b.thumbnail).attr("title", b.title);
						let div = $("<div></div>").append(img2);
						$(".slider").append(div);
					});
	
					s.reloadSlider();				
					
					let th1 = $("<th></th>").text("img");
					let th2 = $("<th></th>").text("title");
					let th3 = $("<th></th>").text("price");
					let th4 = $("<th></th>").text("sale_price");
					
					let tr2 = $("<tr></tr>").append(th1, th2, th3, th4);
					$("table").prepend(tr2);
					
				}
			});
		});
		$("input").keyup(function() {
			$("button").trigger("click");
		})
	});


</script>
</head>
<body>
	<input> <button>찾기</button>
	<hr>
	<div class="slider"></div>
	<hr>
	<table border="1"></table>
</body>
</html>