<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL的功能二:执行运算</title>
</head>
<body>
<h1>EL的功能二:执行运算</h1>

<h3>EL执行算数运算</h3>
<%
	pageContext.setAttribute("n1", "10");
	pageContext.setAttribute("n2", "20");
	pageContext.setAttribute("n3", "30");
	pageContext.setAttribute("n4", "40");
%>
${ n1 + n2 + n3 }

<h3>EL执行逻辑运算</h3>
${ n1 < n2 } - ${ n1 lt n2 } <!-- less than --><br/>
${ n1 > n2 } - ${ n1 gt n2 } <!-- great than --><br/>
${ n1 <= n2 } - ${ n1 le n2 } <!-- less equal --><br/>
${ n1 >= n2 } - ${ n1 ge n2 } <!-- great equal --><br/>
${ n1 == n2 } - ${ n1 eq n2 } <!-- equal --><br/>

<h3>EL执行关系运算</h3>
${ n1<n2 && n3 < n4 } - ${ n1<n2 and n3 < n4 }<br/>
${ n1<n2 || n3 < n4 } - ${ n1<n2 or n3 < n4 }<br/>
${ !(n1 < n2) } - ${ not(n1<n2) }

<h3>EL执行三元运算</h3>
${ n1 < n2 ? "正确":"错误" }

<h3>empty运算</h3>
${ user == null } - ${ empty user }
${ user != null } - ${ not empty user }

</body>
</html>