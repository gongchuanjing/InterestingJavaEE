<%@page import="tk.chuanjing.chapter12.login.User"%>
<%@page import="tk.chuanjing.utils.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>商品列表</title>
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
		<script src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css" type="text/css" />

		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
				width: 100%;
			}
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
	</head>

	<body>
		<br />
		<div class="row" style="width:1210px; margin:0 auto;">
			
			<div class="col-md-2">
				<a href="${ pageContext.request.contextPath }/ProductBrowseHistoryServlet?id=1">
					<img src="${ pageContext.request.contextPath }/images/products/cs10001.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="${ pageContext.request.contextPath }/ProductBrowseHistoryServlet?id=1" style='color:green'>毛衣</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>

			<div class="col-md-2">
				<a href="${ pageContext.request.contextPath }/ProductBrowseHistoryServlet?id=2">
					<img src="${ pageContext.request.contextPath }/images/products/cs10002.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="${ pageContext.request.contextPath }/ProductBrowseHistoryServlet?id=2" style='color:green'>大衣</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>

			<div class="col-md-2">
				<a href="${ pageContext.request.contextPath }/ProductBrowseHistoryServlet?id=3">
					<img src="${ pageContext.request.contextPath }/images/products/cs10003.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="${ pageContext.request.contextPath }/ProductBrowseHistoryServlet?id=3" style='color:green'>新款LV</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>

			<div class="col-md-2">
				<a href="${ pageContext.request.contextPath }/ProductBrowseHistoryServlet?id=4">
					<img src="${ pageContext.request.contextPath }/images/products/cs10004.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="${ pageContext.request.contextPath }/ProductBrowseHistoryServlet?id=4" style='color:green'>连衣裙</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>
			
			<div class="col-md-2">
				<a href="${ pageContext.request.contextPath }/ProductBrowseHistoryServlet?id=5">
					<img src="${ pageContext.request.contextPath }/images/products/cs10005.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="${ pageContext.request.contextPath }/ProductBrowseHistoryServlet?id=5" style='color:green'>风衣</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>

			<div class="col-md-2">
				<a href="${ pageContext.request.contextPath }/ProductBrowseHistoryServlet?id=6">
					<img src="${ pageContext.request.contextPath }/images/products/cs10006.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="${ pageContext.request.contextPath }/ProductBrowseHistoryServlet?id=6" style='color:green'>小帽</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>
		</div>

		<!-- 商品浏览记录 -->
		<div style="width:1210px;margin:0 auto; padding: 0 9px;border: 1px solid #ddd;border-top: 2px solid #999;height: 246px;">
			<h4 style="width: 50%;float: left;font: 14px/30px " 微软雅黑 ";">浏览记录</h4>
			<div style="clear: both;"></div>
			<div style="overflow: hidden;">
				<a href="${ pageContext.request.contextPath }/ProductBrowseHistoryClearServlet">清除浏览记录</a>
				<ul style="list-style: none;">
					
					<%
					 	Cookie[] cookies = request.getCookies();
					 	Cookie historyCookie = CookieUtils.findCookie(cookies, "history");
					 	if(historyCookie == null) {
					 %>	
					 
					 <h4>您还没有浏览商品！！</h4>
					 
					 <%
					 	} else {
					 		String historyID = historyCookie.getValue();
						 	String[] historyIDs = historyID.split("-");
						 	for(String id : historyIDs) {
					 %>
					 
					 <li style="width: 150px;height: 216;float: left;margin: 0 8px 0 0;padding: 0 18px 15px;text-align: center;"><img src="${ pageContext.request.contextPath }/images/products/cs1000<%=id %>.jpg" width="130px" height="130px" /></li>
					 
					 <% 	
						 	}
					 	}
					 %>
					
				</ul>

			</div>
		</div>
		
	</body>
</html>