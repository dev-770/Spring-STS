<%@page import="com.ict.edu.DAO"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.ict.edu.VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	VO vo = new VO();
	vo.setId(request.getParameter("id"));
	vo.setId(request.getParameter("pw"));
	vo.setId(request.getParameter("name"));
	vo.setId(request.getParameter("age"));
	
	// DB 처리를 위해서 DAO 호출
	WebApplicationContext context =
		WebApplicationContextUtils.getWebApplicationContext(application);
	DAO dao = (DAO) context.getBean("dao");
	
	int result = dao.getInsert(vo);
	pageContext.setAttribute("result", result);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>