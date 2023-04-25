<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/input.css">
</head>
<body>
	<h1>단 위 변 환</h1>
<!-- 	<div>
	<form action="convert.do">
	<div id="inputNum">숫자 : <input autocomplete="off" autofocus="autofocus" name="x"> <br><br></div>
		<div><select name="s_conv">
			<option value="1">cm → inch</option>
			<option value="2">㎡ → 평</option>
			<option value="3">℃ → ℉</option>
			<option value="4">mi/h → km/h</option>
		</select></div>
		<div><button>변♬환</button></div>	
	</form>
	</div>
 -->
	<div>
	<form action="unit.convert">
	<div id="inputNum">숫자 : <input autocomplete="off" autofocus="autofocus" name="n1"> <br><br></div>
		<div><select name="what">
			<option value="l">cm → inch</option>
			<option value="d">㎡ → 평</option>
			<option value="t">℃ → ℉</option>
			<option value="v">mi/h → km/h</option>
		</select></div>
		<div><button>변♬환</button></div>	
	</form>
	</div>
</body>
</html>