<%@page import="com.ict.edu.DAO"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.ict.edu.VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	VO vo = new VO();
	vo.setIdx(request.getParameter("idx"));
	vo.setName(request.getParameter("name"));	
	vo.setAge(request.getParameter("age"));
	vo.setReg(request.getParameter("reg"));

	
	WebApplicationContext context =
			WebApplicationContextUtils.getWebApplicationContext(application);
	DAO dao = (DAO)context.getBean("dao");
	
	int result = dao.getUpdate(vo.getIdx());
	System.out.println(vo.getIdx());
	System.out.println(vo.getName());
	System.out.println(vo.getAge());
	if (result > 0) {
		response.sendRedirect("detail.jsp?idx=" +vo.getIdx() );
	}
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