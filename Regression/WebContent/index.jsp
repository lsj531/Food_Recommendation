<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회귀 학습</title>
</head>
<body>
	<h1>당신의 취향을 선택하세요.</h1>

	<form action="regression" method='post'>
		맛&nbsp;&nbsp; <input type='checkbox' name='x1' value='1' />매운맛&nbsp; 
		<input type='checkbox' name='x2' value='1' />단맛&nbsp; 
		<input type='checkbox' name='x3' value='1' />짠맛&nbsp;
		<input type='checkbox' name='x4' value='1' />신맛&nbsp;
		<input type='checkbox' name='x5' value='1' />느끼한맛&nbsp;
		<input type='checkbox' name='x6' value='1' />알싸한맛&nbsp;
		<input type='checkbox' name='x7' value='1' />퍽퍽한맛&nbsp;<br>
		<hr>
		재료(고기)&nbsp; <input type='checkbox' name='x8' value='1' />닭고기&nbsp; 
		<input type='checkbox' name='x9' value='1' />돼지고기&nbsp;<br>
		<hr>
		재료(기타) <input type='checkbox' name='x10' value='1' />면&nbsp; 
		<input type='checkbox' name='x11' value='1' />떡&nbsp;<br>

		<p>취향 분석을 실시하시겠습니까?</p>
		<input type='submit' value='시작' onclick='location.href=\"/ml/regression"' />
		<input type='button' value='취소' onclick='location.href="/Proto/index.jsp"' />
	</form>
</body>
</html>