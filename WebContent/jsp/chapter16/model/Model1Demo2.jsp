<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'Model1Demo2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
		// 接收数据:
	/* 	String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 封装数据:
		User user = new User();
		user.setUsername(username);
		user.setPassword(password); */
	%>
	
	<jsp:useBean id="user" class="tk.chuanjing.chapter16.model.UserChapter16" scope="page"></jsp:useBean>

	<%--
	<jsp:setProperty property="username" name="user"/>
	<jsp:setProperty property="password" name="user"/>
	--%>
	<jsp:setProperty property="*" name="user"/>
	
	<jsp:getProperty property="username" name="user"/>
	<jsp:getProperty property="password" name="user"/>
  </body>
</html>
