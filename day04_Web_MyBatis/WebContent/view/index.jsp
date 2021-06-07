<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ict.edu.VO"%>
<%@page import="java.util.List"%>
<%@page import="com.ict.edu.DAO"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%
	try {
	WebApplicationContext context = 
		WebApplicationContextUtils.getWebApplicationContext(application);
	DAO dao = (DAO) context.getBean("dao");
	List<VO> list = dao.getList();
	pageContext.setAttribute("list", list);
	}catch(Exception e) {
		System.out.println("에러 : " + e);
	}
%>

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
	<%
		WebApplicationContext context =
			WebApplicationContextUtils.getWebApplicationContext(application);
		DAO dao = (DAO) context.getBean("dao");
	%>
	<div>
		<h1> 전체 정보 보기 </h1>
		<p> [<a href="join.jsp">인원추가하기</a>] </p>
		<table>
			<thead>
				<tr>
					<th> 번호 </th> <th> 아이디 </th> <th> 이름 </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="k" items="${list }">
					<tr>
						<td> <a href="detail.jsp?idx=${k.idx }"> ${k.idx } </a></td>
						<td>${k.id }</td>
						<td>${k.name }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>