<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2> 결과 확인 </h2>
		<h3>
			<li> 이름 : ${mvo.name }</li>
			<li> 국어 : ${mvo.kor }</li>
			<li> 영어 : ${mvo.eng }</li>
			<li> 수학 : ${mvo.math }</li>
			<li> 총점 : ${sum }</li>
			<li> 평균 : ${avg }</li>
			<li> 학점 : ${grad }</li>
		</h3>
	</div>
</body>
</html>