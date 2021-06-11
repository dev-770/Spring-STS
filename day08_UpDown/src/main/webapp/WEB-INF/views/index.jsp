<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 파일 업로드를 하기 위해서는 post, multipart/form-data 지정 --%>
	<%-- pom.xml에서 라이브러리 추가 (fileupload, IO) --%>
	<form action="f_up.do" method="post" enctype="multipart/form-data">
		<p>올린 사람 : <input type="text" name="name"></p>
		<p>업로드 : <input type="file" name="file_name"></p>
		<input type="submit" value="업로드">
	</form>
</body>
</html>