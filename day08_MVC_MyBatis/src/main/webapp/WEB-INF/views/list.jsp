<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{
	text-align: center; margin: 100px; auto;
	}
	table {
	width: 600px;
	margin: 0 auto;
	border-collapse: collapse;
	text-align: center;
	}
	table, th, td { border: 1px solid skyblue;}
	h1 { text-align: center;}
	a { text-decoration: none;}
</style>
</head>
<body>
	<div>
		<h1> 전체 정보 보기 </h1>
		<p> [<a href="join.do">인원추가하기</a>] </p>
		<table>
			<thead>
				<tr>
					<th> 번호 </th> <th> 아이디 </th> <th> 이름 </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="k" items="${list }">
					<tr>
						<td>${k.idx } </a></td>
						<td> <a href="detail.do?idx=${k.idx }">${k.id }</td>
						<td>${k.name }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>