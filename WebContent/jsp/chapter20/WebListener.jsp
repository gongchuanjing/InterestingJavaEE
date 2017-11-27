<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" 
	import="tk.chuanjing.chapter20.listener.Bean1"
	import="tk.chuanjing.chapter20.listener.Bean2"
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'AttributeListener.jsp' starting page</title>
    
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
  	<h2>AttributeListener属性的添加   替换    移除 监听</h2>
    <%
    	session.setAttribute("name", "张三");// 属性的添加
    	session.setAttribute("name", "李四");// 属性的替换
    	session.removeAttribute("name");// 属性的移除.
    %>
    
    
  	<h2>HttpSessionBindingListener   Bean和session绑定/解除绑定</h2>
  	<%
  		Bean1 b = new Bean1();
  		session.setAttribute("b", b);// 绑定
  		session.removeAttribute("b");// 解除绑定
  	%>
  	
  	
  	<h2>HttpSessionAttributeListener   Bean和session钝化/活化</h2>
  	<%
  		Bean2 b2 = new Bean2("刘大霞");
  		session.setAttribute("b2", b2);
  	%>
  	${ b2.name }
  </body>
</html>
