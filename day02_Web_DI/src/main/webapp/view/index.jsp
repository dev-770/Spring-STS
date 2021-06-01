<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.ict.edu.Hello"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- Servlet : 자바 코드에 HTML, CSS, JavaScript를 삽입 --%>]
	<%-- JSP : HTML, CSS, JavaScript 코드에 자바를 삽입 --%>

	<%-- WEB에서 DI 사용하는 방법 --%>
	<%--
		1. 설정 정보인 config.xml를 applicationContext.xml 변경해서 사용
			위치와 이름 변경하면 오류 발생
			(나중에는 web.xml를 이용해서 변경가능)
			WEB-INF 안에 applicationContext.xml 로 만들어야 한다.
		2. ApplicationContext.xml를 읽기 위한 리스너를 만들어야 한다.
			리스너는 프로젝트당 하나만 존재한다.
			만드는 방법은 두가지이다.
			1) 자바에서 만드는 방법
				-- pom.xml에서 Spring web 추가해야 된다.
				https://mvnrepository.com/ 사이트에 찾아서 추가한다.
			2) web.xml에서 만드는 방법
			
		3. Web에 맞는 자바 코딩
	 --%>
	 <%
	 	WebApplicationContext context = 
	 			WebApplicationContextUtils.getWebApplicationContext(application);
	 			
		 Hello hello = (Hello) context.getBean("hello");
		String msg = hello.sayHello();
		out.println(msg);
	 %>
</body>
</html>