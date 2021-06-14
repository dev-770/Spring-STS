<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function list_go() {
		location.href="list.do";
	}
</script>
</head>
<body>
	<!-- <button onclick="list_go()">리스트</button> -->
	<c:redirect url="list.do"/>
</body>
</html>