<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'list.jsp' starting page</title>
    
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
  	<h1>商品列表页面</h1>
    <table border="1" width="90%">
    	<tr>
    		<td>商品编号</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>是否热门</td>
			<td>商品描述</td>
    	</tr>
    	
    	<c:forEach var="p" items="${ list }">
    	
    		<tr>
    			<td>${ p.pid }</td>
    			<td>${ p.pname }</td>
    			<td>${ p.shop_price }</td>
    			
    			<td>
    				<c:if test="${ p.is_hot == 1 }">
    					热门商品
    				</c:if>
    				<c:if test="${ p.is_hot != 1 }">
    					不热
    				</c:if>
    			</td>
    			
    			<td>${ p.pdesc }</td>
    		</tr>
    		
    	</c:forEach>
    	
    </table>
  </body>
</html>
