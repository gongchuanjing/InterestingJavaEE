<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>演示JSP的注释</h1>

<!-- HTML的注释：存在JSP源码中,存在于JSP翻译后的Servlet中,存在于生成的HTML中 -->

<%
	// 单行注释 存在于JSP的源代码中,翻译成Servlet后 注释也存在.但是当执行完JSP后生成HTML后,注释就消失了
	
	/*
		多行注释
	*/
	
	/**
		文档注释
	*/
%>

<%-- JSP的注释 ：只会存在于 JSP的源代码中.翻译成Servlet后,JSP的注释就消失了. --%>

<%
	int a = 3;
%>

<%-- a+=10; --%>

<%=a %>
</body>
</html>