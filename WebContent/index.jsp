<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>请选择</title>
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
		<!--
		<script src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
		-->
	</head>
	<body>
		<div style="padding-top:10px" align="center">
			<ol class="list-inline">
				<c:if test="${ empty existUser }">
					<li><a href="${ pageContext.request.contextPath }/html/chapter21/loginTestAutoLoginFilter.html">登录</a></li>
					<li><a href="${ pageContext.request.contextPath }/html/chapter13/register.html">注册</a></li>
				</c:if>
				
				<c:if test="${ not empty existUser }">
					<li>您好：${ existUser.username }</li>
					<li><a href="#">退出</a></li>
					<li><a href="#">我的订单</a></li>
				</c:if>
				
				<li><a href="${ pageContext.request.contextPath }/jsp/chapter15/product_list.jsp">商品列表</a></li>
			</ol>
		</div>
		
		<h4>chapter12</h4>
		<a href="${ pageContext.request.contextPath }/html/chapter12/login/login.html">chapter12(login)</a><br/>
		
		<h4>chapter13</h4>
		<a href="${ pageContext.request.contextPath }/html/chapter13/download.html">chapter13(download)</a><br/>
		<a href="${ pageContext.request.contextPath }/RequestDemo01Servlet">chapter13(RequestDemo01Servlet)</a><br/>
		<a href="${ pageContext.request.contextPath }/html/chapter13/register.html">chapter13(register)</a><br/>
		<a href="${ pageContext.request.contextPath }/html/chapter13/requestDemo02.html">chapter13(requestDemo02)</a><br/>
		<a href="${ pageContext.request.contextPath }/RedirectAndForward01Servlet">chapter13(RedirectAndForward01Servlet)</a><br/>
		
		<h4>chapter14</h4>
		<a href="${ pageContext.request.contextPath }/html/chapter12/login/login.html">chapter14(记录最后一次访问时间，用的chapter12的login页面)</a><br/>
		<a href="${ pageContext.request.contextPath }/jsp/chapter14/cookie/product_list.jsp">chapter14(商品浏览记录)</a><br/>
		
		<h4>chapter15</h4>
		<a href="${ pageContext.request.contextPath }/jsp/chapter15/product_list.jsp">chapter15(使用session技术的简单  购物车)</a><br/>
		<a href="${ pageContext.request.contextPath }/jsp/chapter15/loginCheckCodeImg.jsp">chapter15(带验证码的登陆)</a><br/>
		
		<h4>chapter16</h4>
		<a href="${ pageContext.request.contextPath }/ProductShowServlet">chapter16(使用EL、JSTL 将商品信息显示到页面)</a><br/>
		<a href="${ pageContext.request.contextPath }/jsp/chapter16/model/Model1Demo1.jsp">chapter16(Model1)</a><br/>
		<a href="${ pageContext.request.contextPath }/jsp/chapter16/model/Model2Demo1.jsp">chapter16(Model2)</a><br/>
		
		<h4>chapter19</h4>
		<a href="${ pageContext.request.contextPath }/jsp/chapter19/ajax_get_post.jsp">chapter19(ajax_get_post)</a><br/>
		<a href="${ pageContext.request.contextPath }/jsp/chapter19/checkUserName.jsp">chapter19(checkUserName)</a><br/>
		<a href="${ pageContext.request.contextPath }/jsp/chapter19/checkUserNameJquery.jsp">chapter19(checkUserNameJquery)</a><br/>
		<a href="${ pageContext.request.contextPath }/jsp/chapter19/searchWord.jsp">chapter19(searchWord)</a><br/>
		<a href="${ pageContext.request.contextPath }/ProvinceAndCityGetProvinceServlet">chapter19(省市二级联动)</a><br/>
		
		<h4>chapter21</h4>
		<a href="${ pageContext.request.contextPath }/jsp/chapter21/TestGenericEncoding.jsp">chapter21(GenericEncoding)</a><br/>
		<a href="${ pageContext.request.contextPath }/html/chapter21/loginTestAutoLoginFilter.html">chapter21(AutoLogin)</a><br/>
		
		<h4>chapter22</h4>
		<a href="${ pageContext.request.contextPath }/jsp/chapter22/fileUpload.jsp">chapter22(使用fileUpload第三方jar包上传文件)</a><br/>
	</body>
</html>