<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>결과보기</h2>
	<h3>
		<li>올린 사람 : ${name }</li>
		<li>파일이름1 : ${file_name1 }</li>
		<li>파일이름2 : ${file_name2 }</li>
		<li>파일이름3: ${file_name3 }</li>
		<li>파일종류 : ${contentType }</li>
		<li>파일크기 : ${filesize }KB</li>
		<li>수정날짜1 : ${date }</li>
		<li>수정날짜2 : ${fdate }</li>
		
		<li><img src="resources/upload/${file_name2 }" style="width: 100px"></li>
		<li>다운로드 : <a href="down.do?file_name=${file_name2 }">${file_name2 }</a>
	</h3>
</body>
</html>