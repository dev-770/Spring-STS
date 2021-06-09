<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="param.do" method="post">
		<p> 수1 : <input type="number" name="s1" required="required">
		<p> 수2 : <input type="number" name="s2" required="required">
		<p> 연산자 : 
		<input type="radio" name="op" value="+"> +	
		<input type="radio" name="op" value="-"> -
		<input type="radio" name="op" value="*"> *
		<input type="radio" name="op" value="/"> /
		</p>
		<p> 취미 :
		<input type="checkbox" name="hobby" value="운동"> 운동
		<input type="checkbox" name="hobby" value="게임"> 게임
		<input type="checkbox" name="hobby" value="영화"> 영화
		<input type="checkbox" name="hobby" value="독서"> 독서
		</p>
		<input type="submit" value="정보전달">
	</form>
</body>
</html>