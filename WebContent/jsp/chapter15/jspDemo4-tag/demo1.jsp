<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Demo1.jsp</h1>
<jsp:forward page="/jsp/chapter15/jspDemo4-tag/demo2.jsp">
	<jsp:param value="aaa" name="name"/>
</jsp:forward>
</body>
</html>