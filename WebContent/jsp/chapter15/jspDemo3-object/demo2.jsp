<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP的内置对象-pageContext</h1>
<%
	// 获得其他8个内置对象.--主要在编写框架,通用性很高代码中.
	/* pageContext.setAttribute("pname", "pvalue");
	request.setAttribute("rname", "rvalue");
	session.setAttribute("sname", "svalue");
	application.setAttribute("aname", "avalue"); */
	pageContext.setAttribute("pname", "pvalue", PageContext.PAGE_SCOPE); // 等价于ageContext.setAttribute("pname", "pvalue");
	pageContext.setAttribute("rname", "rvalue", PageContext.REQUEST_SCOPE); // request.setAttribute("rname", "rvalue");
	pageContext.setAttribute("sname", "svalue", PageContext.SESSION_SCOPE); // session.setAttribute("sname", "svalue");
	pageContext.setAttribute("aname", "avalue", PageContext.APPLICATION_SCOPE); //application.setAttribute("aname", "avalue");
%>

<!-- 在当前页面获取四个域的值 -->
<%= pageContext.getAttribute("pname") %>
<%= request.getAttribute("rname") %>
<%= session.getAttribute("sname") %>
<%= application.getAttribute("aname") %>
<hr/>
<%= pageContext.getAttribute("pname", PageContext.PAGE_SCOPE) %>
<%= pageContext.getAttribute("rname", PageContext.REQUEST_SCOPE) %>
<%= pageContext.getAttribute("sname", PageContext.SESSION_SCOPE) %>
<%= pageContext.getAttribute("aname", PageContext.APPLICATION_SCOPE) %>
<hr/>
<%
 	pageContext.setAttribute("name", "pvalue");
	request.setAttribute("name", "rvalue");
	session.setAttribute("name", "svalue");
	application.setAttribute("name", "avalue"); 
%>
<%= pageContext.findAttribute("name") %>

<!-- 转发 -->
<% 
// request.getRequestDispatcher("/demo1-jsp/demo3-object/demo3.jsp").forward(request, response); 
// response.sendRedirect("/day12/demo1-jsp/demo3-object/demo3.jsp");
%>

</body>
</html>