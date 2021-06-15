<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 방법1. cos --%>
	<form action="fileup.do" method="post" enctype="multipart/form-data">
		<p>올린 사람 : <input type="text" name="name"></p>
		<p>첨부 파일 : <input type="file" name="file_name"></p>
		<input type="submit" value="업로드">
	</form>
	<hr>
	<%-- 아파치 사용 --%>
	<form action="fileup2.do" method="post" enctype="multipart/form-data">
		<p>올린 사람 : <input type="text" name="name"></p>
		<p>첨부 파일 : <input type="file" name="file_name"></p>
		<input type="submit" value="업로드">
	</form>
	
</body>
</html>