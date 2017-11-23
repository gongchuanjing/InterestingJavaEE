<%@page import="tk.chuanjing.chapter18.utils.UUIDUtils"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加商品</title>
    
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
  		String token = UUIDUtils.getUUID();
  		session.setAttribute("token", token);
  	%>
    <div align="center">
    	<h1>添加商品</h1>
    	<form action="${ pageContext.request.contextPath }/ProductAddServlet" method="post">
    		<input type="hidden" name="token" value=<%= token %> />
    		<table border="1" width="50%">
    			<tr>
    				<td>商品名称</td>
    				<td><input type="text" name="pname"/></td>
    			</tr>
    			<tr>
    				<td>市场价格</td>
    				<td><input type="text" name="market_price"/></td>
    			</tr>
    			<tr>
    				<td>商城价格</td>
    				<td><input type="text" name="shop_price"/></td>
    			</tr>
    			<tr>
    				<td>是否热门</td>
    				<td><input type="radio" name="is_hot" value="1" checked="checked"/>是<input type="radio" name="is_hot" value="0"/>否</td>
    			</tr>
    			<tr>
    				<td>是否下架</td>
    				<td>
    					<select name="pflag">
    						<option value="0" selected="selected">否</option>
    						<option value="1">是</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>商品描述</td>
    				<td><textarea name="pdesc" cols="50" rows="4"></textarea></td>
    			</tr>
    			<tr>
    				<td>商品分类</td>
    				<td>
    					<select name="cid">
    						<option value="1">手机数码</option>
    						<option value="2">电脑办公</option>
							<option value="3">汽车用品</option>
							<option value="4">鞋靴箱包</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td colspan="2" align="center"><input type="submit" value="添加" /></td>
    			</tr>
    		</table>
    	</form>
    </div>
  </body>
</html>
