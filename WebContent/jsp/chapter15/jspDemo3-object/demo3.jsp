<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP的内置对象-pageContext-demo3.jsp</h1>

<!-- 在当前页面获取四个域的值 -->
<%= pageContext.getAttribute("pname") %>
<%= request.getAttribute("rname") %>
<%= session.getAttribute("sname") %>
<%= application.getAttribute("aname") %>

</body>
</html>