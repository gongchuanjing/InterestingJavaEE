<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title>会员登录</title>
		
		<script type="text/javascript">
		 	function changeCodeImg() {
		 		document.getElementById("img1").src="/InterestingJavaEE/CheckCodeImgServlet?time="+new Date().getTime();
		 	};
 		</script>
	</head>
	
	<body>
		<br />
		${ msg }
		<form action="/InterestingJavaEE/CheckCodeImgLoginServlet" method="post">
			
			账号:
			<input type="text" id="username" name="username" placeholder="请输入账号">
			<br/>
			
			密码:
			<input type="password" id="password" name="password" placeholder="请输入密码">
			<br/>
			
			验证码:
			<input type="text" id="code" name="code" placeholder="请输入验证码">
		    <img id="img1" src="/InterestingJavaEE/CheckCodeImgServlet" onclick="changeCodeImg()"/>
			     
		     <div>
			    <input type="submit"  width="100" value="登录" name="submit">
		    </div>
		</form>
	</body>
</html>