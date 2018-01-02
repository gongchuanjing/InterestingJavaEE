<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<body>
<h1>购物车列表</h1>
	<%
		Map<String, Integer> map = (Map<String, Integer>)request.getSession().getAttribute("cart");
		Set<String> keySet = map.keySet();	
		for(String name : keySet) {
			Integer count = map.get(name);
	%>
	
			<h4>你购买的商品是<%=name %>，对应购买的数量是<%=count %></h4>
	
	<%
		}
	%>
</body>
</html>