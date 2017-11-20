<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'ajax_get.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript">
		function ajax_get() {
			
			// 1.创建异步对象
			var xhr = createXMLHttp();

			// 2.设置状态改变的监听 回调函数.
			xhr.onreadystatechange = function(){
				
				// 请求发送成功
				if(xhr.readyState == 4){
					
					// 响应也成功
					if(xhr.status == 200){
						
						// 获得响应的数据,将数据写入到DIV中
						document.getElementById("d1").innerHTML = xhr.responseText;
					}
				}
			};
			
			// 3.设置请求路径
			xhr.open("GET","/InterestingJavaEE/AjaxGetPostDemoServlet?name=张三&pass=123",true);
			
			// 4.发送请求
			xhr.send(null);
		};
		
		function ajax_post() {
			var xhr = createXMLHttp();
			
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4) {
					if(xhr.status = 200) {
						document.getElementById("d2").innerHTML = xhr.responseText;
					}
				}
			};
			
			xhr.open("POST", "/InterestingJavaEE/AjaxGetPostDemoServlet", true);
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			
			// 发送请求
			xhr.send("name=张三&pass=123");
		};
		
		function createXMLHttp() {
			var xmlHttp;
			try { // Firefox, Opera 8.0+, Safari
				xmlHttp = new XMLHttpRequest();
			} catch (e) {
				try {// Internet Explorer
					xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
				} catch (e) {
					try {
						xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
					} catch (e) {
					}
				}
			}

			return xmlHttp;
		}
	</script>
  </head>
  
  <body>
  	<h1>AJAX的GET和POST方式的异步请求</h1>
    <div id="d1" style="width:100px;height:100px;border:1px solid blue"></div>
	<input type = "button" value="get提交" onclick="ajax_get()"/>
	
	
	<div id="d2" style="width:100px;height:100px;border:1px solid blue"></div>
	<input type = "button" value="post提交" onclick="ajax_post()"/>
  </body>
</html>
