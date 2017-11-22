<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>转账-事务</title>
	</head>
	<body>
		<h1>转账页面</h1>
		<form action="${ pageContext.request.contextPath }/AccountServlet" method="post">
			付款人:<input type="text" name="from"><br/>
			收款人:<input type="text" name="to"><br/>
			转账金额:<input type="text" name="money"><br/>
			<input type="submit" value="转账">
		</form>
	</body>
</html>