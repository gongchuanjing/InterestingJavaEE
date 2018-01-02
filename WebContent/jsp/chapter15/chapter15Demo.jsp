<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'day15_demo.jsp' starting page</title>
    
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
    
    	//九大内置对象
    	out.write(request.toString() + "\r\n");
    	out.write(response.toString() + "\r\n");
    	out.write(session.toString() + "\r\n");
    	out.write(application.toString() + "\r\n");
    	
    	out.write(page.toString() + "\r\n");
    	out.write(pageContext.toString() + "\r\n");
    	out.write(config.toString() + "\r\n");
    	out.write(out.toString() + "\r\n");
    	//out.write(exception.toString());   isErrorPage="true" 设置成true时exception才管用
    		
    			
    	//四大域对象  存值
    	pageContext.setAttribute("pname", "pvalue");
    	request.setAttribute("rname", "rvalue");
    	session.setAttribute("sname", "svalue");
    	application.setAttribute("aname", "avalue");
    	
    	// pageContext的查找
    	pageContext.findAttribute("pname");
    %>
    
    <hr/>
    <hr/>
    
    <%= "四大域对象  取值\r\n" %>
    <%= pageContext.getAttribute("pname") %>
    <%= request.getAttribute("rname") %>
    <%= session.getAttribute("sname") %>
    <%= application.getAttribute("aname") %>
    
    
    <hr/>
    
    <%
    	// 使用pageContext向四大域对象中存取值
    	pageContext.setAttribute("ppname", "ppvalue", PageContext.PAGE_SCOPE);
    	pageContext.setAttribute("rrname", "rrvalue", PageContext.REQUEST_SCOPE);
    	pageContext.setAttribute("ssname", "ssvalue", PageContext.SESSION_SCOPE);
    	pageContext.setAttribute("aaname", "aavalue", PageContext.APPLICATION_SCOPE);
    %>
    <%= pageContext.getAttribute("ppname", PageContext.PAGE_SCOPE) %>
    <%= pageContext.getAttribute("rrname", PageContext.REQUEST_SCOPE) %>
    <%= pageContext.getAttribute("ssname", PageContext.SESSION_SCOPE) %>
    <%= pageContext.getAttribute("aaname", PageContext.APPLICATION_SCOPE) %>
  </body>
</html>
