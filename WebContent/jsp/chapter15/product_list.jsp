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
				<a href="${ pageContext.request.contextPath }/html/chapter15/product_info.html">
					<img src="${ pageContext.request.contextPath }/images/products/cs10001.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="${ pageContext.request.contextPath }/html/chapter15/product_info.html" style='color:green'>毛衣</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>

			<div class="col-md-2">
				<a href="${ pageContext.request.contextPath }/html/chapter15/product_info2.html">
					<img src="${ pageContext.request.contextPath }/images/products/cs10002.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="${ pageContext.request.contextPath }/html/chapter15/product_info2.html" style='color:green'>大衣</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>
		</div>
	</body>
</html>