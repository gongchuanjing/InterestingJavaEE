<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>嘿咻一下</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		$(function(){
			// 为文本框绑定事件
			$("#word").keyup(function(){
				
				// 获得文本框的值
				var word = $(this).val();
				
				if(word != "") {
					
					// 异步发送请求
					$.post("${ pageContext.request.contextPath }/SearchWordServlet",{"word":word},function(data){
						$("#d1").show().html(data);
					});
					
				} else {
					$("#d1").hide();
				}
				
			});
		});
	</script>
  </head>
  
  <body>
    <center>
    	<h1>嘿咻一下</h1>
    	<input type="text" id="word" name="word" style="width: 400px;height: 40px"/>
    	<input type="button" value="嘿咻一下" style="height: 40px"/>
    </center>
    <div id="d1" style="display:none;position:absolute;top:110px;left:445px;border:1px solid gray;width: 400px;height:200px"></div>
  </body>
</html>
