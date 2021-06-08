<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>배열 결과나 컬렉션 결과보기</h2>
	<h3>
		배열결과 <br>
		<c:forEach var="k" items="${dogName }">
			<li> ${k } </li>
		</c:forEach>
		<hr>
		컬렉션 결과 <br>
		<c:forEach var="k" items="${carName }">
			<li> ${k } </li>
		</c:forEach>
	</h3>
</body>
</html>