<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>文件上传</title>
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
   <!-- <form action="${ pageContext.request.contextPath }/UploadServlet" method="post" enctype="multipart/form-data"> -->
   <form action="${ pageContext.request.contextPath }/UploadServletPro" method="post" enctype="multipart/form-data">
   		用户名：<input name="username" /><br/>
 		email：<input name="email" /><br/> 
     	头像1：<input name="tou1" type="file"/><br/>
     	头像2：<input name="tou2" type="file"/><br/>
    	<input type="submit" value="上传"/>
   </form>
  </body>
</html>