<%@ page language="java" import="java.util.*" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>管理平台</title>
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
    <h1>商品后台管理系统</h1>
    <h3><a href="${ pageContext.request.contextPath }/ProductFindAllServlet">查询所有商品</a></h3>
    <h3><a href="${ pageContext.request.contextPath }/ProductFindByPageServlet?currPage=1">分页查询商品</a></h3>
  </body>
</html>
